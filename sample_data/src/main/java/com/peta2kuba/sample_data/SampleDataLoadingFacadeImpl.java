/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.sample_data;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author skornok
 */
@Component
@Transactional //transactions are handled on facade layer
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {
    
    final static Logger log = LoggerFactory.getLogger(SampleDataLoadingFacadeImpl.class);

    @Override
    @SuppressWarnings("unused")
    public void loadData() throws IOException {
        log.info("Loaded Haunted Houses.");

        createPeople();
        createHouses();
        createAbilities();
        createHaunters();
    }

    private void createPeople() {

    }

    private void createHouses() {

    }

    private void createAbilities() {

    }

    private void createHaunters() {

    }
    
}
