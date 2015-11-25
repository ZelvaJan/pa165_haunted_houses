package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Person} entity.
 * @author skornok on 24/11/15.
 */
@Service
public interface HouseService {

	void createHouse(House house);

	void editHouse(House house);

	void removeHouse(House house);

	House findById(Long id);

	List<House> findAll();

	List<Haunter> findHaunters();
}
