package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;
import com.peta2kuba.pa165_haunted_houses.dto.HouseDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import com.peta2kuba.pa165_haunted_houses.facade.HouseFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.BeanMappingService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.List;

/**
 * @author skornok on 23/11/15.
 */
@Service
@Transactional
public class HouseFacadeImpl implements HouseFacade {

    @Autowired
    private HouseService houseService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void createHouse(final HouseDTO houseDTO) {
        House house = beanMappingService.mapTo(houseDTO, House.class);
        houseService.createHouse(house);
        houseDTO.setId(house.getId());
    }

    @Override
    public void editHouse(final HouseDTO houseDTO) {
        houseService.editHouse(beanMappingService.mapTo(houseDTO, House.class));
    }

    @Override
    public void removeHouse(final HouseDTO houseDTO) {
        houseService.removeHouse(beanMappingService.mapTo(houseDTO, House.class));
    }

    @Override
    public void removeHouseById(Long id) {
        houseService.removeHouse(houseService.findById(id));

    }

    @Override
    public HouseDTO findById(final Long id) {
        House house = houseService.findById(id);
        return (house == null) ? null : beanMappingService.mapTo(house, HouseDTO.class);
    }

    @Override
    public List<HouseDTO> findAll() {
        return beanMappingService.mapTo(houseService.findAll(), HouseDTO.class);
    }

    @Override
    public boolean exorcism(HouseDTO houseDTO, Time exorcismTime) {
        return houseService.exorcism(beanMappingService.
                mapTo(houseDTO, House.class), exorcismTime);
    }
}
