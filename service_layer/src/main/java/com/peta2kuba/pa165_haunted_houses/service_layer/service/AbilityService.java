package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * An interface that defines a service access to the {@link Ability} entity.
 *
 * @author petr.melicherik
 */
@Service
public interface AbilityService {

    void createAbility(Ability ability);

    void editAbility(Ability ability);

    void removeAbility(Ability ability);

    Ability findAbilityById(Long id);

    List<Ability> findAllAbilities();

}
