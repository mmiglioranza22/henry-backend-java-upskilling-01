package com.pispring.PISpring.repository.impl;

//Controllers *use* services
//Services handle business logic (what to do and how), and *use* DAOs for persistance link.
//DAOs *contracts* with persistent logic (DB), they manage their specific implementation.

import com.pispring.PISpring.entities.Gasto;
import com.pispring.PISpring.repository.GastoRepository;
import com.pispring.PISpring.dto.GastoDTO;
import com.pispring.PISpring.exceptions.DAOException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

//categoria_id = (SELECT id FROM categorias WHERE categoria = ?)
@Repository
public class GastoRepositoryImpl implements GastoRepository {
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

    public GastoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Gasto mapDTOtoModel(GastoDTO resultado) {
        Gasto gasto = new Gasto();
        gasto.setId(resultado.getId());
        gasto.setMonto(resultado.getMonto());
        gasto.setFecha(resultado.getFecha());
        gasto.setCategoriaId(resultado.getCategoriaId());
        gasto.setEsRecurrente(resultado.isEsRecurrente());
        gasto.setCategoria(resultado.getCategoria());
        return gasto;
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
    public GastoDTO insertar(GastoDTO input) throws DAOException {
        GastoDTO nuevoGasto = null;
        try {
            Gasto model = this.mapDTOtoModel(input);
            int filaCreada = jdbcTemplate.update(INSERT_ONE,
                    model.getMonto(),
                    model.getFecha(),
                    model.isSaldado(),
                    model.getCategoriaId());
            if (filaCreada > 0) {
                // Se devuelve el mismo dto, visto que la query update no devuelve el mismo objeto creado
                nuevoGasto = input;
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
    //    https://stackoverflow.com/questions/52406467/convert-object-to-map-in-java
    //    https://www.baeldung.com/spring-events
    @Override
    public GastoDTO modificar(Integer id, GastoDTO input) throws DAOException {
        GastoDTO resultado = null;
        try {
            Gasto model = this.mapDTOtoModel(input);
            int filaModificada = jdbcTemplate.update(UPDATE_ONE, model.getMonto(), id);
            if (filaModificada > 0) {
                Object[] params = {id};
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
                respuesta = "Gasto con id: " + id.toString() + " borrada con éxito";
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
}