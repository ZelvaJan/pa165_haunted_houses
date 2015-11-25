package com.peta2kuba.pa165_haunted_houses.builder;

/**
 * @author turcovsky on 25/11/15.
 */
public class PersonPremekBuilder extends PersonBuilder {

	@Override
	public void buildEmail() {
		person.setEmail("premek@seznam.cz");
	}

	@Override
	public void buildPassword() {
		person.setPassword("aaaaaa");
	}

	@Override
	public void buildAdmin() {
		person.setAdmin(false);
	}
}
