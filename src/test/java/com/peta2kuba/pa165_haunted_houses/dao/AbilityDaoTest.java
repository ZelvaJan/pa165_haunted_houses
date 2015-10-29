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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * @author petr.melicherik
 */
@ContextConfiguration(classes=PersistenceTestAplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class AbilityDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AbilityDao abilityDao;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void findAll() {
        Ability ability1 = new Ability(Long.MIN_VALUE, "Ability1", "Prvni pokusna ability");
        Ability ability2 = new Ability((Long.MIN_VALUE + 1), "Ability2", "Druha pokusna ability");

        abilityDao.create(ability1);
        abilityDao.create(ability2);
        
        List<Ability> abilities = abilityDao.findAll();

        Assert.assertEquals(2, abilities.size());
        Assert.assertTrue(abilities.contains(ability1));
        Assert.assertTrue(abilities.contains(ability2));
    }

}
