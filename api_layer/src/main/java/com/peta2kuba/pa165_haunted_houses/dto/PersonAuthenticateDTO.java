package com.peta2kuba.pa165_haunted_houses.dto;

import java.util.Objects;

/**
 *
 * @author turcovsky
 */
public class PersonAuthenticateDTO {

    private String email;
    private String password;

    public PersonAuthenticateDTO() {

    }

    public PersonAuthenticateDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonAuthenticateDTO other = (PersonAuthenticateDTO) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonAuthenticateDTO{" + "email=" + email + ", password=" + password + '}';
    }

}
