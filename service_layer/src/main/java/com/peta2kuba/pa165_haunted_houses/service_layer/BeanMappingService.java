package com.peta2kuba.pa165_haunted_houses.service_layer;


import java.util.Collection;
import java.util.List;

import com.peta2kuba.pa165_haunted_houses.dto.HaunterDTO;
import com.peta2kuba.pa165_haunted_houses.entity.Haunter;
import org.dozer.Mapper;

/**
 *
 * @author petr.melicherik
 */
public interface BeanMappingService {

    <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass);

    <T> T mapTo(Object u, Class<T> mapToClass);

    Mapper getMapper();

}
