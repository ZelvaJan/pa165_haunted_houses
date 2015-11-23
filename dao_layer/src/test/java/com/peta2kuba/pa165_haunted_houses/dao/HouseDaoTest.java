/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author skornok
 */
@ContextConfiguration(classes = PersistenceTestAplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class HouseDaoTest extends AbstractTestNGSpringContextTests {    
    @Autowired
    private HouseDao houseDao;

    @PersistenceContext
    private EntityManager em;

    public HouseDaoTest() {
    }

    /**
     * Make sure that the creation of database objects work and can return all
     * house entries.
     */
    @Test
    public void findAll() {
        String house1Name = "Simpson's house";
        String house1Address = "742 Evergreen Terrace";
        Timestamp house1HauntedSince = Timestamp.valueOf("2007-09-23 10:10:10.0");
        
        House house1 = new House();
        house1.setName(house1Name);
        house1.setAddress(house1Address);
        house1.setHauntedSince(house1HauntedSince);         
        house1.setDescription("description");

        String house2Name = "AirBnB house";
        String house2Address = "Somewhere over the rainbow";
        Timestamp house2HauntedSince = Timestamp.valueOf("2007-09-23 10:10:10.0");
        
        House house2 = new House();
        house2.setName(house2Name);
        house2.setAddress(house2Address);
        house2.setHauntedSince(house2HauntedSince);         

        houseDao.create(house1);
        houseDao.create(house2);

        List<House> houses = houseDao.findAll();

        Assert.assertEquals(2, houses.size());
        Assert.assertTrue(houses.contains(house1));
        Assert.assertTrue(houses.contains(house2));
    }

    /**
     * Make sure that find object by id work.
     */
    @Test
    public void findById() {
        String house1Name = "Simpson's house";
        String house1Address = "742 Evergreen Terrace";
        Timestamp house1HauntedSince = Timestamp.valueOf("2007-09-23 10:10:10.0");
        
        House house1 = new House();
        house1.setName(house1Name);
        house1.setAddress(house1Address);
        house1.setHauntedSince(house1HauntedSince);         

        String house2Name = "AirBnB house";
        String house2Address = "Somewhere over the rainbow";
        Timestamp house2HauntedSince = Timestamp.valueOf("2007-09-23 10:10:10.0");
        
        House house2 = new House();
        house2.setName(house2Name);
        house2.setAddress(house2Address);
        house2.setHauntedSince(house2HauntedSince);         

        houseDao.create(house1);
        houseDao.create(house2);

        House fromDatabase11 = houseDao.findById(house1.getId());
        Assert.assertEquals(fromDatabase11, house1);
    }

    /**
     * Make sure that object is successfully inserted to db and can be removed.
     */
    @Test()
    public void remove() {
        String house1Name = "Simpson's house";
        String house1Address = "742 Evergreen Terrace";
        Timestamp house1HauntedSince = Timestamp.valueOf("2007-09-23 10:10:10.0");
        
        House house1 = new House();
        house1.setName(house1Name);
        house1.setAddress(house1Address);
        house1.setHauntedSince(house1HauntedSince);         

        houseDao.create(house1);

        Assert.assertNotNull(houseDao.findById(house1.getId()));
        houseDao.remove(house1);
        Assert.assertNull(houseDao.findById(house1.getId()));
    }

    /**
     * Make sure that object is successfully inserted to db and can be updated.
     */
    @Test()
    public void update() {
        String house1Name = "Simpson's house";
        String house1Address = "742 Evergreen Terrace";
        Timestamp house1HauntedSince = Timestamp.valueOf("2007-09-23 10:10:10.0");
        
        House house1 = new House();
        house1.setName(house1Name);
        house1.setAddress(house1Address);
        house1.setHauntedSince(house1HauntedSince);         

        houseDao.create(house1);

        String updatedHouseName = "Mr. Burns' house";
        String updatedHouseAddress = "Dunno";
        House updatedHouse = new House(house1.getId(), updatedHouseName, updatedHouseAddress, house1HauntedSince, null);
        houseDao.edit(updatedHouse);

        House updatedDbHouse = houseDao.findById(updatedHouse.getId());
        Assert.assertEquals(updatedDbHouse.getName(), updatedHouseName);
        Assert.assertEquals(updatedDbHouse.getAddress(), updatedHouseAddress);
    }

    /**
     * Check non-null name constraints
     */
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullHouseNameNotAllowed() {
        String house1Name = null;
        String house1Address = "742 Evergreen Terrace";
        Timestamp house1HauntedSince = Timestamp.valueOf("2007-09-23 10:10:10.0");
        
        House house1 = new House();
        house1.setName(null);
        house1.setAddress(house1Address);
        house1.setHauntedSince(house1HauntedSince);         

        houseDao.create(house1);
    }

    /**
     * Check non-null name constraints
     */
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullHouseAddressNotAllowed() {
        String house1Name = "Simpson's house";
        String house1Address = null;
        Timestamp house1HauntedSince = Timestamp.valueOf("2007-09-23 10:10:10.0");
        
        House house1 = new House();
        house1.setName(house1Name);
        house1.setAddress(null);
        house1.setHauntedSince(house1HauntedSince);         

        houseDao.create(house1);
    }
    
    /**
     * Check non-null name constraints
     */
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullHouseHauntedSiceNotAllowed() {
        String house1Name = "Simpson's house";
        String house1Address = "742 Evergreen Terrace";
        
        House house1 = new House();
        house1.setName(house1Name);
        house1.setAddress(house1Address);
        house1.setHauntedSince(null);         

        houseDao.create(house1);
    }
}
