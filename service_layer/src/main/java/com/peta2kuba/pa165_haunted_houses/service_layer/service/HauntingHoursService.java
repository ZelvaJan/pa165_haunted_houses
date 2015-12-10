package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import org.springframework.stereotype.Service;

/**
 * An interface that defines a service access to the {@link HauntingHours} entity.
 *
 * @author turcovsky on 10/12/15.
 */
@Service
public interface HauntingHoursService {

	void createHauntingHours(HauntingHours hh);
}
