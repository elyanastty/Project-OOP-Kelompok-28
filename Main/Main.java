package Main;

import javax.swing.*;
import java.util.Random;
import java.util.Vector;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static Karakter player;
    public static Vector<Field> vector;
    public static JFrame frame;
    public static int score = 0;
    public static InputHandler movekey = new InputHandler();

    public static class InputHandler extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            CommandProcessor action = new CommandProcessor();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    action.setCurrentCommand("MoveLeft");
                    action.run();
                    break;
                case KeyEvent.VK_RIGHT:
                    action.setCurrentCommand("MoveRight");
                    action.run();
                    break;
                case KeyEvent.VK_UP:
                    action.setCurrentCommand("MoveForward");
                    action.run();
                    break;
                case KeyEvent.VK_DOWN:
                    action.setCurrentCommand("MoveBackward");
                    action.run();
                    break;
            }
            if (Main.vector.elementAt(0).getClass().getSimpleName().equals("Ground")) {
                if (Main.vector.elementAt(0).isItem(Main.player.getCPosition().getAbsis())) {
                    Main.player.setStatus(false);
                    showGameOver();
                }
            } else if (!Main.vector.elementAt(0).isItem(Main.player.getCPosition().getAbsis())) {
                Main.player.setStatus(false);
                showGameOver();
            }
        }
    }

    public static void moveMap() {
        JPanel panel = new JPanel();
        panel.add(new KarakterGUI((Main.player.getCPosition().getAbsis() + 1) * 50 + 10, 13 * 50 + 10, 10, "Doge.jpg"));
        panel.add(new ScoreGUI(10));

        panel.setLayout(null);
        for (int i = 0; i < 12; i++) {
            if (Main.vector.elementAt(i).getClass().getSimpleName().equals("Water")) {
                for (int j = 0; j < Main.vector.elementAt(i).getFieldSize(); j++) {
                    if (Main.vector.elementAt(i).isItem(j)) {
                        panel.add(new FieldGUI((j + 1) * 50, (12 - (i + 1)) * 50, 10, "Log.jpg", i, j));
                    } else {
                        panel.add(new FieldGUI((j + 1) * 50, (12 - (i + 1)) * 50, 10, "Water.jpg", i, j));
                    }
                }
            } else {
                for (int j = 0; j < Main.vector.elementAt(i).getFieldSize(); j++) {
                    if (Main.vector.elementAt(i).isItem(j))
                        panel.add(new FieldGUI((j + 1) * 50, (12 - (i + 1)) * 50, 10, "Tree.jpg", i, j));
                    else
                        panel.add(new FieldGUI((j + 1) * 50, (12 - (i + 1)) * 50, 10, "Ground.jpg", i, j));
                }
            }
        }

        Main.frame.setContentPane(panel);
        Main.frame.setVisible(true);
    }

    public static void saveScoreToDatabase(String playerName, int score) {
        DatabaseConnector dbConnector = new DatabaseConnector();
        dbConnector.connect();

        try {
            String query = "INSERT INTO scores (player_name, score) VALUES (?, ?)";
            PreparedStatement stmt = dbConnector.getConnection().prepareStatement(query);
            stmt.setString(1, playerName);
            stmt.setInt(2, score);
            stmt.executeUpdate();
            System.out.println("Skor berhasil disimpan!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnector.disconnect();
        }
    }

    public static void showWelcomeScreen() {
        JFrame welcomeFrame = new JFrame("TangleTrek - game lucu");
        welcomeFrame.setSize(450, 700);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setResizable(false);
        welcomeFrame.setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        welcomeFrame.setContentPane(layeredPane);

        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("welcome.jpg");
        Image originalImage = imageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(450, 700, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(0, 0, 450, 700);
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        JPanel overlayPanel = new JPanel();
        overlayPanel.setOpaque(false);
        overlayPanel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("TangleTrek", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 36));
        titleLabel.setForeground(new Color(0, 50, 0));



        JLabel subtitleLabel = new JLabel("Petualangan Hebat dan Melelahkan", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        subtitleLabel.setForeground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 0, 10, 0);
        overlayPanel.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 20, 0);
        overlayPanel.add(subtitleLabel, gbc);

        JButton startButton = new JButton("Mulai");
        startButton.setFont(new Font("Verdana", Font.BOLD, 20));
        startButton.setBackground(new Color(34, 139, 34));
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(150, 50));
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setBackground(new Color(0, 128, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setBackground(new Color(34, 139, 34));
            }
        });

        startButton.addActionListener(e -> {
            welcomeFrame.dispose();

            String playerName = JOptionPane.showInputDialog("Masukkan Nama Pemain:");
            if (playerName == null || playerName.trim().isEmpty()) {
                playerName = "Pemain";
            }

            player = new Karakter(playerName);
            newGame();
        });

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 20, 0);
        overlayPanel.add(startButton, gbc);

        DatabaseConnector dbConnector = new DatabaseConnector();
        dbConnector.connect();
        Vector<String> leaderboard = getLeaderboard(dbConnector.getConnection());
        dbConnector.disconnect();

        JLabel leaderboardTitle = new JLabel("Leaderboard", SwingConstants.CENTER);
        leaderboardTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        leaderboardTitle.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(20, 0, 10, 0);
        overlayPanel.add(leaderboardTitle, gbc);

        JPanel leaderboardPanel = new JPanel();
        leaderboardPanel.setLayout(new BoxLayout(leaderboardPanel, BoxLayout.Y_AXIS));
        leaderboardPanel.setOpaque(false);

        for (int idx = 0; idx < leaderboard.size(); idx++) {
            final int i = idx;
            String entry = leaderboard.get(i);

            JPanel entryPanel = new JPanel();
            entryPanel.setLayout(new BorderLayout());
            entryPanel.setBackground(i % 2 == 0 ? new Color(210, 180, 140) : new Color(222, 184, 135));
            entryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel trophyLabel = new JLabel();
            String trophyImagePath = "";

            if (i == 0) {
                trophyImagePath = "j1.jpg";
            } else if (i == 1) {
                trophyImagePath = "j2.jpg";
            } else  {
                trophyImagePath = "j3.jpg";
            }

            ImageIcon trophyIcon = new ImageIcon(trophyImagePath);
            Image scaledTrophy = trophyIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            trophyLabel.setIcon(new ImageIcon(scaledTrophy));

            JLabel entryLabel = new JLabel((i + 1) + ". " + entry, SwingConstants.LEFT);
            entryLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
            entryLabel.setForeground(Color.DARK_GRAY);

            entryPanel.add(trophyLabel, BorderLayout.WEST);
            entryPanel.add(entryLabel, BorderLayout.CENTER);

            entryPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    entryPanel.setBackground(new Color(240, 248, 230));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    entryPanel.setBackground(i % 2 == 0 ? new Color(210, 180, 140) : new Color(222, 184, 135));
                }
            });

            leaderboardPanel.add(entryPanel);
        }

        JScrollPane scrollPane = new JScrollPane(leaderboardPanel);
        scrollPane.setPreferredSize(new Dimension(300, 150));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 0, 10, 0);
        overlayPanel.add(scrollPane, gbc);

        overlayPanel.setBounds(0, 0, 450, 700);
        layeredPane.add(overlayPanel, JLayeredPane.PALETTE_LAYER);

        welcomeFrame.setVisible(true);
    }

    public static void newGame() {
        JPanel panel = new JPanel();
        Main.frame.addKeyListener(Main.movekey);
        Main.frame.setContentPane(panel);
        Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.frame.getContentPane().setLayout(null);
        Main.frame.getContentPane().add(new KarakterGUI(610, 13 * 50 + 10, 10, "Doge.jpg"));
        Main.frame.getContentPane().add(new ScoreGUI(10));

        Random random = new Random();
        Point playerPosition = new Point(3, 0);
        player.setCPosition(playerPosition);

        for (int i = 0; i < 12; i++) {
            int GroundWater = random.nextInt(2) + 1;
            if (GroundWater == 2 && i != 0) {
                Water water = new Water();
                Main.vector.add(water);
                Main.vector.elementAt(i).start();
                for (int j = 0; j < water.getFieldSize(); j++) {
                    if (water.isItem(j)) {
                        panel.add(new FieldGUI((j + 1) * 50, (12 - (i + 1)) * 50, 10, "Log.jpg", i, j));
                    } else {
                        panel.add(new FieldGUI((j + 1) * 50, (12 - (i + 1)) * 50, 10, "Water.jpg", i, j));
                    }
                }
            } else {
                Ground ground = new Ground();
                if (i == 0) {
                    for (int k = 0; k < ground.getFieldSize(); k++) {
                        ground.setItem(k, false);
                    }
                }
                Main.vector.add(ground);
                for (int j = 0; j < ground.getFieldSize(); j++) {
                    if (ground.isItem(j))
                        panel.add(new FieldGUI((j + 1) * 50, (12 - (i + 1)) * 50, 10, "Tree.jpg", i, j));
                    else
                        panel.add(new FieldGUI((j + 1) * 50, (12 - (i + 1)) * 50, 10, "Ground.jpg", i, j));
                }
            }
        }

        Main.frame.setSize(450, 700);
        Main.frame.setResizable(false);
        Main.frame.setLocationRelativeTo(null);
        Main.frame.setVisible(true);
    }

    public static Vector<String> getLeaderboard(Connection connection) {
        Vector<String> leaderboard = new Vector<>();
        try {
            String query = "SELECT player_name, MAX(score) AS highest_score FROM scores GROUP BY player_name ORDER BY highest_score DESC LIMIT 3";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String playerName = rs.getString("player_name");
                int score = rs.getInt("highest_score");
                leaderboard.add(playerName + "'s score: " + score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaderboard;
    }

    public static void showGameOver() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("GAME OVER!!!");
        label.setSize(200, 200);
        label.setLocation(200, 530);
        frame.getContentPane().add(label);
        frame.setVisible(true);

        Main.frame.removeKeyListener(movekey);

        DatabaseConnector dbConnector = new DatabaseConnector();
        dbConnector.connect();

        dbConnector.saveScore(Main.player.getName(), Main.score);

        dbConnector.disconnect();

        Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.frame.getContentPane().setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showWelcomeScreen);
        vector = new Vector<>();
        frame = new JFrame();
    }
}
