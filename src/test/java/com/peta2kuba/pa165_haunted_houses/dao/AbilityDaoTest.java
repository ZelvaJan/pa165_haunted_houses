/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * @author petr.melicherik
 */
@ContextConfiguration(classes = PersistenceTestAplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class AbilityDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AbilityDao abilityDao;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void findAll() {
        Ability ability1 = new Ability();
        ability1.setName("Ability1");
        ability1.setDescription("Ability1desc");

        Ability ability2 = new Ability();
        ability2.setName("Ability2");
        ability2.setDescription("Ability2desc");

        abilityDao.create(ability1);
        abilityDao.create(ability2);

        List<Ability> abilities = abilityDao.findAll();

        Ability ability1assert = new Ability((long) 1, "Ability1","Ability1desc" );
        Ability ability2assert = new Ability((long) 2, "Ability2","Ability2desc" );

        Assert.assertEquals(2, abilities.size());
        Assert.assertTrue(abilities.contains(ability1assert));
        Assert.assertTrue(abilities.contains(ability2assert));
    }

}
