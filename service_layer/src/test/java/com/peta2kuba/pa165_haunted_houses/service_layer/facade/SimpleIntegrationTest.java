package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.facade.PersonFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author petr.melicherik
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class SimpleIntegrationTest extends AbstractTransactionalTestNGSpringContextTests {
    
    @Autowired
    private PersonFacade personFacade;
    
    PersonDTO personDTO;

    /**
     * Test facade-database layers integration.
     */
    @Test
    public void simpleIntegrationTest() {
        personDTO = new PersonDTO();
        personDTO.setId((long) 51);
        personDTO.setEmail("totaly new person");
        personDTO.setPassword("passTopass");
        
        personFacade.createPerson(personDTO);
        List<PersonDTO> list = personFacade.findAllPersons();
        logger.error("Integration: " + list.toString());
        Assert.assertTrue(list != null && list.size() > 0);
    }
    
}
