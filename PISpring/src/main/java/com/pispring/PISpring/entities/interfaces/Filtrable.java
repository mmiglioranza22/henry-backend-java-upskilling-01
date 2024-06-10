package com.pispring.PISpring.entities.interfaces;

import com.pispring.PISpring.entities.Operacion;

@FunctionalInterface
public interface Filtrable {
    public boolean cumpleFiltro(Operacion operacion);

}
