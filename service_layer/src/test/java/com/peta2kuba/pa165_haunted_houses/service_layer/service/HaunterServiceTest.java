package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.dao.HaunterDao;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.pa165_haunted_houses.service_layer.exceptions.NullHaunterException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * @author turcovsky on 26/11/15.
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class HaunterServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Mock
    private HaunterDao haunterDao;

    @Autowired
    @InjectMocks
    private HaunterService haunterService;

    private Haunter h1;
    private Haunter h2;
    private HauntingHours hh1;
    private HauntingHours hh2;

    @BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void init() {
        hh1 = new HauntingHours();
        hh1.setFromTime(Time.valueOf("8:00:00"));
        hh1.setToTime(Time.valueOf("20:00:00"));

        Ability a1 = new Ability();
        a1.setName("Big head");
        a1.setDescription("It's really large. Watch out!");
        ArrayList<Ability> abilities1 = new ArrayList<>();
        abilities1.add(a1);

        h1 = new Haunter();
        h1.setHauntingHours(hh1);
        h1.setName("Premek");
        h1.setDescription("Haunting people with his enormous head");
        h1.setHauntingReason("Because");
        h1.setAbilities(abilities1);

        hh2 = new HauntingHours();
        hh2.setFromTime(Time.valueOf("20:00:00"));
        hh2.setToTime(Time.valueOf("08:00:00"));

        Ability a2 = new Ability();
        a2.setName("Farting");
        a2.setDescription("The smell is horrifying");
        ArrayList<Ability> abilities2 = new ArrayList<>();
        abilities2.add(a2);

        h2 = new Haunter();
        h2.setHauntingHours(hh2);
        h2.setName("MisterFartGhost");
        h2.setDescription("This is one stinky ghost");
        h2.setHauntingReason("Too much air");
        h2.setAbilities(abilities2);
    }

    /**
     * Test return values for isHaunterStronger method.
     */
    @Test
    public void testWeaker() {
        long weaker = haunterService.isHaunterStronger(h1, h2);
        Assert.assertTrue(weaker < 0);
    }

    /**
     * Test return values for isHaunterStronger method.
     */
    @Test
    public void testStronger() {
        long stronger = haunterService.isHaunterStronger(h2, h1);
        Assert.assertTrue(stronger > 0);
    }

    /**
     * Test return values for isHaunterStronger method.
     */
    @Test
    public void testSamePower() {
        long same = haunterService.isHaunterStronger(h1, h1);
        Assert.assertTrue(same == 0);
    }

    /**
     * Test right exception handling for isHaunterStronger method.
     */
    @Test(expectedExceptions = NullHaunterException.class)
    public void haunter1Null() {
        haunterService.isHaunterStronger(null, h1);
    }

    /**
     * Test right exception handling for isHaunterStronger method.
     */
    @Test(expectedExceptions = NullHaunterException.class)
    public void haunter2Null() {
        haunterService.isHaunterStronger(h1, null);
    }

    /**
     * Test specific cases for isHaunterStronger method.
     */
    @Test
    public void testUltra() {
        List<Ability> abilities = h1.getAbilities();
        for (Ability a : abilities) {
            String name = a.getName();
            name += " ULTRA";
            a.setName(name);
        }

        long stronger = haunterService.isHaunterStronger(h1, h2);
        Assert.assertTrue(stronger > 0);
    }

    /**
     * Test specific cases for isHaunterStronger method.
     */
    @Test
    public void testLowercaseMega() {
        List<Ability> abilities = h1.getAbilities();
        for (Ability a : abilities) {
            String name = a.getName();
            name += " mega";
            a.setName(name);
        }

        long weaker = haunterService.isHaunterStronger(h1, h2);
        Assert.assertTrue(weaker < 0);
    }
}
