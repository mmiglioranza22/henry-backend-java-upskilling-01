package com.pispring.PISpring.dao;

import com.pispring.PISpring.exceptions.DAOException;

import java.util.List;

//usa y devuelve DTOs
public interface DAO<T, K> {
    public T buscar(K id) throws DAOException;

    public List<T> buscarMuchos() throws DAOException;

    public T insertar(T dto) throws DAOException;

    public T modificar(T dto) throws DAOException;

    public String eliminar(K id) throws DAOException;

}