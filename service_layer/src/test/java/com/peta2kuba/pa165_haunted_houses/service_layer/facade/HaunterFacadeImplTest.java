package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dto.AbilityDTO;
import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;
import com.peta2kuba.pa165_haunted_houses.dto.HauntingHoursDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import com.peta2kuba.pa165_haunted_houses.facade.HaunterFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.BeanMappingService;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.HaunterService;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author skornok on 26/11/15.
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class HaunterFacadeImplTest {

	@Autowired
	private HaunterService haunterService;

	@Autowired
	private BeanMappingService mapper;

	@Autowired
	private HaunterFacade haunterFacade;

	private Haunter h;
	private HauntingHours hh;
	private HaunterDTO hDTO;
	private HauntingHoursDTO hhDTO;

	@BeforeMethod
	public void initSingleTest() {
		hh = new HauntingHours();
		hh.setFromTime(Time.valueOf("8:00:00"));
		hh.setToTime(Time.valueOf("20:00:00"));

		Ability a = new Ability();
		a.setName("Big head");
		a.setDescription("It's really large. Watch out!");
		ArrayList<Ability> aList = new ArrayList<>();
		aList.add(a);

		h = new Haunter();
		h.setHauntingHours(hh);
		h.setName("Premek");
		h.setDescription("Haunting people with his enormous head");
		h.setHauntingReason("Because");
		h.setAbilities(aList);


		hhDTO = new HauntingHoursDTO();
		hhDTO.setFromTime(Time.valueOf("8:00:00"));
		hhDTO.setToTime(Time.valueOf("20:00:00"));

		AbilityDTO aDTO = new AbilityDTO();
		aDTO.setName("Big head");
		aDTO.setDescription("It's really large. Watch out!");
		ArrayList<AbilityDTO> aListDTO = new ArrayList<>();
		aListDTO.add(aDTO);

		hDTO = new HaunterDTO();
		hDTO.setHauntingHours(hhDTO);
		hDTO.setName("Premek");
		hDTO.setDescription("Haunting people with his enormous head");
		hDTO.setHauntingReason("Because");
		hDTO.setAbilities(aListDTO);
	}

	@BeforeClass
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateHaunter() {

	}

	@Test
	public void testEditHaunter() {

	}

	@Test
	public void testRemoveHaunter() {

	}

	@Test
	public void testFindById() {
		h.setId(0l);
		hDTO.setId(0l);

		when(mapper.mapTo(h, HaunterDTO.class)).thenReturn(hDTO);
		when(haunterService.findById(0l)).thenReturn(h);

		Assert.assertEquals(haunterFacade.findById(0l), hDTO);
		Assert.assertNull(haunterFacade.findById(1l));

		verify(mapper).mapTo(h, HaunterDTO.class);
		verify(haunterService).findById(0l);
	}

	@Test
	public void testFindByName() {

	}

	@Test
	public void testFindAll() {

	}

	@Test
	public void testFindActiveHaunters() throws Exception {

	}

	@Test
	public void testIsHaunterStronger() throws Exception {

	}
}