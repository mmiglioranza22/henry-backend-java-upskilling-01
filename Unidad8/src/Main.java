import config.JDBCConfiguration;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        try {
            Connection db = JDBCConfiguration.getDBConnection();

//            Statement drop = db.createStatement();
//            String sql = "DROP TABLE empleados";
//            drop.executeUpdate(sql);

            // Crear una declaración SQL
            Statement statement = db.createStatement();
            // Crear la tabla
            String createTableQuery = "CREATE TABLE IF NOT EXISTS empleados " +
                    "(id INT PRIMARY KEY auto_increment," +
                    " nombre VARCHAR(50)," +
                    " salario NUMERIC)";
            statement.executeUpdate(createTableQuery);


            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}