package entities.interfaces;

import entities.Operacion;

@FunctionalInterface
public interface Filtrable {
    public boolean cumpleFiltro(Operacion operacion);

}
