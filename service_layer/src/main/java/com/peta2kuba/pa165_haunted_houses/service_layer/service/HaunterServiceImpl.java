package com.peta2kuba.pa165_haunted_houses.service_layer.service;

import com.peta2kuba.pa165_haunted_houses.dao.HaunterDao;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.service_layer.exceptions.NullHaunterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the
 * {@link com.peta2kuba.pa165_haunted_houses.service_layer.service.HaunterService}.
 * This class is part of the service module of the application that provides the
 * implementation of the business logic.
 *
 * @author skornok on 25/11/15.
 */
@Service
public class HaunterServiceImpl implements HaunterService {

    @Autowired
    private HaunterDao haunterDao;

    @Override
    public void createHaunter(final Haunter haunter) {
        haunterDao.create(haunter);
    }

    @Override
    public void editHaunter(final Haunter haunter) {
        haunterDao.edit(haunter);
    }

    @Override
    public void removeHaunter(final Haunter haunter) {
        haunterDao.remove(haunter);
    }

    @Override
    public Haunter findById(final Long id) {
        return haunterDao.findById(id);
    }

    @Override
    public Haunter findByName(final String name) {
        return haunterDao.findByName(name);
    }

    @Override
    public List<Haunter> findAll() {
        return haunterDao.findAll();
    }

    @Override
    public List<Haunter> findActiveHaunters() {
        return haunterDao.findActiveHaunters();
    }

    @Override
    public long isHaunterStronger(Haunter actualHaunter, Haunter competitorHaunter) {
        if (actualHaunter != null && competitorHaunter != null) {
            long actualHaunterPower = getNamePower(actualHaunter.getName())
                    + getAbilityPower(actualHaunter.getAbility());
            long competitorHaunterPower = getNamePower(competitorHaunter.getName())
                    + getAbilityPower(competitorHaunter.getAbility());
            return Long.compare(actualHaunterPower, competitorHaunterPower);
        } else {
            throw new NullHaunterException();
        }
    }

    private long getNamePower(String name) {
        if (name != null) {
            return name.length() * 10;
        } else {
            return 0;
        }
    }

    private long getAbilityPower(List<Ability> abilities) {
        if (abilities != null) {
            long abilityPower = 0;
            abilityPower = abilities.stream().filter((ability) -> (ability != null && ability.getName() != null)).map((Ability ability) -> {
                long subPower = ability.getName().length() * 10;
                if (ability.getName().contains("ULTRA")) {
                    subPower *= 4;
                }
                if (ability.getName().contains("MEGA")) {
                    subPower *= 2;
                }
                return subPower;
            }).map((subPower) -> {
                return subPower;
            }).reduce(abilityPower, (accumulator, _item) -> accumulator + _item);

            return abilityPower;
        } else {
            return 0;
        }
    }
}
