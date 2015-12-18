package com.peta2kuba.pa165_haunted_houses.config;

import com.peta2kuba.pa165_haunted_houses.controller.PersonController;
import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import com.peta2kuba.sample_data.HauntedHousesWithSampleDataConfiguration;
import com.peta2kuba.sample_data.SampleDataLoadingFacadeImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author turcovsky on 09/12/15.
 */
@EnableWebMvc
@Configuration
@Import({ServiceConfiguration.class, HauntedHousesWithSampleDataConfiguration.class})
@ComponentScan(basePackageClasses = {PersonController.class})
public class RestConfiguration extends WebMvcConfigurerAdapter {

}
