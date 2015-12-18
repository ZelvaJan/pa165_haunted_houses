package com.peta2kuba.sample_data;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.AbilityService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.HaunterService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.HauntingHoursService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.HouseService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author skornok
 */
@Component
@Transactional
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {

    final static Logger log = LoggerFactory.getLogger(SampleDataLoadingFacadeImpl.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private AbilityService abilityService;

    @Autowired
    private HaunterService haunterService;

    @Autowired
    private HauntingHoursService hauntingHoursService;

    @Override
    @SuppressWarnings("unused")
    public void loadData() throws IOException {
        log.info("Loaded Haunted Houses.");

        Person admin1 = person("jakubturcovsky@seznam.cz", "aaaaaa", true);
        Person admin2 = person("petrmelicherik@seznam.cz", "bbbbbb", true);
        Person admin3 = person("petrskornok@seznam.cz", "cccccc", true);
        Person person1 = person("email1@mail.com", "dddddd", false);
        Person person2 = person("email2@mail.com", "eeeeee", false);
        Person person3 = person("email3@mail.com", "ffffff", false);
        Person person4 = person("email4@mail.com", "gggggg", false);
        Person person5 = person("email5@mail.com", "hhhhhh", false);

        House house1 = house("name1", "address1", Timestamp.valueOf("2015-09-01 08:00:00.0"), "U Premy doma", null);
        House house2 = house("name2", "address2", Timestamp.valueOf("2014-08-02 08:50:00.0"), "U Kuby doma", null);
        House house3 = house("name3", "address3", Timestamp.valueOf("2013-07-03 08:00:23.0"), "U Peti doma", null);
        House house4 = house("name4", "address4", Timestamp.valueOf("2015-06-04 11:00:00.0"), "U Peti2 doma", null);
        House house5 = house("name5", "address5", Timestamp.valueOf("2011-05-05 08:00:00.0"), "U Markety doma", null);
        House house6 = house("name6", "address6", Timestamp.valueOf("2015-04-06 11:50:00.0"), "U Mariky doma", null);
        House house7 = house("name7", "address7", Timestamp.valueOf("2004-03-07 16:45:00.0"), "U Romana doma", null);
        House house8 = house("name8", "address8", Timestamp.valueOf("2015-02-08 17:34:00.0"), "U Lojzy doma", null);
        House house9 = house("name9", "address9", Timestamp.valueOf("2003-01-09 01:01:00.0"), "U Ladi doma", null);

        HauntingHours hh1 = hauntingHours(Time.valueOf("07:00:00"), Time.valueOf("12:00:00"));
        HauntingHours hh2 = hauntingHours(Time.valueOf("07:00:00"), Time.valueOf("17:00:00"));
        HauntingHours hh3 = hauntingHours(Time.valueOf("11:00:00"), Time.valueOf("12:00:00"));
        HauntingHours hh4 = hauntingHours(Time.valueOf("11:00:00"), Time.valueOf("10:00:00"));
        HauntingHours hh5 = hauntingHours(Time.valueOf("13:00:00"), Time.valueOf("22:00:00"));
        HauntingHours hh6 = hauntingHours(Time.valueOf("20:00:00"), Time.valueOf("23:59:59"));
        HauntingHours hh7 = hauntingHours(Time.valueOf("20:00:00"), Time.valueOf("03:00:00"));
        HauntingHours hh8 = hauntingHours(Time.valueOf("22:00:00"), Time.valueOf("05:50:00"));
        HauntingHours hh9 = hauntingHours(Time.valueOf("15:00:00"), Time.valueOf("12:00:00"));

        Ability ability1 = ability("MEGA Head", "Extremely large head");
        Ability ability2 = ability("ULTRA stinking smell", "Stinks a lot!");
        Ability ability3 = ability("sample ability", "Sample description");
        Ability ability4 = ability("random ability", "Random description");
        Ability ability5 = ability("Greening", "Makes you green");
        Ability ability6 = ability("Clumsiness", "Like Jar Jar Binks");
        Ability ability7 = ability("Force pull", "Pull a pretty girl towards yourself");
        Ability ability8 = ability("Force push", "Push an ugly girl away");
        Ability ability9 = ability("Force lightning", "Palpatine-like");

        Haunter haunter1 = haunter("Prema", hh1, "The master haunter", "He just is.", abilityList(ability1));
        Haunter haunter2 = haunter("Haunter2", hh2, "Servant1", "Because.", abilityList(ability2, ability3));
        Haunter haunter3 = haunter("Haunter3", hh3, "Servant2", "Because I've said so", abilityList(ability2, ability3, ability4));
        Haunter sith = haunter("Palpatine", hh9, "Master Sith", "Wants to conquer the galaxy", abilityList(ability7, ability8, ability9));
        Haunter jedi = haunter("Yoda", hh5, "Master Jedi", "Talks funny", abilityList(ability7, ability8));
        Haunter haunter5 = haunter("Windu", hh6, "Samuel L. Jackson", "Motherfucking placeholder text motherfucker!", abilityList(ability7, ability8, ability5));
        Haunter jarjar = haunter("Jar Jar Binks", hh4, "Be extremely aware. It's a secret Sith Lord!", "Placeholder", abilityList(ability9, ability6));

        house1.setHaunter(haunter1);
        haunter1.setHouse(house1);

        house2.setHaunter(jedi);
        jedi.setHouse(house2);

        house3.setHaunter(jarjar);
        jarjar.setHouse(house3);

        house4.setHaunter(sith);
        sith.setHouse(house4);
    }

    private Person person(final String email, final String password, boolean admin) {
        Person person = new Person(email, password, admin);
        personService.createPerson(person);

        return person;
    }

    private House house(final String name, final String address, final Timestamp hauntedSince, final String description, final Haunter haunter) {
        House house = new House(name, address, hauntedSince, description, haunter);
        houseService.createHouse(house);

        return house;
    }

    private Ability ability(final String name, final String description) {
        Ability ability = new Ability(name, description);
        abilityService.createAbility(ability);

        return ability;
    }

    private Haunter haunter(final String name, final HauntingHours hauntingHours, final String description, final String hauntingReason, final List<Ability> abilities) {
        Haunter haunter = new Haunter(name, hauntingHours, description, hauntingReason, abilities);
        haunterService.createHaunter(haunter);

        return haunter;
    }

    private HauntingHours hauntingHours(final Time fromTime, final Time toTime) {
        HauntingHours hh = new HauntingHours(fromTime, toTime);
        hauntingHoursService.createHauntingHours(hh);

        return hh;
    }

    private ArrayList<Ability> abilityList(Ability a1) {
        ArrayList<Ability> list = new ArrayList<>();
        list.add(a1);

        return list;
    }

    private ArrayList<Ability> abilityList(Ability a1, Ability a2) {
        ArrayList<Ability> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);

        return list;
    }

    private ArrayList<Ability> abilityList(Ability a1, Ability a2, Ability a3) {
        ArrayList<Ability> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        return list;
    }

    private ArrayList<Haunter> haunterList(Haunter h1) {
        ArrayList<Haunter> list = new ArrayList<>();
        list.add(h1);

        return list;
    }

    private ArrayList<Haunter> haunterList(Haunter h1, Haunter h2) {
        ArrayList<Haunter> list = new ArrayList<>();
        list.add(h1);
        list.add(h2);

        return list;
    }

    private ArrayList<Haunter> haunterList(Haunter h1, Haunter h2, Haunter h3) {
        ArrayList<Haunter> list = new ArrayList<>();
        list.add(h1);
        list.add(h2);
        list.add(h3);

        return list;
    }
}
