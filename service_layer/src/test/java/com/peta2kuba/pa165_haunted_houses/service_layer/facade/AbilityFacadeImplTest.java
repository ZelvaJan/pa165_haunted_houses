/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dao.AbilityDao;
import com.peta2kuba.pa165_haunted_houses.dto.AbilityDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.facade.AbilityFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.BeanMappingService;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.AbilityService;
import java.util.ArrayList;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author petr.melicherik
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class AbilityFacadeImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Mock
    private AbilityDao abilityDao;

    @Autowired
    @InjectMocks
    private AbilityService abilityService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Autowired
    private AbilityFacade abilityFacade;

    @org.testng.annotations.BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }

    private Ability ability;
    private Ability ability2;
    private AbilityDTO abilityDTO;
    private AbilityDTO abilityDTO2;

    @BeforeMethod
    public void init() {
        ability = new Ability((long) 1, "Head  bum", "Watch out!!");
        ability2 = new Ability((long) 2, "Bum bum dum", "Oiii");
        abilityDTO = new AbilityDTO((long) 1, "Head  bum", "Watch out!!");
        abilityDTO2 = new AbilityDTO((long) 2, "Bum bum dum", "Oiii");
    }

    /**
     * Test of create method, of class AbilityFacadeImpl.
     */
//    @Test
//    public void testCreate() {
//        when(abilityDao.findById(ability.getId())).thenReturn(ability);
//        AbilityDTO abilityDTO = abilityFacade.findById(ability.getId());
//        Assert.assertEquals(beanMappingService.mapTo(ability, AbilityDTO.class), abilityDTO);

//        when(abilityDao.create(ability))
//        when(abilityDao.create(ability));
//        
////        when(abilityService.)
//        abilityFacade.create(abilityDTO);
//        int a = 5;
//        
//        System.out.println("create");
//        AbilityDTO ability = null;
//        AbilityFacadeImpl instance = new AbilityFacadeImpl();
//        instance.create(ability);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//        final Long id = 1l;
//        when(entityMapper.map(creatureDTO, Creature.class)).thenReturn(creature);
//        doAnswer(new Answer() {
//            @Override
//            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
//                creature.setId(id);
//                return null;
//            }
//        }).when(creatureService).createCreature(creature);
//
//        Assert.assertEquals(creatureFacade.createCreature(creatureDTO), id);
//
//        verify(entityMapper).map(creatureDTO, Creature.class);
//        verify(creatureService).createCreature(creature);
 

//    /**
//     * Test of edit method, of class AbilityFacadeImpl.
//     */
//    @Test
//    public void testEdit() {
//        System.out.println("edit");
//        AbilityDTO ability = null;
//        AbilityFacadeImpl instance = new AbilityFacadeImpl();
//        instance.edit(ability);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class AbilityFacadeImpl.
//     */
//    @Test
//    public void testRemove() {
//        System.out.println("remove");
//        AbilityDTO ability = null;
//        AbilityFacadeImpl instance = new AbilityFacadeImpl();
//        instance.remove(ability);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of findById method, of class AbilityFacadeImpl.
     */
    @Test
    public void testFindById() {
        when(abilityDao.findById(ability.getId())).thenReturn(ability);
        AbilityDTO abilityDTO = abilityFacade.findById(ability.getId());
        Assert.assertEquals(beanMappingService.mapTo(ability, AbilityDTO.class), abilityDTO);
    }

    /**
     * Test of findAll method, of class AbilityFacadeImpl.
     */
    @Test
    public void testFindAll() {
        List<Ability> abilityList = new ArrayList<>();
        abilityList.add(ability);
        abilityList.add(ability2);
                
        when(abilityDao.findAll()).thenReturn(abilityList);
        List<AbilityDTO> newAbilityDTOList = abilityFacade.findAll();
        Assert.assertEquals(beanMappingService.mapTo(abilityList, AbilityDTO.class), newAbilityDTOList);
    }

}
