package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.HaunterDao;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author petr.melicherik
 */
@Repository
public class HaunterDaoImpl implements HaunterDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Haunter haunter) {
        em.persist(haunter);
    }

}
