package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;

import java.util.List;

/**
 * @author petr.melicherik
 */
public interface HaunterFacade {

    void createHaunter(HaunterDTO haunterDTO);

    void editHaunter(HaunterDTO haunterDTO);

    void removeHaunter(HaunterDTO haunterDTO);

    HaunterDTO findById(Long id);

    HaunterDTO findByName(String name);

    List<HaunterDTO> findAll();

    /**
     * Find all haunters which haunt now
     *
     * @return all haunters which haunt now
     */
    List<HaunterDTO> findActiveHaunters();

    /**
     * Determine if actual haunter is more powerful than competitor
     *
     * @param actualHaunter
     * @param competitorHaunter
     * @return negative number => actual haunter is weaker, 0 => same power,
     * positive number => actual haunter is stronger
     */
    long isHaunterStronger(HaunterDTO actualHaunter, HaunterDTO competitorHaunter);
}
