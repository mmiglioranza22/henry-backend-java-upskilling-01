package dao;

import exceptions.DAOException;

import java.util.List;

//use y devuelve DTOs
public interface DAO<T, K> {
    public T buscarOperacion(K id) throws DAOException;

    public List<T> buscarOperaciones() throws DAOException;

    public void insertarOperacion(T dto) throws DAOException;

    public void modificarOperacion(T dto) throws DAOException;

    public void eliminarOperacion(K id) throws DAOException;

}
