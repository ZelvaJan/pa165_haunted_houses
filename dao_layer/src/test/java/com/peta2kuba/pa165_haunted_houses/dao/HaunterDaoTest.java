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

    @PersistenceContext
    private EntityManager em;

    public HaunterDaoTest() {
    }

    /**
     * Make sure that the creation of database objects work and can return all
     * ability entries.
     */
    @Test
    public void findAll() {
        String haunter1Name = "Frankenstein";
        String haunter1HauntingReason = "Headache";
        HauntingHours haunter1HauntingHours = new HauntingHours();
        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter1HauntingHours);

        Haunter haunter1 = new Haunter();
        haunter1.setName(haunter1Name);
        haunter1.setHauntingReason(haunter1HauntingReason);
        haunter1.setHauntingHours(haunter1HauntingHours);

        String haunter2Name = "Alien";
        String haunter2HauntingReason = "Too many children";
        HauntingHours haunter2HauntingHours = new HauntingHours();
        haunter2HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter2HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter2HauntingHours);

        Haunter haunter2 = new Haunter();
        haunter2.setName(haunter2Name);
        haunter2.setHauntingReason(haunter2HauntingReason);
        haunter2.setHauntingHours(haunter2HauntingHours);

        haunterDao.create(haunter1);
        haunterDao.create(haunter2);

        List<Haunter> haunters = haunterDao.findAll();

        Assert.assertEquals(2, haunters.size());
        Assert.assertTrue(haunters.contains(haunter1));
        Assert.assertTrue(haunters.contains(haunter2));
    }

    /**
     * Test method findActiveHaunters() which should return only haunters
     * haunting houses right now
     */
    @Test
    public void findActiveHaunters() {
        String haunter1Name = "Frankenstein";
        String haunter1HauntingReason = "Headache";
        HauntingHours haunter1HauntingHours = new HauntingHours();
        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter1HauntingHours);

        Haunter haunter1 = new Haunter();
        haunter1.setName(haunter1Name);
        haunter1.setHauntingReason(haunter1HauntingReason);
        haunter1.setHauntingHours(haunter1HauntingHours);

        String haunter2Name = "Alien";
        String haunter2HauntingReason = "Too many children";
        HauntingHours haunter2HauntingHours = new HauntingHours();
        haunter2HauntingHours.setFromTime(Time.valueOf("18:05:00"));
        haunter2HauntingHours.setToTime(Time.valueOf("23:55:00"));
        hauntingHoursDao.create(haunter2HauntingHours);

        Haunter haunter2 = new Haunter();
        haunter2.setName(haunter2Name);
        haunter2.setHauntingReason(haunter2HauntingReason);
        haunter2.setHauntingHours(haunter2HauntingHours);

        haunterDao.create(haunter1);
        haunterDao.create(haunter2);

        List<Haunter> haunters = haunterDao.findActiveHaunters();
		Assert.assertTrue(haunters.size() <= 1);
    }

    /**
     * Make sure that find object by id work.
     */
    @Test
    public void findById() {
        String haunter1Name = "Frankenstein";
        String haunter1HauntingReason = "Headache";
        HauntingHours haunter1HauntingHours = new HauntingHours();
        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter1HauntingHours);

        Haunter haunter1 = new Haunter();
        haunter1.setName(haunter1Name);
        haunter1.setHauntingReason(haunter1HauntingReason);
        haunter1.setHauntingHours(haunter1HauntingHours);

        String haunter2Name = "Alien";
        String haunter2HauntingReason = "Too many children";
        HauntingHours haunter2HauntingHours = new HauntingHours();
        haunter2HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter2HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter2HauntingHours);

        Haunter haunter2 = new Haunter();
        haunter2.setName(haunter2Name);
        haunter2.setHauntingReason(haunter2HauntingReason);
        haunter2.setHauntingHours(haunter2HauntingHours);

        haunterDao.create(haunter1);
        haunterDao.create(haunter2);

        Haunter fromDatabase11 = haunterDao.findById(haunter1.getId());
        Assert.assertEquals(fromDatabase11, haunter1);
    }

    /**
     * Make sure that object is successfully inserted to db and can be removed.
     */
    @Test()
    public void remove() {
        String haunter1Name = "Frankenstein";
        String haunter1HauntingReason = "Headache";
        HauntingHours haunter1HauntingHours = new HauntingHours();
        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter1HauntingHours);

        Haunter haunter1 = new Haunter();
        haunter1.setName(haunter1Name);
        haunter1.setHauntingReason(haunter1HauntingReason);
        haunter1.setHauntingHours(haunter1HauntingHours);

        haunterDao.create(haunter1);

        Assert.assertNotNull(haunterDao.findById(haunter1.getId()));
        haunterDao.remove(haunter1);
        Assert.assertNull(haunterDao.findById(haunter1.getId()));
    }

    /**
     * Make sure that object is successfully inserted to db and can be updated.
     */
    @Test()
    public void update() {
        String haunter1Name = "Frankenstein";
        String haunter1HauntingReason = "Headache";
        HauntingHours haunter1HauntingHours = new HauntingHours();
        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter1HauntingHours);

        Haunter haunter1 = new Haunter();
        haunter1.setName(haunter1Name);
        haunter1.setHauntingReason(haunter1HauntingReason);
        haunter1.setHauntingHours(haunter1HauntingHours);

        haunterDao.create(haunter1);

        String updatedHauntingReason = "Toothache";
        Haunter updatedHaunter = new Haunter(haunter1.getId(), haunter1Name, haunter1HauntingHours, null, updatedHauntingReason);
        haunterDao.edit(updatedHaunter);

        Haunter updatedDbAbility = haunterDao.findById(updatedHaunter.getId());
        Assert.assertEquals(updatedDbAbility.getHauntingReason(), updatedHauntingReason);
    }

    /**
     * Check non-null name constraints
     */
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullHaunterNameNotAllowed() {
        String haunter1Name = null;
        HauntingHours haunter1HauntingHours = new HauntingHours();
        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter1HauntingHours);

        Haunter haunter1 = new Haunter();
        haunter1.setName(haunter1Name);
        haunter1.setHauntingHours(haunter1HauntingHours);
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
        String haunter1Name = "Frankenstein";
        String haunter1HauntingReason = "Headache";
        HauntingHours haunter1HauntingHours = new HauntingHours();
        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter1HauntingHours);

        Haunter haunter1 = new Haunter();
        haunter1.setName(haunter1Name);
        haunter1.setHauntingReason(haunter1HauntingReason);
        haunter1.setHauntingHours(haunter1HauntingHours);

        String haunter2HauntingReason = "Too many children";
        HauntingHours haunter2HauntingHours = new HauntingHours();
        haunter2HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter2HauntingHours.setToTime(Time.valueOf("17:05:00"));
        hauntingHoursDao.create(haunter2HauntingHours);

        Haunter haunter2 = new Haunter();
        haunter2.setName(haunter1Name);
        haunter2.setHauntingReason(haunter2HauntingReason);
        haunter2.setHauntingHours(haunter2HauntingHours);

        haunterDao.create(haunter1);
        haunterDao.create(haunter2);
    }
}
