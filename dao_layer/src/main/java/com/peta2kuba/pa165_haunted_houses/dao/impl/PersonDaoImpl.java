package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.PersonDao;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author skornok
 */
@Repository
public class PersonDaoImpl
        implements PersonDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Person person) {
        em.persist(person);
    }

    @Override
    public void edit(Person person) {
        em.merge(person);
    }

    @Override
    public void remove(Person person) {
        em.remove(person);
    }

    @Override
    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public Person findByEmail(final String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is null!");
        } else {
            try {
                return em.createQuery("SELECT person FROM Person person where email=:email", Person.class)
                        .setParameter("email", email)
                        .getSingleResult();
            } catch (NoResultException e) {
                return null;
            }
        }
    }

    @Override
    public List<Person> findAll() {
        return em.createQuery("SELECT person FROM Person person", Person.class).getResultList();
    }
}
