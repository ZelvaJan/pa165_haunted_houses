package com.peta2kuba.pa165_haunted_houses.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;
import com.peta2kuba.pa165_haunted_houses.dto.HouseDTO;
import java.sql.Time;

import java.util.List;

/**
 * @author turcovsky on 28/10/15.
 */
public interface HouseFacade {

    void createHouse(HouseDTO houseDTO);

    void editHouse(HouseDTO houseDTO);

    void removeHouse(HouseDTO houseDTO);

    HouseDTO findById(Long id);

    List<HouseDTO> findAll();

    List<HaunterDTO> findHaunters();

    boolean exorcism(HouseDTO houseDTO, HaunterDTO haunterDTO, Time exorcismTime);
}
