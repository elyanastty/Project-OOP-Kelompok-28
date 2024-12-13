//package Main;
//
//import javax.swing.*;
//import java.awt.*;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class ScoreBoard extends JFrame {
//
//    public ScoreBoard() {
//        setTitle("Score Board");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Panel Utama
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//
//        // Label Judul
//        JLabel titleLabel = new JLabel("Score Board", JLabel.CENTER);
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
//        panel.add(titleLabel, BorderLayout.NORTH);
//
//        // Area Tabel untuk Menampilkan Skor
//        JTextArea scoreArea = new JTextArea();
//        scoreArea.setEditable(false);
//        panel.add(new JScrollPane(scoreArea), BorderLayout.CENTER);
//
//        // Ambil Data dari Database
//        try {
//            Connection conn = DatabaseConnector.getConnection(); // Pastikan DatabaseConnector kamu siap
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM scores ORDER BY score DESC");
//
//            StringBuilder sb = new StringBuilder();
//            while (rs.next()) {
//                sb.append(rs.getString("name")).append(": ").append(rs.getInt("score")).append("\n");
//            }
//            scoreArea.setText(sb.toString());
//
//        } catch (Exception e) {
//            scoreArea.setText("Gagal mengambil data skor!");
//            e.printStackTrace();
//        }
//
//        // Tambahkan Panel ke Frame
//        add(panel);
//
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//}
