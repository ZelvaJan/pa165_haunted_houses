package com.peta2kuba.pa165_haunted_houses.dto;

/**
 *
 * @author turcovsky
 */
public class PersonAuthenticateDTO {

    private String email;
    private String password;

    public PersonAuthenticateDTO() {

    }

    public String getEmail() {

        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PersonAuthenticateDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final PersonAuthenticateDTO that = (PersonAuthenticateDTO) o;

        if (email != null ? !email.equals(that.email) : that.email != null) {
            return false;
        }
        return !(password != null ? !password.equals(that.password) : that.password != null);

    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
