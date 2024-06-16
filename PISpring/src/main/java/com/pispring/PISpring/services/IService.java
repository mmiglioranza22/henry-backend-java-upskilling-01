package com.pispring.PISpring.services;

import java.util.List;

public interface IService<T, K> {
    public List<T> buscarEntidades();

    public T buscarEntidad(K id);

    public T crearEntidad(T input);

    public T modificarEntidad(K id, T input);

    public String eliminarEntidad(K id);
}
