package com.peta2kuba.pa165_haunted_houses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * User entity
 *
 * @author skornok
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    private boolean admin = false;

    public Person() {

    }

    public Person(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

	public Person(final String email, final String password) {
		this.email = email;
		this.password = password;
	}

	public Person(final String email, final String password, final boolean admin) {
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + Objects.hashCode(this.password);
        hash = 31 * hash + (this.admin ? 1 : 0);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (this.admin != other.admin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", email=" + email + ", password=" + password + ", admin=" + admin + '}';
    }

}
