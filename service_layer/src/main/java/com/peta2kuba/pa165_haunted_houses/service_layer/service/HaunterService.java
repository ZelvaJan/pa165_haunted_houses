package com.peta2kuba.pa165_haunted_houses.service_layer.service;

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
        
        /**
         * Determine if actual haunter is more powerful than competitor
         * @param actualHaunter 
         * @param competitorHaunter
         * @return negative number => actual haunter is weaker, 0 => same power, positive number => actual haunter is stronger
         */
        long isHaunterStronger (Haunter actualHaunter, Haunter competitorHaunter);
}
