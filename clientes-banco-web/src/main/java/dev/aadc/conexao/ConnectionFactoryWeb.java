package dev.aadc.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryWeb {

    public static Connection connection() {

        String driver = "com.mysql.cj.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/clientesbanco";
        String username = "root";
        String password = "root";

        try {
            Class.forName(driver); // O método Class.forName("com.mysql.cj.jdbc.Driver") registra o driver MySQL no DriverManager do Java.
            // Uma vez registrado, o DriverManager sabe qual driver usar para estabelecer uma conexao com o banco de dados!

            return DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
