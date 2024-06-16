package com.pispring.PISpring.repository;

import com.pispring.PISpring.exceptions.DAOException;

import java.util.List;

//usa y devuelve DTOs
public interface Repository<T, K> {
    public T buscar(K id) throws DAOException;

    public List<T> buscarMuchos() throws DAOException;

    public T insertar(T input) throws DAOException;

    public T modificar(K id, T input) throws DAOException;

    public String eliminar(K id) throws DAOException;

}