package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.dao.HaunterDao;
import com.peta2kuba.pa165_haunted_houses.dao.HouseDao;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class of {@HouseServiceImpl}'s methods
 *
 * @author petr.melicherik
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class HouseServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Mock
    private HouseDao houseDao;

    @Mock
    private HaunterDao haunterDao;

    @Autowired
    @InjectMocks
    private HouseService houseService;
    private House houseBrno;
    private Haunter haunter1;
    private Haunter haunter2;

    @BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void createHouses() {
        haunter1 = new Haunter((long) 0, "Prema", null);
        HauntingHours haunter1HauntingHours = new HauntingHours();
        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
        haunter1.setHauntingHours(haunter1HauntingHours);

        houseBrno = new House();
        houseBrno.setId((long) 0);
        houseBrno.setName("Strasibrn");
        houseBrno.setHaunter(haunter1);
    }

    /**
     * Test return values for exircism method.
     */
    @Test
    public void exorcismSuccess1() {
        Assert.assertTrue(houseService.exorcism(houseBrno, Time.valueOf("16:05:00")));
    }

    /**
     * Test return values for exircism method.
     */
    @Test
    public void exorcismUnsuccessful1() {
        Assert.assertFalse(houseService.exorcism(houseBrno, Time.valueOf("18:05:00")));
    }

    /**
     * Test return values for exircism method.
     */
    @Test
    public void exorcismSuccess2() {
        Assert.assertTrue(houseService.exorcism(houseBrno, Time.valueOf("15:05:00")));
    }

    /**
     * Test return values for exircism method.
     */
    @Test
    public void exorcismUnsuccessful2() {
        Assert.assertFalse(houseService.exorcism(houseBrno, Time.valueOf("01:05:00")));
    }

    /**
     * Test null values for exircism method.
     */
    @Test
    public void exorcismNull() {
        Assert.assertFalse(houseService.exorcism(null, null));
        Assert.assertFalse(houseService.exorcism(null, Time.valueOf("01:05:00")));
        Assert.assertFalse(houseService.exorcism(houseBrno, Time.valueOf("01:05:00")));
        Assert.assertFalse(houseService.exorcism(houseBrno, null));
    }
}
