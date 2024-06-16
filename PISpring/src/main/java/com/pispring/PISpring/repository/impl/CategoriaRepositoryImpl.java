package com.pispring.PISpring.repository.impl;

import com.pispring.PISpring.entities.Categoria;
import com.pispring.PISpring.repository.CategoriaRepository;
import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.exceptions.DAOException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {
    private final String SELECT_ALL = "SELECT * FROM categorias";
    private final String SELECT_ONE_BY_ID = "SELECT * FROM categorias WHERE id = ?";
    private final String SELECT_ONE_BY_CATEGORIA = "SELECT * FROM categorias WHERE categoria = ?";
    private final String INSERT_ONE = "INSERT INTO categorias (categoria) VALUES (?)";
    private final String UPDATE_ONE = "UPDATE categorias SET categoria = ? WHERE id = ?";
    private final String DELETE_ONE_BY_ID = "DELETE FROM categorias WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public CategoriaRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Categoria mapDTOtoModel(CategoriaDTO resultado) {
        return new Categoria(resultado.getId(), resultado.getCategoria());
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
            return null;
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
    public CategoriaDTO insertar(CategoriaDTO input) throws DAOException {
        CategoriaDTO categoria = null;
        try {
            Categoria model = new Categoria(input.getCategoria());
            String nombreCategoria = model.getNombre().toLowerCase().trim();
            // Primero tiene que buscar si existe, luego crearla si no devuelve ningun resultado
            categoria = this.buscarOperacionPorNombre(nombreCategoria);
            if (categoria == null) {
                int filaCreada = jdbcTemplate.update(INSERT_ONE, nombreCategoria);
                if (filaCreada > 0) {
                    categoria = this.buscarOperacionPorNombre(nombreCategoria);
                }
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return categoria;
    }

    @Override
    public CategoriaDTO modificar(Integer id, CategoriaDTO input) throws DAOException {
        CategoriaDTO resultado = null;
        try {
            Categoria model = new Categoria(id, input.getCategoria());
            int filaModificada = jdbcTemplate.update(UPDATE_ONE, model.getNombre().toLowerCase().trim(), id);
            if (filaModificada > 0) {
                Object[] params = {id};
                int[] types = {1};
                resultado = jdbcTemplate.queryForObject(
                        SELECT_ONE_BY_ID,
                        params,
                        types,
                        new CategoriaDTOMapper());
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return resultado;
    }

    @Override
    public String eliminar(Integer id) throws DAOException {
        String respuesta = "";
        try {
            int filaBorada = jdbcTemplate.update(DELETE_ONE_BY_ID, id);
            if (filaBorada > 0) {
                respuesta = "Categoria con id: " + id.toString() + " borrada con éxito";
            }
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            respuesta = "Error al borrar la categoria";
        }
        return respuesta;
    }
}
