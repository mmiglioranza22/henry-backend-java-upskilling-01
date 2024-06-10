package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConfiguration {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/GastosDB";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public static Connection getDBConnection() {
        Connection conn = null;
        try {
            //  https://stackoverflow.com/questions/39116196/why-need-for-using-jdbc-write-class-forname-for-each-connection
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void init(Connection conn) {
        try {
            System.out.println("Conectado a base de datos. Inicializando...");
//            Debug
            Statement drop = conn.createStatement();
            String dropGastos = "DROP TABLE IF EXISTS gastos";
            drop.executeUpdate(dropGastos);
            String dropCategoria = "DROP TABLE IF EXISTS categorias";
            drop.executeUpdate(dropCategoria);

            drop.close();

            // Crear una declaración SQL
            Statement statement = conn.createStatement();

            String crearTablaCategoria = "CREATE TABLE IF NOT EXISTS categorias (id INT PRIMARY KEY auto_increment, categoria VARCHAR(50))";
            statement.executeUpdate(crearTablaCategoria);
            //La columna que contiene la foreign key tiene que estar declarada ANTES de hacerla FK
            String crearTablaGastos = "CREATE TABLE IF NOT EXISTS gastos " +
                    "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "monto INT, " +
                    "fecha DATE, " +
                    "es_recurrente BOOLEAN, " +
                    "saldado BOOLEAN, " +
                    "fecha_saldado DATE, " +
                    "created_at timestamp DEFAULT CURRENT_TIMESTAMP, " +
                    "updated_at timestamp DEFAULT CURRENT_TIMESTAMP, " +
                    "soft_delete BOOLEAN, " +
                    "deleted_at timestamp, " +
                    "categoria_id INT, " +
                    "FOREIGN KEY (categoria_id) REFERENCES categorias(id))";
            statement.executeUpdate(crearTablaGastos);
            statement.close();

            System.out.println("Tablas creadas correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
