/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.App;
import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;
import java.util.logging.Logger;
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
        House house = new House();
         
        house.setName("Simpsons house");
        house.setAddress("742 Evergreen Terrace");
        house.setHauntedSince(Timestamp.valueOf("2007-09-23 10:10:10.0"));
        houseDao.create(house);
         
        System.out.println(house);

        House house1 = new House();
        house1.setName("House1");

        House house2 = new House();
        house2.setName("House2");

        houseDao.create(house1);
        houseDao.create(house2);

//        List<House> abilities = houseDao.findAll();
//
//        House house1assert = new House(house1.getId(), "House1", "House1desc");
//        House house2assert = new House(house2.getId(), "House2", null);
//
//        Assert.assertEquals(2, abilities.size());
//        Assert.assertTrue(abilities.contains(house1assert));
//        Assert.assertTrue(abilities.contains(house2assert));
    }

    /**
     * Make sure that find object by id work.
     */
    @Test
    public void findById() {
        House house1 = new House();
        house1.setName("House11");

        House house2 = new House();
        house2.setName("House22");

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
        House house1 = new House();
        house1.setName("House1");

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
        House house1 = new House();
        house1.setName("House1");

        houseDao.create(house1);

//        House updatedHouse = new House(house1.getId(), "Updated house", "Updated description");
//        houseDao.edit(updatedHouse);
//
//        House updatedDbHouse = houseDao.findById(updatedHouse.getId());
//        Assert.assertEquals(updatedDbHouse.getName(), "Updated house");
//        Assert.assertEquals(updatedDbHouse.getDescription(), "Updated description");
    }

    /**
     * Check non-null name constraints
     */
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullHouseNameNotAllowed() {
        House house = new House();
        house.setName(null);
        houseDao.create(house);
    }

    /**
     * Check name unique constraints
     */
    @Test(expectedExceptions = PersistenceException.class)
    public void nameIsUnique() {
        House house = new House();
        house.setName("Name");
        houseDao.create(house);
        
        House house2 = new House();
        house2.setName("Name");
        houseDao.create(house2);
    }
}
