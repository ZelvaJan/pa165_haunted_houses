package com.peta2kuba.pa165_haunted_houses;

import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.AssertTrue;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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

		new AnnotationConfigApplicationContext(InRamDbSpring.class);

		emf = Persistence.createEntityManagerFactory("default");

		// CODE HERE
		test();

		emf.close();
	}

	private static void test() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		//Haunter haunter = new Haunter();
		//haunter.setId(1l);
		//haunter.setName("Prema");
		//haunter.setDescription("Haunting with his scary big head");
		//
		//HauntingHours hours = new HauntingHours();
		//hours.setId(1l);
		//hours.setFrom(new Time(System.currentTimeMillis()));
		//hours.setTo(new Time(System.currentTimeMillis() + 50000));
		//haunter.setHauntingHours(hours);

		Ability ability = new Ability();
		ability.setName("Big scary head");
		ability.setDescription("It's really big!");

		//List<Ability> abilityList = new ArrayList<>();
		//abilityList.add(ability);
		//haunter.setAbility(abilityList);

		em.persist(ability);
		em.getTransaction().commit();
		em.close();

		//Haunter result = em.createQuery(
		//		"select haunter from Haunter haunter where haunter.id = 1", Haunter.class).getSingleResult();

		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Ability> result = em.createQuery(
				"select ability from Ability ability", Ability.class).getResultList();

		em.close();

		System.out.println("RESULT NAME = " + result.get(0).getName());
		//System.out.println("Returned haunter:\n" +
		//		"Haunter id = " + result.getId() +
		//		"Haunter name = " + result.getName());
	}
}
