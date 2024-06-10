import services.TarjetaService;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Configurar los parámetros de conexión
        String url = "jdbc:h2:~/tarjetas"; // URL de conexión a la base de datos H2
        String username = "sa"; // Nombre de usuario de la base de datos
        String password = ""; // Contraseña de la base de datos

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement drop = connection.createStatement();
            String sql1 = "DROP TABLE IF EXISTS tarjetas_credito";
            drop.executeUpdate(sql1);
            String sql2 = "DROP TABLE IF EXISTS tarjetas_debito";
            drop.executeUpdate(sql2);


            // Crear una declaración SQL
            Statement statement = connection.createStatement();

            // Crear la tabla
            String createTableQuery1 = "CREATE TABLE IF NOT EXISTS tarjetas_credito (id INT PRIMARY KEY auto_increment, numero INT, titular VARCHAR(50))";
            statement.executeUpdate(createTableQuery1);

            // Insertar registros
            String insertQuery1 = "INSERT INTO tarjetas_credito (numero, titular) VALUES (123, 'John Doe'), (333, 'Jane Smith'), (321, 'Pedro Picapiedra')";
            statement.executeUpdate(insertQuery1);

            String createTableQuery2 = "CREATE TABLE IF NOT EXISTS tarjetas_debito (id INT PRIMARY KEY auto_increment, numero INT, titular VARCHAR(50))";
            statement.executeUpdate(createTableQuery2);

            String insertQuery2 = "INSERT INTO tarjetas_debito (numero, titular) VALUES (111, 'Pablo Picasso'), (222, 'Cacho Castaña'), (32323, 'Hermenegilo Cesna')";
            statement.executeUpdate(insertQuery2);


            TarjetaService service = new TarjetaService(connection);

            service.getTarjetasCredito();
            service.getTarjetasDebito();
            service.getTarjetaDebito(2);
            service.getTarjetaCredito(3);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}