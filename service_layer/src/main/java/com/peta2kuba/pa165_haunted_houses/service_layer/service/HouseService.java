package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import java.sql.Time;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * An interface that defines a service access to the {@link House} entity.
 *
 * @author skornok on 24/11/15.
 */
@Service
public interface HouseService {

    void createHouse(House house);

    void editHouse(House house);

    void removeHouse(House house);

    House findById(Long id);

    List<House> findAll();

    /**
     * Try to exorcise specific haunter, in specific house, in specific time.
     *
     * @param house specific house
     * @param haunter specific haunter
     * @param exorcismTime specific time
     * @return true if haunter was successfully exorcised (at the right time in
     * the right place). False otherwise.
     */
    boolean exorcism(House house, Haunter haunter, Time exorcismTime);
}
