package com.peta2kuba.pa165_haunted_houses.service_layer;

import com.peta2kuba.pa165_haunted_houses.dao.HaunterDao;
import com.peta2kuba.pa165_haunted_houses.dao.HouseDao;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.HouseService;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolationException;
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

/**
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

    @BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }

    private House houseBrno;
    private Haunter haunter1;
    private Haunter haunter2;

    @BeforeMethod
    public void createHouses() {
        List<Haunter> haunterBrnoList = new ArrayList<>();
        haunter1 = new Haunter((long) 0, "Prema", null);
        HauntingHours haunter1HauntingHours = new HauntingHours();
        haunter1HauntingHours.setFromTime(Time.valueOf("07:05:00"));
        haunter1HauntingHours.setToTime(Time.valueOf("17:05:00"));
        haunter1.setHauntingHours(haunter1HauntingHours);
        haunterBrnoList.add(haunter1);

        haunter2 = new Haunter((long) 1, "Gogogo", null);
        HauntingHours haunter2HauntingHours = new HauntingHours();
        haunter2HauntingHours.setFromTime(Time.valueOf("16:05:00"));
        haunter2HauntingHours.setToTime(Time.valueOf("03:05:00"));
        haunter2.setHauntingHours(haunter2HauntingHours);
        haunterBrnoList.add(haunter2);

        houseBrno = new House();
        houseBrno.setId((long) 0);
        houseBrno.setName("Strasibrn");
        houseBrno.setHaunters(haunterBrnoList);
    }

    @Test
    public void exorcismSuccess1() {
        Assert.assertTrue(houseService.exorcism(houseBrno, haunter1, Time.valueOf("16:05:00")));
    }

    @Test
    public void exorcismUnsuccessful1() {
        Assert.assertFalse(houseService.exorcism(houseBrno, haunter1, Time.valueOf("18:05:00")));
    }

    @Test
    public void exorcismSuccess2() {
        Assert.assertFalse(houseService.exorcism(houseBrno, haunter2, Time.valueOf("15:05:00")));
    }

    @Test
    public void exorcismUnsuccessful2() {
        Assert.assertTrue(houseService.exorcism(houseBrno, haunter2, Time.valueOf("01:05:00")));
    }

}
