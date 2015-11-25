package com.peta2kuba.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Haunter} entity.
 *
 * @author skornok on 25/11/15.
 */
@Service
public interface HaunterService {

	void createHaunter(Haunter haunter);

	void editHaunter(Haunter haunter);

	void removeHaunter(Haunter haunter);

	Haunter findById(Long id);

	Haunter findByName(String name);

	List<Haunter> findAll();

	List<Haunter> findActiveHaunters();
}
