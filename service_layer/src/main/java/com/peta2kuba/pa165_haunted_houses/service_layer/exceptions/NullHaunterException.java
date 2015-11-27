package com.peta2kuba.pa165_haunted_houses.service_layer.exceptions;

/**
 * This should be thrown if any Haunter instance is null
 * @author petr.melicherik
 */
public class NullHaunterException extends NullPointerException {

    public NullHaunterException() {
        super("Non existing haunter.");
    }

}
