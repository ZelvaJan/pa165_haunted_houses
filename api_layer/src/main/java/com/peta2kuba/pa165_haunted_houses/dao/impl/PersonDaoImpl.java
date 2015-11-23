package com.peta2kuba.pa165_haunted_houses.dao.impl;

import com.peta2kuba.pa165_haunted_houses.dao.PersonDao;
import com.peta2kuba.pa165_haunted_houses.entity.PersonDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author skornok
 */
@Repository
public class PersonDaoImpl
		implements PersonDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(PersonDTO person) {
		em.persist(person);
	}

	@Override
	public void edit(PersonDTO person) {
		em.merge(person);
	}

	@Override
	public void remove(PersonDTO person) {
		em.remove(person);
	}

	@Override
	public PersonDTO findById(Long id) {
		return em.find(PersonDTO.class, id);
	}

	@Override
	public List<PersonDTO> findAll() {
		return em.createQuery("SELECT person FROM Person person", PersonDTO.class).getResultList();
	}
}
