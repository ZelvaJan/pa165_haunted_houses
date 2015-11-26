package com.peta2kuba.pa165_haunted_houses.service_layer.config;

import com.peta2kuba.pa165_haunted_houses.PersistenceTestAplicationContext;
import com.peta2kuba.pa165_haunted_houses.dto.AbilityDTO;
import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;
import com.peta2kuba.pa165_haunted_houses.dto.HauntingHoursDTO;
import com.peta2kuba.pa165_haunted_houses.dto.HouseDTO;
import com.peta2kuba.pa165_haunted_houses.dto.PersonDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import com.peta2kuba.pa165_haunted_houses.entity.House;
import com.peta2kuba.pa165_haunted_houses.entity.Person;
import com.peta2kuba.pa165_haunted_houses.service_layer.facade.PersonFacadeImpl;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.PersonService;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.PersonServiceImpl;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author turcovsky on 26/11/15.
 */
@Configuration
@Import(PersistenceTestAplicationContext.class)
@ComponentScan(basePackageClasses={PersonServiceImpl.class})
public class ServiceConfiguration {


	@Bean
	public Mapper dozer() {
		DozerBeanMapper dozer = new DozerBeanMapper();
		dozer.addMapping(new DozerCustomConfig());
		return dozer;
	}

	public class DozerCustomConfig
			extends BeanMappingBuilder {

		@Override
		protected void configure() {
			mapping(Person.class, PersonDTO.class);
			mapping(Ability.class, AbilityDTO.class);
			mapping(Haunter.class, HaunterDTO.class);
			mapping(HauntingHours.class, HauntingHoursDTO.class);
			mapping(House.class, HouseDTO.class);
		}
	}
}