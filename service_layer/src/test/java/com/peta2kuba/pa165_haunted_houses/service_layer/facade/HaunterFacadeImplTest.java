package com.peta2kuba.pa165_haunted_houses.service_layer.facade;

import com.peta2kuba.pa165_haunted_houses.dao.HaunterDao;
import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;
import com.peta2kuba.pa165_haunted_houses.dto.HauntingHoursDTO;
import com.peta2kuba.pa165_haunted_houses.dto.PersonAuthenticateDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Ability;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import com.peta2kuba.pa165_haunted_houses.entity.HauntingHours;
import com.peta2kuba.pa165_haunted_houses.facade.HaunterFacade;
import com.peta2kuba.pa165_haunted_houses.service_layer.BeanMappingService;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.pa165_haunted_houses.service_layer.service.HaunterService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author skornok on 26/11/15.
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class HaunterFacadeImplTest extends AbstractTransactionalTestNGSpringContextTests {

	@Mock
	private HaunterDao haunterDao;

	@Autowired
	@InjectMocks
	private HaunterService haunterService;

	@Autowired
	private BeanMappingService mapper;

	@Autowired
	private HaunterFacade haunterFacade;

	private Haunter haunter;
	private HauntingHours hh;
	private HaunterDTO haunterDTO;
	private HauntingHoursDTO hhDTO;

	@org.testng.annotations.BeforeClass
	public void initClass() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeMethod
	public void init() {
		hh = new HauntingHours();
		hh.setFromTime(Time.valueOf("8:00:00"));
		hh.setToTime(Time.valueOf("20:00:00"));

		haunter = new Haunter();
		haunter.setHauntingHours(hh);
		haunter.setName("Premek");
		haunter.setDescription("Haunting people with his enormous head");
		haunter.setHauntingReason("Because");

		haunterDTO = mapper.mapTo(haunter, HaunterDTO.class);
	}

	@Test
	public void testCreateHaunter() {
		haunterFacade.createHaunter(haunterDTO);
		verify(haunterDao).create(haunter);
	}

	@Test
	public void testEditHaunter() {
		haunterFacade.editHaunter(haunterDTO);
		verify(haunterDao).edit(haunter);
	}

	@Test
	public void testRemoveHaunter() {
		haunterFacade.removeHaunter(haunterDTO);
		verify(haunterDao).remove(haunter);
	}

	@Test
	public void testFindById() {
		Mockito.when(haunterDao.findById(any(Long.class))).thenReturn(haunter);
		HaunterDTO hDTO = haunterFacade.findById(0l);
		Assert.assertEquals(mapper.mapTo(haunter, HaunterDTO.class), hDTO);
	}

	@Test
	public void testFindByName() {
		Mockito.when(haunterDao.findByName(any(String.class))).thenReturn(haunter);
		HaunterDTO hDTO = haunterFacade.findByName("asdf");
		Assert.assertEquals(mapper.mapTo(haunter, HaunterDTO.class), hDTO);
	}

	@Test
	public void testFindAll() {
		List<Haunter> haunters = new ArrayList<>();
		haunters.add(haunter);

		when(haunterDao.findAll()).thenReturn(haunters);
		List<HaunterDTO> haunterDTOs = haunterFacade.findAll();
		Assert.assertEquals(mapper.mapTo(haunters, HaunterDTO.class), haunterDTOs);
	}

	@Test
	public void testFindActiveHaunters() {
		List<Haunter> haunters = new ArrayList<>();
		haunters.add(haunter);

		when(haunterDao.findActiveHaunters()).thenReturn(haunters);
		List<HaunterDTO> haunterDTOs = haunterFacade.findActiveHaunters();
		Assert.assertEquals(mapper.mapTo(haunters, HaunterDTO.class), haunterDTOs);
	}

	@Test
	public void testIsHaunterStronger() {
		Haunter haunter2 = new Haunter();
		haunter2.setHauntingHours(hh);
		haunter2.setName("Stronger");
		haunter2.setDescription("Haunting people with his enormous head");
		haunter2.setHauntingReason("Because");

		Ability a = new Ability();
		a.setName("Big head");
		a.setDescription("It's really large. Watch out!");
		ArrayList<Ability> aList = new ArrayList<>();
		aList.add(a);
		haunter2.setAbilities(aList);

		HaunterDTO haunterDTO2 = mapper.mapTo(haunter2, HaunterDTO.class);

		long result = haunterFacade.isHaunterStronger(haunterDTO, haunterDTO2);
		Assert.assertTrue(result < 0);
	}
}