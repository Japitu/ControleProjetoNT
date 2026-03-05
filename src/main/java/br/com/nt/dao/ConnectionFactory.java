package br.com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    public static void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {

            if (connection != null && !connection.isClosed()) {
                return connection;
            }

            Class.forName("org.postgresql.Driver");

            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            if (url == null || user == null || password == null) {
                throw new RuntimeException("Variáveis de ambiente do banco não configuradas!");
            }

            connection = DriverManager.getConnection(url, user, password);

            return connection;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL não encontrado", e);
        }
    }
}
