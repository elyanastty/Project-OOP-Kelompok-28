package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//  String url = "jdbc:mysql://localhost:3306/scoreGame";
//          String username = "root";
//          String password = "el123";

public class DatabaseConnector {

    private static Connection connection;

    public static void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/scoreGame";
            String username = "root";
            String password = "el123";

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal membuka koneksi ke database.");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Koneksi ditutup.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveScore(String playerName, int score) {
        try {
            String query = "INSERT INTO scores (player_name, score) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, playerName);
            stmt.setInt(2, score);
            stmt.executeUpdate();
            System.out.println("Skor berhasil disimpan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
