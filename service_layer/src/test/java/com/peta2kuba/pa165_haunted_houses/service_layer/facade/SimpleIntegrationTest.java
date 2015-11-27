package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dto.AbilityDTO;
import com.peta2kuba.pa165_haunted_houses.facade.AbilityFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * This is an example of simple integration test
 *
 * @author petr.melicherik
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class SimpleIntegrationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    AbilityFacade abilityFacade;

    private final AbilityDTO ability = new AbilityDTO();

    @BeforeClass
    public void createData() {
        ability.setName("Big Head");
        abilityFacade.create(ability);
    }

    /**
     * Test facade-database layers integration.
     */
    @Test
    public void simpleIntegrationTest() {
        List<AbilityDTO> list = abilityFacade.findAll();
        Assert.assertTrue(list != null && list.size() > 0);
    }

}
