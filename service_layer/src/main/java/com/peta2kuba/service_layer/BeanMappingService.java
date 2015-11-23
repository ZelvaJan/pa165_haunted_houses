package com.peta2kuba.service_layer;


import java.util.Collection;
import java.util.List;
import org.dozer.Mapper;

/**
 *
 * @author petr.melicherik
 */
public interface BeanMappingService {

    public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass);

    public <T> T mapTo(Object u, Class<T> mapToClass);

    public Mapper getMapper();
}
