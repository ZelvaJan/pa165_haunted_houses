package com.peta2kuba.pa165_haunted_houses.dao;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

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

    /**
     * Make sure that the creation of database objects work and can return all
     * ability entries.
     */
    @Test
    public void findAll() {
        Ability ability1 = new Ability();
        ability1.setName("Ability1");
        ability1.setDescription("Ability1desc");

        Ability ability2 = new Ability();
        ability2.setName("Ability2");
        ability2.setDescription(null);

        abilityDao.create(ability1);
        abilityDao.create(ability2);

        List<Ability> abilities = abilityDao.findAll();

        Assert.assertEquals(2, abilities.size());
        Assert.assertTrue(abilities.contains(ability1));
        Assert.assertTrue(abilities.contains(ability2));
    }

    /**
     * Make sure that find object by id work.
     */
    @Test
    public void findById() {
        Ability ability1 = new Ability();
        ability1.setName("Ability11");
        ability1.setDescription("Ability11desc");

        Ability ability2 = new Ability();
        ability2.setName("Ability22");
        ability2.setDescription("Ability22desc");

        abilityDao.create(ability1);
        abilityDao.create(ability2);

        Ability fromDatabase11 = abilityDao.findById(ability1.getId());
        Assert.assertEquals(fromDatabase11, ability1);
    }

    /**
     * Make sure that object is successfully inserted to db and can be removed.
     */
    @Test()
    public void remove() {
        Ability ability1 = new Ability();
        ability1.setName("Ability1");
        ability1.setDescription("Ability1desc");

        abilityDao.create(ability1);

        Assert.assertNotNull(abilityDao.findById(ability1.getId()));
        abilityDao.remove(ability1);
        Assert.assertNull(abilityDao.findById(ability1.getId()));
    }

    /**
     * Make sure that object is successfully inserted to db and can be updated.
     */
    @Test()
    public void update() {
        Ability ability1 = new Ability();
        ability1.setName("Ability1");
        ability1.setDescription("Ability1desc");

        abilityDao.create(ability1);

        Ability updatedAbility = new Ability(ability1.getId(), "Updated ability", "Updated description");
        abilityDao.edit(updatedAbility);

        Ability updatedDbAbility = abilityDao.findById(updatedAbility.getId());
        Assert.assertEquals(updatedDbAbility.getName(), "Updated ability");
        Assert.assertEquals(updatedDbAbility.getDescription(), "Updated description");
    }

    /**
     * Check non-null name constraints
     */
    @Test(expectedExceptions = ConstraintViolationException.class)
    public void nullAbilityNameNotAllowed() {
        Ability ability = new Ability();
        ability.setName(null);
        ability.setDescription("Description");
        abilityDao.create(ability);
    }

    /**
     * Check name unique constraints
     */
    @Test(expectedExceptions = PersistenceException.class)
    public void nameIsUnique() {
        Ability ability = new Ability();
        ability.setName("Name");
        ability.setDescription("Description");
        abilityDao.create(ability);
        Ability ability2 = new Ability();
        ability2.setName("Name");
        ability2.setDescription("Description2");
        abilityDao.create(ability2);
    }
}
