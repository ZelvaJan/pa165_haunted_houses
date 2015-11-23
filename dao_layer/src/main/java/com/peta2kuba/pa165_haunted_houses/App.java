package com.peta2kuba.pa165_haunted_houses;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author turcovsky on 28/10/15.
 */
public class App {

	private static EntityManagerFactory emf;
	private static org.apache.log4j.Logger log = Logger.getLogger(App.class);
	static final String path = "src/main/resources/log4j.properties";

	public static void main(String[] args) {
		System.out.println("Hello World!");

		// configure log4j
		PropertyConfigurator.configure(path);
		//BasicConfigurator.configure();
		System.out.println("log4j configured!");
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");

		new AnnotationConfigApplicationContext(InRamDbSpring.class);		// TODO 30/10/2015 choose right class

		emf = Persistence.createEntityManagerFactory("default");

		// CODE HERE
		test();

		emf.close();
	}

	private static void test() {

	}
}
