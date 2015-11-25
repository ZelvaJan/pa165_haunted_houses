package com.peta2kuba.pa165_haunted_houses.builder;

import com.peta2kuba.pa165_haunted_houses.entity.Person;

/**
 * @author turcovsky on 25/11/15.
 */
public class DirectorPersonBuilder {

	private PersonBuilder builder;

	public void setBuilder(final PersonBuilder builder) {
		this.builder = builder;
	}

	public Person getPerson() {
		return builder.getPerson();
	}

	public void createPerson() {
		builder.buildEmail();
		builder.buildPassword();
		builder.buildAdmin();
	}
}
