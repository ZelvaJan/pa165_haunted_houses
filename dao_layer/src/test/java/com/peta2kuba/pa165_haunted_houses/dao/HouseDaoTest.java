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
    @Autowired
    private HaunterDao haunterDao;
    @Autowired
    private HauntingHoursDao hauntingHoursDao;

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
        House updatedHouse = new House(updatedHouseName, updatedHouseAddress, house1HauntedSince, null, null);
        updatedHouse.setId(house1.getId());
        houseDao.edit(updatedHouse);

        House updatedDbHouse = houseDao.findById(updatedHouse.getId());
        Assert.assertEquals(updatedDbHouse.getName(), updatedHouseName);
        Assert.assertEquals(updatedDbHouse.getAddress(), updatedHouseAddress);
    }

    /**
     * Check find for all haunters in the house
     */
    @Test
    public void findHaunters() {
        // create Haunter
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

        // create House
        String house1Name = "Simpson's house";
        String house1Address = "742 Evergreen Terrace";
        Timestamp house1HauntedSince = Timestamp.valueOf("2007-09-23 10:10:10.0");

        House house1 = new House();
        house1.setName(house1Name);
        house1.setAddress(house1Address);
        house1.setHauntedSince(house1HauntedSince);
        house1.setDescription("description");
        house1.setHaunter(haunter1);

        houseDao.create(house1);

        // check House
        List<House> houses = houseDao.findAll();
        Assert.assertTrue(houses.contains(house1));
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
