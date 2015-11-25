package com.peta2kuba.pa165_haunted_houses.builder;

import com.peta2kuba.pa165_haunted_houses.entity.Person;

/**
 * @author turcovsky on 25/11/15.
 */
public abstract class PersonBuilder  {

	protected Person person;

	public Person getPerson() {
		return person;
	}

	public PersonBuilder() {
		person = new Person();
	}

	public abstract void buildEmail();
	public abstract void buildPassword();
	public abstract void buildAdmin();
}
