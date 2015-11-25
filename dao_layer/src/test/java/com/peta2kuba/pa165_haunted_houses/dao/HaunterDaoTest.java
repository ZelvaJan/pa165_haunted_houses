/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import com.peta2kuba.pa165_haunted_houses.entity.House;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author skornok
 */
@ContextConfiguration(classes = PersistenceTestAplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class HaunterDaoTest
        extends AbstractTestNGSpringContextTests {

    @Autowired
    private HaunterDao haunterDao;
    @Autowired
    private HauntingHoursDao hauntingHoursDao;

    private Haunter h1;
	private Haunter h2;

	private HauntingHours hh1;
	private HauntingHours hh2;

    public HaunterDaoTest() {
    }

	@BeforeMethod
	public void initHaunters() {
		hh1 = new HauntingHours();
		hh1.setFromTime(Time.valueOf("07:05:00"));
		hh1.setToTime(Time.valueOf("17:05:00"));
		hauntingHoursDao.create(hh1);

		h1 = new Haunter();
		h1.setName("Frankenstein");
		h1.setHauntingReason("Headache");
		h1.setHauntingHours(hh1);

		hh2 = new HauntingHours();
		hh2.setFromTime(Time.valueOf("18:05:00"));
		hh2.setToTime(Time.valueOf("23:55:00"));
		hauntingHoursDao.create(hh2);

		h2 = new Haunter();
		h2.setName("Alien");
		h2.setHauntingReason("Too many children");
		h2.setHauntingHours(hh2);

		haunterDao.create(h1);
		haunterDao.create(h2);
	}

    /**
     * Make sure that the creation of database objects work and can return all
     * ability entries.
     */
    @Test
    public void findAll() {
        List<Haunter> haunters = haunterDao.findAll();

        Assert.assertEquals(2, haunters.size());
        Assert.assertTrue(haunters.contains(h1));
        Assert.assertTrue(haunters.contains(h2));
    }

    /**
     * Test method findActiveHaunters() which should return only haunters
     * haunting houses right now
     */
    @Test
    public void findActiveHaunters() {
        List<Haunter> haunters = haunterDao.findActiveHaunters();
		Assert.assertTrue(haunters.size() <= 1);
    }

    /**
     * Make sure that find object by id work.
     */
    @Test
    public void findById() {
        Haunter fromDatabase11 = haunterDao.findById(h1.getId());
        Assert.assertEquals(fromDatabase11, h1);
    }

    /**
     * Make sure that object is successfully inserted to db and can be removed.
     */
    @Test()
    public void remove() {
        Assert.assertNotNull(haunterDao.findById(h1.getId()));
        haunterDao.remove(h1);
        Assert.assertNull(haunterDao.findById(h1.getId()));

		haunterDao.create(h1);
    }

    /**
     * Make sure that object is successfully inserted to db and can be updated.
     */
    @Test()
    public void update() {
		final String updatedReason = "Toothache";
        final Haunter updatedHaunter = new Haunter(h1.getId(), h1.getName(), h1.getHauntingHours(), null, updatedReason);
        haunterDao.edit(updatedHaunter);

        final Haunter updatedDbAbility = haunterDao.findById(updatedHaunter.getId());
        Assert.assertEquals(updatedDbAbility.getHauntingReason(), updatedReason);
    }

    /**
     * Check non-null name constraints
     */
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullHaunterNameNotAllowed() {
        Haunter haunter1 = new Haunter();
        haunter1.setHauntingHours(hh1);
        haunterDao.create(haunter1);
}

    /**
     * Check non-null Description constraints
     */
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullHaunterHauntingHoursNotAllowed() {
        String haunter1Name = "Frankie";

        Haunter haunter1 = new Haunter();
        haunter1.setName(haunter1Name);
        haunter1.setHauntingHours(null);
        haunterDao.create(haunter1);
    }

    /**
     * Check name unique constraints
     */
    @Test(expectedExceptions = PersistenceException.class)
    public void nameIsUnique() {
        String haunter2HauntingReason = "Too many children";

        Haunter haunter2 = new Haunter();
        haunter2.setName(h1.getName());
        haunter2.setHauntingReason(haunter2HauntingReason);
        haunter2.setHauntingHours(hh2);

        haunterDao.create(haunter2);
    }
}
