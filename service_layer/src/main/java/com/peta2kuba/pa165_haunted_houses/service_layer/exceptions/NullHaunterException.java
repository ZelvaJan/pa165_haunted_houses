/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peta2kuba.pa165_haunted_houses.service_layer.exceptions;

/**
 *
 * @author petr.melicherik
 */
public class NullHaunterException extends NullPointerException {

    public NullHaunterException() {
        super("Non existing haunter.");
    }

}
