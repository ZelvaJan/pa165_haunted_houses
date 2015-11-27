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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    private Ability ability;
    private Ability ability2;
    private AbilityDTO abilityDTO;
    private AbilityDTO abilityDTO2;

    @org.testng.annotations.BeforeClass
    public void setupClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void init() {
        ability = new Ability((long) 1, "Head  bum", "Watch out!!");
        ability.setHaunters(new ArrayList<>());
        ability2 = new Ability((long) 2, "Bum bum dum", "Oiii");
        ability2.setHaunters(null);

        abilityDTO = beanMappingService.mapTo(ability, AbilityDTO.class);
        abilityDTO2 = beanMappingService.mapTo(ability2, AbilityDTO.class);
    }

    /**
     * Test of create method, of class AbilityFacadeImpl.
     */
    @Test
    public void testCreate() {
        abilityFacade.create(abilityDTO);
        verify(abilityDao).create(ability);
    }

    /**
     * Test of edit method, of class AbilityFacadeImpl.
     */
    @Test
    public void testEdit() {
        abilityFacade.edit(abilityDTO2);
        verify(abilityDao).edit(ability2);
    }

    /**
     * Test of remove method, of class AbilityFacadeImpl.
     */
    @Test
    public void testRemove() {
        abilityFacade.remove(abilityDTO);
        verify(abilityDao).remove(ability);
    }

    /**
     * Test of findById method, of class AbilityFacadeImpl.
     */
    @Test
    public void testFindById() {
        when(abilityDao.findById(ability.getId())).thenReturn(ability);
        AbilityDTO abilityDTOLoc = abilityFacade.findById(ability.getId());
        Assert.assertEquals(beanMappingService.mapTo(ability, AbilityDTO.class), abilityDTOLoc);
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
