package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {
    private static final String dataBaseUrl = "jdbc:mysql://localhost:3306/newDataBase";
    private static final String userIdToConnectDataBase = "root";
    private static final String userPasswordToConnectDatabase = "mySQL321!";
    private static Connection INSTANCE;

    private ConnexionManager() {
    } // empeche l'instantiation de la classe

    public static Connection getINSTANCE() {
        if (INSTANCE == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // activer le connector
                INSTANCE = DriverManager.getConnection(dataBaseUrl, userIdToConnectDataBase, userPasswordToConnectDatabase);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return INSTANCE;
    }

    // throws : propage l'exception SQLException
    // (SQLException fournit des informations sur une erreur d'accès à la base de données ou d'autres erreurs)
    public static void closeConnection() throws SQLException {
        if (INSTANCE == null && !INSTANCE.isClosed()) {
            INSTANCE.close();
        }
    }

}
