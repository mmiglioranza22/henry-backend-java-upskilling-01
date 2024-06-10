package impl;

import dao.TarjetaDebitoDAO;
import dto.TarjetaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDebitoDAOImpl implements TarjetaDebitoDAO {
    Connection connection;
    public final String SELECT_ALL = "SELECT * FROM tarjetas_debito";
    public final String SELECT_ONE = "SELECT * FROM tarjetas_debito WHERE id = ?";

    public TarjetaDebitoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<TarjetaDTO> getTarjetas() {
        List<TarjetaDTO> tarjetas = new ArrayList<>();

        try {
            // Crear un PreparedStatement a partir de la sentencia SQL
            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL);
            // Ejecutar la consulta y obtener el resultado en un ResultSet
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los registros devueltos por el ResultSet
            while (rs.next()) {
                int registroId = rs.getInt("id");
                String titular = rs.getString("titular");
                int numero = rs.getInt("numero");
                TarjetaDTO tarjeta = new TarjetaDTO();
                tarjeta.setId(registroId);
                tarjeta.setTitular(titular);

                System.out.println("ID: " + registroId);
                System.out.println("Titular: " + titular);
                System.out.println("Numero: " + numero);
                System.out.println("--------------------------");
                tarjetas.add(tarjeta);
            }

            // Cerrar el ResultSet y el PreparedStatement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el registro: " + e.getMessage());
        }
        return tarjetas;

    }


    @Override
    public TarjetaDTO getTarjeta(Integer id) {

        TarjetaDTO tarjeta = new TarjetaDTO();

        try {
            // Crear un PreparedStatement a partir de la sentencia SQL
            PreparedStatement stmt = connection.prepareStatement(SELECT_ONE);

            // Establecer el valor del ID en el PreparedStatement
            stmt.setInt(1, id);

            // Ejecutar la consulta y obtener el resultado en un ResultSet
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los registros devueltos por el ResultSet
            while (rs.next()) {
                int registroId = rs.getInt("id");
                String titular = rs.getString("titular");
                int numero = rs.getInt("numero");

                tarjeta.setId(registroId);
                tarjeta.setTitular(titular);

                System.out.println("ID: " + registroId);
                System.out.println("Titular: " + titular);
                System.out.println("Numero: " + numero);
                System.out.println("--------------------------");
            }

            // Cerrar el ResultSet y el PreparedStatement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el registro: " + e.getMessage());
        }
        return tarjeta;
    }
}
