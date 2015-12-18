/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.sample_data;

import com.peta2kuba.pa165_haunted_houses.service_layer.config.ServiceConfiguration;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author skornok
 */
@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackageClasses = {SampleDataLoadingFacadeImpl.class})
public class HauntedHousesWithSampleDataConfiguration {
    
    final static Logger log = LoggerFactory.getLogger(HauntedHousesWithSampleDataConfiguration.class);

    @Autowired
    SampleDataLoadingFacade sampleDataLoadingFacade;

    @PostConstruct
    public void dataLoading() throws IOException {
        log.debug("dataLoading()");
        sampleDataLoadingFacade.loadData();
    }

}
