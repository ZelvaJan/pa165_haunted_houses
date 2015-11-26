package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.dao.AbilityDao;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.AbilityService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import static org.testng.Assert.fail;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author petr.melicherik
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class AbilityServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Mock
    private AbilityDao abilityDao;

    @Autowired
    @InjectMocks
    private AbilityService abilityService;

    @BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }

    private Ability abilityPush;
    private Ability abilityPull;

    @BeforeMethod
    public void createAbility() {
        abilityPush = new Ability();
        abilityPush.setId((long) 0);
        abilityPush.setName("Push");
        abilityPush.setDescription("Force push like Jedi");

        abilityPull = new Ability();
        abilityPull.setId((long) 1);
        abilityPull.setName("Pull");
        abilityPull.setDescription("Force pull like Jedi");

    }

    @Test
    public void testCreateAbility() {
        abilityService.createAbility(abilityPush);
        verify(abilityDao).create(abilityPush);
        int a = 5;
    }

    @Test
    public void testEditAbility() {

        verify(abilityDao).create(abilityPush);
//        abilityService.createAbility(abilityPush);
//
//        Ability abilityPushUpdated = new Ability();
//        abilityPushUpdated.setId(abilityPush.getId());
//        abilityPushUpdated.setName(abilityPull.getName());
//        abilityPushUpdated.setDescription(null);
//
//        abilityService.editAbility(abilityPushUpdated);
//
//        Ability ability = abilityService.findAbilityById(abilityPush.getId());
////        orderService.finishOrder(orderShipped);
////        Assert.assertEquals(orderShipped.getState(), OrderState.DONE);
////        
////        fail();
    }
}
