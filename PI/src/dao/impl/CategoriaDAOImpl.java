package dao.impl;

import dao.CategoriaDAO;
import dao.dto.CategoriaDTO;
import exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {
    private final String SELECT_ALL = "SELECT * FROM categorias";
    private final String SELECT_ONE = "SELECT * FROM categorias WHERE categoria = ?";
    private final String UPDATE_ONE = "UPDATE categorias SET categoria = ? WHERE categoria = ?";
    private final String DELETE_ONE_BY_LIKE = "DELETE FROM categorias WHERE categoria = ?";
    private final String DELETE_ONE_BY_ID = "DELETE FROM categorias WHERE id = ?";

    private final String INSERT_ONE = "INSERT INTO categorias (categoria) VALUES (?)";

    Connection connection;

    public CategoriaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public CategoriaDTO buscarOperacion(String categoria) throws DAOException {
        CategoriaDTO nuevaCategoria = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ONE);
            statement.setString(1, categoria);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                nuevaCategoria = this.mappeo(set);
            }
            set.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar nueva categoria en base de datos");
            e.printStackTrace();
        }
        return nuevaCategoria;
    }

    @Override
    public List<CategoriaDTO> buscarOperaciones() throws DAOException {
        List<CategoriaDTO> lista = new ArrayList<>();
        try {
            PreparedStatement statement = this.connection.prepareStatement(SELECT_ALL);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                lista.add(this.mappeo(set));
            }
            set.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error buscando operaciones");
            e.printStackTrace();
        }
        return lista;
    }

    public CategoriaDTO mappeo(ResultSet set) throws SQLException {
        CategoriaDTO nuevaCategoria = new CategoriaDTO(set.getString("categoria"));
        nuevaCategoria.setId(set.getInt("id"));
        return nuevaCategoria;
    }

    @Override
    public void insertarOperacion(CategoriaDTO dto) throws DAOException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(INSERT_ONE);
            statement.setString(1, dto.getCategoria());

            statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            statement.close();
            System.out.println("Categoria creada con éxito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificarOperacion(CategoriaDTO dto) throws DAOException {

    }

    @Override
    public void eliminarOperacion(String categoria) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_ONE_BY_LIKE);
            statement.setString(1, categoria);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarOperacion(int id) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_ONE_BY_ID);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
