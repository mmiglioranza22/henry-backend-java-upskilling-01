package com.pispring.PISpring.dao.impl;

import com.pispring.PISpring.dao.CategoriaDAO;
import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.exceptions.DAOException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {
    private final String SELECT_ALL = "SELECT * FROM categorias";
    private final String SELECT_ONE_BY_ID = "SELECT * FROM categorias WHERE id = ?";
    private final String SELECT_ONE_BY_CATEGORIA = "SELECT * FROM categorias WHERE categoria = ?";
    private final String INSERT_ONE = "INSERT INTO categorias (categoria) VALUES (?)";
    private final String UPDATE_ONE = "UPDATE categorias SET categoria = ? WHERE id = ?";
    private final String DELETE_ONE_BY_ID = "DELETE FROM categorias WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public CategoriaDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //    https://www.baeldung.com/jdbctemplate-fix-emptyresultdataaccessexception
    static class CategoriaDTOMapper implements RowMapper<CategoriaDTO> {
        public CategoriaDTO mapRow(ResultSet rs, int rowNum) throws SQLException, EmptyResultDataAccessException {
            CategoriaDTO categoriaDTO = new CategoriaDTO();
            categoriaDTO.setId(rs.getInt("id"));
            categoriaDTO.setCategoria(rs.getString("categoria"));
            return categoriaDTO;
        }
    }

    private CategoriaDTO buscarOperacionPorNombre(String nombre) throws DAOException {
        CategoriaDTO categoriaEncontrada = null;
        try {
            Object[] params = {nombre};
            int[] types = {1};
            categoriaEncontrada = jdbcTemplate.queryForObject(
                    SELECT_ONE_BY_CATEGORIA,
                    params,
                    types,
                    new CategoriaDTOMapper());
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return categoriaEncontrada;
    }

    @Override
    public CategoriaDTO buscar(Integer id) throws DAOException {
        CategoriaDTO resultado = null;
        try {
            Object[] params = {id};
            int[] types = {1};
            resultado = jdbcTemplate.queryForObject(
                    SELECT_ONE_BY_ID,
                    params,
                    types,
                    new CategoriaDTOMapper());
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public List<CategoriaDTO> buscarMuchos() throws DAOException {
        List<CategoriaDTO> lista;
        try {
            lista = jdbcTemplate.query(SELECT_ALL, new CategoriaDTOMapper());
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    @Override
    public CategoriaDTO insertar(CategoriaDTO dto) throws DAOException {
        CategoriaDTO categoria = null;
        try {
            // Primero tiene que buscar si existe, luego crearla si no devuelve ningun resultado
            categoria = this.buscarOperacionPorNombre(dto.getCategoria().toLowerCase().trim());
            if (categoria == null) {
                int filaCreada = jdbcTemplate.update(INSERT_ONE, dto.getCategoria().toLowerCase().trim());
                if (filaCreada > 0) {
                    categoria = this.buscarOperacionPorNombre(dto.getCategoria());
                }
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public CategoriaDTO modificar(CategoriaDTO dto) throws DAOException {
        CategoriaDTO resultado = null;
        try {
            int filaModificada = jdbcTemplate.update(UPDATE_ONE, dto.getCategoria().toLowerCase().trim(), dto.getId());
            if (filaModificada > 0) {
                Object[] params = {dto.getId()};
                int[] types = {1};
                resultado = jdbcTemplate.queryForObject(
                        SELECT_ONE_BY_ID,
                        params,
                        types,
                        new CategoriaDTOMapper());
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
            int filaBorada = jdbcTemplate.update(DELETE_ONE_BY_ID, id);
            if (filaBorada > 0) {
                respuesta = "Categoria con id: " + id.toString() + "borrada con éxito";
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
}
