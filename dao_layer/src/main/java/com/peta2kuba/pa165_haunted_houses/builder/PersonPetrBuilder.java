package com.peta2kuba.pa165_haunted_houses.builder;

/**
 * @author turcovsky on 25/11/15.
 */
public class PersonPetrBuilder extends PersonBuilder {

	@Override
	public void buildEmail() {
		person.setEmail("petr@jaroslavik.sk");
	}

	@Override
	public void buildPassword() {
		person.setPassword("jarojezadvermi");
	}

	@Override
	public void buildAdmin() {
		person.setAdmin(false);
	}
}
