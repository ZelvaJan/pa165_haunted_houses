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
 *
 * @author skornok
 */
@ContextConfiguration(classes = PersistenceTestAplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class HaunterDaoTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private HaunterDao haunterDao;
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
        
//        Haunter haunter1 = new Haunter();
//        haunter1.setName(haunter1Name);
//        haunter1.setHauntingReason(haunter1HauntingReason);
//        haunter1.setHauntingHours(haunter1HauntingHours);
//        
//        String haunter2Name = "Alien";
//        String haunter2HauntingReason = "Too many children";
//        HauntingHours haunter2HauntingHours = new HauntingHours();
//        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
//        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
//
//        hauntingHoursDao.create(haunter2HauntingHours);
//
//        Haunter haunter2 = new Haunter();
//        haunter2.setName(haunter2Name);
//        haunter2.setHauntingReason(haunter2HauntingReason);
//        haunter2.setHauntingHours(haunter2HauntingHours);
//
//        haunterDao.create(haunter1);
//        haunterDao.create(haunter2);
//
//        List<Haunter> haunters = haunterDao.findAll();
//
//        Haunter haunter1assert = new Haunter(haunter1.getId(), haunter1Name, haunter1HauntingHours, null, null);
//        Haunter haunter2assert = new Haunter(haunter2.getId(), haunter2Name, haunter2HauntingHours, null, null);
//
//        Assert.assertEquals(2, haunters.size());
//        Assert.assertTrue(haunters.contains(haunter1assert));
//        Assert.assertTrue(haunters.contains(haunter2assert));
     }

    /**
     * Make sure that find object by id work.
     */
//    @Test
    public void findById() {
        Haunter haunter1 = new Haunter();
        haunter1.setName("Frankenstein");

        Haunter haunter2 = new Haunter();
        haunter2.setName("Alien");
        haunter2.setDescription("Aliendesc");

        haunterDao.create(haunter1);
        haunterDao.create(haunter2);

        Haunter fromDatabase11 = haunterDao.findById(haunter1.getId());
        Assert.assertEquals(fromDatabase11, haunter1);
    }

    /**
     * Make sure that object is successfully inserted to db and can be removed.
     */
//    @Test()
    public void remove() {
        Haunter haunter1 = new Haunter();
        haunter1.setName("Frankenstein");
        haunter1.setDescription("Frankensteindesc");

        haunterDao.create(haunter1);

        Assert.assertNotNull(haunterDao.findById(haunter1.getId()));
        haunterDao.remove(haunter1);
        Assert.assertNull(haunterDao.findById(haunter1.getId()));
    }

    /**
     * Make sure that object is successfully inserted to db and can be updated.
     */
//    @Test()
    public void update() {
        Haunter haunter1 = new Haunter();
        haunter1.setName("Frankenstein");
        haunter1.setDescription("Frankensteindesc");

        haunterDao.create(haunter1);

//        Haunter updatedHaunter = new Haunter(haunter1.getId(), "Updated haunter", "Updated description");
//        haunterDao.edit(updatedHaunter);
//
//        Haunter updatedDbAbility = haunterDao.findById(updatedHaunter.getId());
//        Assert.assertEquals(updatedDbAbility.getName(), "Updated ability");
//        Assert.assertEquals(updatedDbAbility.getDescription(), "Updated description");
    }

    /**
     * Check non-null name constraints
     */
//    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullHaunterNameNotAllowed() {
        Haunter haunter = new Haunter();
        haunter.setName(null);
        haunter.setHauntingHours(null);
        haunterDao.create(haunter);
    }

    /**
     * Check non-null Description constraints
     */
//    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullHaunterHauntingHoursNotAllowed() {
        Haunter haunter = new Haunter();
        haunter.setName(null);
        haunter.setHauntingHours(null);
        haunterDao.create(haunter);
    }

    /**
     * Check name unique constraints
     */
//    @Test(expectedExceptions = PersistenceException.class)
    public void nameIsUnique() {
        Haunter haunter1 = new Haunter();
        haunter1.setName("Name");
        haunter1.setDescription("Description");
        haunterDao.create(haunter1);
        
        Haunter haunter2 = new Haunter();
        haunter2.setName("Name");
        haunter2.setDescription("Description2");
        haunterDao.create(haunter2);
    }
}
