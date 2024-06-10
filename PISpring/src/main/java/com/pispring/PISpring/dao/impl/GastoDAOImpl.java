package com.pispring.PISpring.dao.impl;

//Controllers *use* services
//Services handle business logic (what to do and how), and *use* DAOs for persistance link.
//DAOs *contracts* with persistent logic (DB), they manage their specific implementation.

import com.pispring.PISpring.dao.GastoDAO;
import com.pispring.PISpring.dto.GastoDTO;
import com.pispring.PISpring.exceptions.DAOException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GastoDAOImpl implements GastoDAO {
    //    private final String SELECT_ALL = "SELECT * FROM gastos";
//    private final String SELECT_ONE = "SELECT * FROM gastos JOIN categorias ON WHERE id = ?";
    private final String SELECT_ALL_JOIN = "SELECT gastos.*, categorias.categoria \"categoria\" FROM gastos JOIN categorias ON gastos.categoria_id = categorias.id";
    private final String SELECT_ONE_JOIN = "SELECT gastos.*, categorias.categoria \"categoria\" FROM gastos JOIN categorias ON gastos.categoria_id = categorias.id where gastos.id = ?";
    private final String UPDATE_ONE = "UPDATE gastos SET monto = ? WHERE id = ?";
    private final String DELETE_ONE = "DELETE FROM gastos WHERE id = ?";
    private final String INSERT_ONE = "INSERT INTO gastos " +
            "(monto, fecha, es_recurrente, categoria_id) " +
            "VALUES (?, ?, ?, ( SELECT id from categorias WHERE id = ? ))";

    private JdbcTemplate jdbcTemplate;

    public GastoDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    static class GastoDTOMapper implements RowMapper<GastoDTO> {
        public GastoDTO mapRow(ResultSet rs, int rowNum) throws SQLException, EmptyResultDataAccessException {
            GastoDTO gasto = new GastoDTO();
            gasto.setId(rs.getInt("id"));
            gasto.setCategoriaId(rs.getInt("categoria_id"));
            gasto.setCategoria(rs.getString("categoria"));
            gasto.setMonto(rs.getDouble("monto"));
            gasto.setFecha(rs.getDate("fecha"));
            gasto.setEsRecurrente(rs.getBoolean("es_recurrente"));
            return gasto;
        }
    }

    @Override
    public GastoDTO buscar(Integer id) throws DAOException {
        GastoDTO resultado;
        try {
            Object[] params = {id};
            int[] types = {1};
            resultado = jdbcTemplate.queryForObject(
                    SELECT_ONE_JOIN,
                    params,
                    types,
                    new GastoDTOMapper());
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return resultado;
    }

    @Override
    public List<GastoDTO> buscarMuchos() throws DAOException {
        List<GastoDTO> lista;
        try {
            lista = jdbcTemplate.query(SELECT_ALL_JOIN, new GastoDTOMapper());
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    @Override
    public GastoDTO insertar(GastoDTO dto) throws DAOException {
        GastoDTO nuevoGasto = null;
        try {
            int filaCreada = jdbcTemplate.update(INSERT_ONE,
                    dto.getMonto(),
                    dto.getFecha(),
                    dto.isSaldado(),
                    dto.getCategoriaId());
//            El id no es
            if (filaCreada > 0) {
                nuevoGasto = dto;
            } else {
                System.out.println("ERROR AL CREAR CATEGORIA DEL GASTO");
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return nuevoGasto;
    }

    //    Hay una forma de hacer la modificación específica / atómica? Leer la key
    //    el DTO tiene que tener el id y el campo a modificar -> https://stackoverflow.com/questions/52406467/convert-object-to-map-in-java
    //    https://www.baeldung.com/spring-events
    @Override
    public GastoDTO modificar(GastoDTO dto) throws DAOException {
        GastoDTO resultado = null;
        System.out.println(dto.getMonto());
        try {
            int filaModificada = jdbcTemplate.update(UPDATE_ONE, dto.getMonto(), dto.getId());
            if (filaModificada > 0) {
                Object[] params = {dto.getId()};
                int[] types = {1};
                resultado = jdbcTemplate.queryForObject(
                        SELECT_ONE_JOIN,
                        params,
                        types,
                        new GastoDTOMapper());
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public String eliminar(Integer id) throws DAOException {
        String respuesta = "";
        try {
            int filaBorada = jdbcTemplate.update(DELETE_ONE, id);
            if (filaBorada > 0) {
                respuesta = "Gasto con id: " + id.toString() + "borrada con éxito";
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
}