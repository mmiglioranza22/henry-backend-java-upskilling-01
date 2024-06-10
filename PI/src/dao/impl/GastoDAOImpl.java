package dao.impl;

import dao.GastoDAO;
import dao.dto.GastoDTO;
import exceptions.DAOException;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//Controllers *use* services
//Services handle business logic (what to do and how), and *use* DAOs for persistance link.
//DAOs *contracts* with persistent logic (DB), they manage their specific implementation.

public class GastoDAOImpl implements GastoDAO {
    private final String SELECT_ALL = "SELECT * FROM gastos";
    private final String SELECT_ONE = "SELECT * FROM gastos WHERE id = ?";
    private final String UPDATE_ONE = "UPDATE gastos SET monto = ? WHERE id = ?";
    //    private final String UPDATE_ONE_TEST = "UPDATE gastos SET ? = ? WHERE id = ?";
    private final String DELETE_ONE = "DELETE FROM gastos WHERE id = ?";
    private final String INSERT_ONE = "INSERT INTO gastos " +
            "(monto, fecha, es_recurrente, categoria_id) " +
            "VALUES (?, ?, ?, ( SELECT id from categorias WHERE id = ? ))";

    Connection connection;

    public GastoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public GastoDTO buscarOperacion(Integer id) throws DAOException {
        GastoDTO gasto = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement(SELECT_ONE);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                gasto = this.mappeo(set);
            }
            set.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gasto;
    }

    @Override
    public List<GastoDTO> buscarOperaciones() throws DAOException {
        List<GastoDTO> lista = new ArrayList<>();
        try {
            PreparedStatement statement = this.connection.prepareStatement(SELECT_ALL);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                lista.add(this.mappeo(set));
            }
            set.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private GastoDTO mappeo(ResultSet set) throws SQLException {
        GastoDTO gasto = new GastoDTO();
        gasto.setId(set.getInt("id"));
        gasto.setCategoriaId(set.getInt("categoria_id"));
        gasto.setMonto(set.getDouble("monto"));
        gasto.setFecha(set.getDate("fecha"));
        gasto.setEsRecurrente(set.getBoolean("es_recurrente"));
        return gasto;
    }

    @Override
    public void insertarOperacion(GastoDTO dto) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_ONE);
            statement.setDouble(1, dto.getMonto());
            statement.setDate(2, new Date(dto.getFecha().getTime()));
            statement.setBoolean(3, dto.isEsRecurrente());
            statement.setInt(4, dto.getCategoriaId());

            statement.executeUpdate();
            statement.close();
            System.out.println("Gasto creado en DB OK!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    Hay una forma de hacer la modificación específica / atómica? Leer la key
    //    el DTO tiene que tener el id y el campo a modificar -> https://stackoverflow.com/questions/52406467/convert-object-to-map-in-java
    //    https://www.baeldung.com/spring-events
    @Override
    public void modificarOperacion(GastoDTO input) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_ONE);
            statement.setDouble(1, input.getMonto());
            statement.setInt(2, input.getId());

            statement.executeUpdate();
            statement.close();
            System.out.println("Gasto modificado en DB OK!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarOperacion(Integer id) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_ONE);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
            System.out.println("Gasto eliminado en DB OK!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
