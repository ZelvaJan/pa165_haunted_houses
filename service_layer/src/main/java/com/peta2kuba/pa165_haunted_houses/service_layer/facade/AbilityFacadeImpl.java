package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dto.AbilityDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.facade.AbilityFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.BeanMappingService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.AbilityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author petr.melicherik
 */
@Service
@Transactional
public class AbilityFacadeImpl implements AbilityFacade {

    @Autowired
    private AbilityService abilityService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void create(AbilityDTO ability) {
        abilityService.createAbility(beanMappingService.mapTo(ability, Ability.class));
    }

    @Override
    public void edit(AbilityDTO ability) {
        abilityService.editAbility(beanMappingService.mapTo(ability, Ability.class));
    }

    @Override
    public void remove(AbilityDTO ability) {
        abilityService.removeAbility(beanMappingService.mapTo(ability, Ability.class));
    }

    @Override
    public AbilityDTO findById(Long id) {
        Ability ability = abilityService.findAbilityById(id);
        return (ability == null) ? null : beanMappingService.mapTo(ability, AbilityDTO.class);
    }

    @Override
    public List<AbilityDTO> findAll() {
        return beanMappingService.mapTo(abilityService.findAllAbilities(), AbilityDTO.class);
    }

    @Override
    public void removeById(Long id) {
        abilityService.removeAbility(abilityService.findAbilityById(id));
    }

}
