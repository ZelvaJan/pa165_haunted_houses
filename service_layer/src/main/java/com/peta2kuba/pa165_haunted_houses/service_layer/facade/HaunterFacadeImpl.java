package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.facade.HaunterFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.BeanMappingService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.HaunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author skornok on 25/11/15.
 */
@Service
@Transactional
public class HaunterFacadeImpl implements HaunterFacade {

    @Autowired
    private HaunterService haunterService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void createHaunter(final HaunterDTO haunterDTO) {
        haunterService.createHaunter(beanMappingService.mapTo(haunterDTO, Haunter.class));
    }

    @Override
    public void editHaunter(final HaunterDTO haunterDTO) {
        haunterService.editHaunter(beanMappingService.mapTo(haunterDTO, Haunter.class));
    }

    @Override
    public void removeHaunter(final HaunterDTO haunterDTO) {
        haunterService.removeHaunter(beanMappingService.mapTo(haunterDTO, Haunter.class));
    }
    
    @Override
    public void removeHaunterById(final Long id) {
        Haunter haunter = haunterService.findById(id);
        haunterService.removeHaunter(haunter);
    }

    @Override
    public HaunterDTO findById(final Long id) {
        Haunter haunter = haunterService.findById(id);
        return (haunter == null) ? null : beanMappingService.mapTo(haunter, HaunterDTO.class);
    }

    @Override
    public HaunterDTO findByName(final String name) {
        Haunter haunter = haunterService.findByName(name);
        return (haunter == null) ? null : beanMappingService.mapTo(haunter, HaunterDTO.class);
    }

    @Override
    public List<HaunterDTO> findAll() {
        return beanMappingService.mapTo(haunterService.findAll(), HaunterDTO.class);
    }

    @Override
    public List<HaunterDTO> findActiveHaunters() {
        return beanMappingService.mapTo(haunterService.findActiveHaunters(), HaunterDTO.class);
    }

    @Override
    public long isHaunterStronger(HaunterDTO actualHaunter, HaunterDTO competitorHaunter) {
        return haunterService.isHaunterStronger(beanMappingService
                .mapTo(actualHaunter, Haunter.class), beanMappingService
                .mapTo(competitorHaunter, Haunter.class));
    }

}
