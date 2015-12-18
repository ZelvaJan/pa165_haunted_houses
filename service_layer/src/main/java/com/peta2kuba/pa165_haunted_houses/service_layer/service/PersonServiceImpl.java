package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.dao.PersonDao;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author petr.melicherik
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public void createPerson(Person person) {
        person.setPassword(createHash(person.getPassword()));
        personDao.create(person);
    }

    @Override
    public void editPerson(Person personEdit) {
        Person person = findPersonById(personEdit.getId());
        person.setEmail(personEdit.getEmail());
        person.setAdmin(personEdit.isAdmin());
        if (personEdit.getPassword() != null && !personEdit.getPassword().isEmpty()) {
            person.setPassword(createHash(personEdit.getPassword()));
        }
        personDao.edit(person);
    }

    @Override
    public void removePerson(Person person) {
        personDao.remove(person);
    }

    @Override
    public Person findPersonById(Long id) {
        return personDao.findById(id);
    }

    @Override
    public Person findPersonByEmail(String email) {
        return personDao.findByEmail(email);
    }

    @Override
    public List<Person> findAllPersons() {
        return personDao.findAll();
    }

    @Override
    public boolean isAdmin(Person person) {
        if (person == null) {
            return false;
        } else {
            return findPersonById(person.getId()).isAdmin();
        }
    }

    @Override
    public boolean authenticate(String email, String passwordTyped) {
        Person person = findPersonByEmail(email);
        if (person == null || passwordTyped == null) {
            return false;
        } else {
            return validatePassword(passwordTyped, person.getPassword());
        }
    }

    //see  https://crackstation.net/hashing-security.htm#javasourcecode
    public static String createHash(String password) {
        final int SALT_BYTE_SIZE = 24;
        final int HASH_BYTE_SIZE = 24;
        final int PBKDF2_ITERATIONS = 1000;
        // Generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_BYTE_SIZE];
        random.nextBytes(salt);
        // Hash the password
        byte[] hash = pbkdf2(password.toCharArray(), salt, PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
        // format iterations:salt:hash
        return PBKDF2_ITERATIONS + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] fromHex(String hex) {
        byte[] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return binary;
    }

    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        return paddingLength > 0 ? String.format("%0" + paddingLength + "d", 0) + hex : hex;
    }

    /**
     * Compares two byte arrays in length-constant time. This comparison method
     * is used so that password hashes cannot be extracted from an on-line
     * system using a timing attack and then attacked off-line.
     *
     * @param a the first byte array
     * @param b the second byte array
     * @return true if both byte arrays are the same, false if not
     */
    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }

    public static boolean validatePassword(String password, String correctHash) {
        if (password == null) {
            return false;
        }
        if (correctHash == null) {
            throw new IllegalArgumentException("password hash is null");
        }
        String[] params = correctHash.split(":");
        int iterations = Integer.parseInt(params[0]);
        byte[] salt = fromHex(params[1]);
        byte[] hash = fromHex(params[2]);
        byte[] testHash = pbkdf2(password.toCharArray(), salt, iterations, hash.length);
        return slowEquals(hash, testHash);
    }
}
