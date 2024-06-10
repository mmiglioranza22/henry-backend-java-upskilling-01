package utils;

import entities.Operacion;

import java.util.ArrayList;
import java.util.List;

public class UtilidadOperacion<T extends Operacion> {

    public List<T> lista;

    public UtilidadOperacion() {
        this.lista = new ArrayList<T>();
    }

    public void registrarOperacion(T operacion) {
        this.lista.add(operacion);
        System.out.println("Operación creada, tipo: " + operacion.getClass().getName());
    }

    public void imprimirOperaciones() {
        this.lista.forEach(operacion -> System.out.println(operacion.toString()));
    }
}
