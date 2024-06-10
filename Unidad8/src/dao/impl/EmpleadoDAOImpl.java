package dao.impl;

import config.JDBCConfiguration;
import dao.DAO;
import dao.dto.EmpleadoDTO;
import entities.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAOImpl implements DAO {
    private final String INSERT_ONE = "INSERT INTO empleados (nombre, salario) VALUES (?, ?)";

    Connection connection = JDBCConfiguration.getDBConnection();

    public EmpleadoDAOImpl() {
    }

 
    @Override
    public Empleado getEmpleado(int idEmpleado) {
        // Definir la sentencia SQL con un placeholder (?) para el ID
        String sql = "SELECT * FROM empleados WHERE id = ?";
        Empleado empleado = new Empleado();
        try {
            int id;
            String nombre;
            float salario;
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, idEmpleado);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                nombre = resultSet.getString("nombre");
                salario = resultSet.getFloat("salario");
                empleado.setId(id);
                empleado.setNombre(nombre);
                empleado.setSalario(salario);
            }
            // Cerrar el PreparedStatement
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleado;
    }

    @Override
    public Empleado insertar(EmpleadoDTO empleado) {

        Empleado nuevoEmpleado;

        try {
            // Establecer los valores en el PreparedStatement
            // Crear un PreparedStatement a partir de la sentencia SQL
            PreparedStatement stmt = connection.prepareStatement(INSERT_ONE);

            stmt.setString(1, empleado.getNombre());
            stmt.setFloat(2, empleado.getSalario());

            // Ejecutar la inserción
            stmt.executeUpdate();

            // Cerrar el PreparedStatement
            stmt.close();

            System.out.println("Registro insertado exitosamente.");
//            empleado = new Empleado
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Empleado();
    }

    @Override
    public Empleado modificar(EmpleadoDTO empleado) {
        return null;
    }

    @Override
    public void borrar(int id) {

    }
}
