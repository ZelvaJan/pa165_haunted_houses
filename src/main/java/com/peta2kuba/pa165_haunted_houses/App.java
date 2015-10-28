package com.peta2kuba.pa165_haunted_houses;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

/**
 * @author turcovsky on 28/10/15.
 */
public class App {

	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		new AnnotationConfigApplicationContext(InRamDbSpring.class);

		emf = Persistence.createEntityManagerFactory("default");

		// CODE HERE

		emf.close();
	}
}
