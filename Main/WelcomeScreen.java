//package Main;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class WelcomeScreen extends JPanel {
//    private Runnable onStartGame;
//
//    // Konstruktor menerima aksi callback
//    public WelcomeScreen(Runnable onStartGame) {
//        this.onStartGame = onStartGame;
//
//        // Desain UI layar pembuka
//        setLayout(new BorderLayout());
//        JLabel welcomeLabel = new JLabel("Selamat Datang di Crossy Log!", SwingConstants.CENTER);
//        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
//        add(welcomeLabel, BorderLayout.CENTER);
//
//        JButton startButton = new JButton("Mulai Permainan");
//        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (onStartGame != null) {
//                    onStartGame.run(); // Jalankan aksi callback
//                }
//            }
//        });
//        add(startButton, BorderLayout.SOUTH);
//    }
//}
