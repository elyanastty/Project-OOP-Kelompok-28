package Main;

import Char.Karakter;
import Command.CommandProcessor;
import Field.*;
import GUI.FieldGUI;
import GUI.KarakterGUI;
import GUI.ScoreGUI;
import Point.Point;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

/** <h1> Crossy Log </h1>
 *  @author Yoga Adrian / 13513030
 *  @author Levanji Prahyudy Mudjono / 13513052
 *  @author Octavianus Marcel Harjono / 13513056
 *  @version 1.0
 */

/**
 * class Main
 * Kelas ini memrupakan kelas main utama dan mempunyai
 * atribut static Karakter, Vector of Field, dan JFrame
 */

public class Main {
    public static Karakter player;
    public static Vector<Field> vector;
    public static JFrame frame;
    public static int score=0;
    public static InputHandler movekey=new InputHandler();

    /**
     * class InputHandler yang merupakan child dari kelas KeyAdapter
     * class ini override keyReleased, maka jika suatu frame ditambahkan
     * keyListener dengan kelas ini, maka frame tersebut dapat berinteraksi
     * dengan user menggunakan keyboard
     */
    public static class InputHandler extends KeyAdapter {
        public void keyReleased(KeyEvent e){
            CommandProcessor action = new CommandProcessor();
            switch(e.getKeyCode()){
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
            //Karakter akan mati jika menyentuh hanya Water tanpa Item, atau
            //Ground dengan Item
            if (Main.vector.elementAt(0).getClass().getSimpleName().equals("Ground")){
                if (Main.vector.elementAt(0).isItem(Main.player.getCPosition().getAbsis())){
                    Main.player.setStatus(false);
                    showGameOver();
                }
            } else if (!Main.vector.elementAt(0).isItem(Main.player.getCPosition().getAbsis())){
                Main.player.setStatus(false);
                showGameOver();
            }
        }
    }

    /**
     * Static method moveMap
     * Method ini membuat panel baru dengan kondisi seluruh Vector of Field
     * sudah 'bergeser' lalu melakukan set panel ke frame di kelas Main
     */
    public static void moveMap(){
        JPanel panel = new JPanel();
        panel.add(new KarakterGUI((Main.player.getCPosition().getAbsis() + 1) * 50 + 10, 13 * 50 + 10, 10, "Doge.jpg"));
        panel.add(new ScoreGUI(10));

        panel.setLayout(null);
        for (int i = 0; i < 12; i++) {
            if (Main.vector.elementAt(i).getClass().getSimpleName().equals("Water")) {
                for (int j=0;j <Main.vector.elementAt(i).getFieldSize();j++) {
                    if (Main.vector.elementAt(i).isItem(j)) {
                        if (Main.vector.elementAt(i).getDirection())
                            panel.add( new FieldGUI((j+1)*50, (12-(i+1))*50, 10,"Log.jpg",i,j) );
                        else
                            panel.add( new FieldGUI((j+1)*50, (12-(i+1))*50, 10,"Log.jpg",i,j) );
                    } else {
                        if(Main.vector.elementAt(i).getDirection())
                            panel.add( new FieldGUI((j+1)*50, (12-(i+1))*50, 10,"Water.jpg",i,j) );
                        else
                            panel.add( new FieldGUI((j+1)*50, (12-(i+1))*50, 10,"Water.jpg",i,j) );
                    }
                }
            }
            else {
                for (int j=0;j <Main.vector.elementAt(i).getFieldSize();j++) {
                    if (Main.vector.elementAt(i).isItem(j))
                        panel.add( new FieldGUI((j+1)*50, (12-(i+1))*50, 10,"Tree.jpg",i,j) );
                    else
                        panel.add( new FieldGUI((j+1)*50, (12-(i+1))*50, 10,"Ground.jpg",i,j) );
                }
            }
        }

        Main.frame.setContentPane(panel);
        Main.frame.setVisible(true);
    }

    /**
     * Static method newGame
     * Menginisialisasi frame dan vector static dari kelas Main
     * dengan Field random dan jumlah log/tree random (random tertentu)
     */
    public static void newGame(){
        JPanel panel = new JPanel();
        Main.frame.addKeyListener(Main.movekey);
        Main.frame.setContentPane(panel);
        Main.frame.setDefaultCloseOperation(Main.frame.EXIT_ON_CLOSE);
        Main.frame.getContentPane().setLayout(null);
        Main.frame.getContentPane().add(new KarakterGUI(610, 13 * 50 + 10, 10, "Doge.jpg"));
        Main.frame.getContentPane().add(new ScoreGUI(10));

        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            int GroundWater = random.nextInt(2) + 1;
            if (GroundWater == 2 && i != 0) {
                Water water = new Water();
                Main.vector.add(water);
                Main.vector.elementAt(i).start();
                for (int j=0;j <water.getFieldSize();j++) {
                    if (water.isItem(j)) {
                        if (water.getDirection())
                            Main.frame.getContentPane().add(new FieldGUI((j+1)*50, (12-(i+1))*50, 10, "Log.jpg", i, j));
                        else
                            Main.frame.getContentPane().add(new FieldGUI((j+1)*50, (12-(i+1))*50, 10, "Log.jpg", i, j));
                    } else {
                        if(water.getDirection())
                            Main.frame.getContentPane().add(new FieldGUI((j+1)*50, (12-(i+1))*50, 10, "Water.jpg", i, j));
                        else
                            Main.frame.getContentPane().add(new FieldGUI((j+1)*50, (12-(i+1))*50, 10, "Water.jpg", i, j));
                    }
                }
            }
            else {
                Ground ground = new Ground();
                if(i == 0){
                    for(int k=0; k<ground.getFieldSize(); k++){
                        ground.setItem(k, false);
                    }
                }
                Main.vector.add(ground);
                for (int j=0;j <ground.getFieldSize();j++) {
                    if (ground.isItem(j))
                        Main.frame.getContentPane().add(new FieldGUI((j+1)*50, (12-(i+1))*50, 10, "Tree.jpg", i, j));
                    else
                        Main.frame.getContentPane().add(new FieldGUI((j+1)*50, (12-(i+1))*50, 10, "Ground.jpg", i, j));
                }
            }
        }

        Main.frame.setSize(450, 700);
        Main.frame.setResizable(false);
        Main.frame.setLocationRelativeTo(null);
        Main.frame.setVisible(true);



    }

    /**
     * Static method showGameOver
     * Menampilkan GameOver ke layar kemudian menginvoke newGame jika player
     * memilih untuk bermain ulang, dan keluar jika player tidak ingin
     */
    public static void showGameOver(){
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setText("GAME OVER!!!");
        label.setSize(200,200);
        label.setLocation(200,530);
        frame.getContentPane().add(label);
        frame.setVisible(true);

        Main.frame.removeKeyListener(movekey);

        Main.frame.setDefaultCloseOperation(Main.frame.EXIT_ON_CLOSE);
        Main.frame.getContentPane().setLayout(null);
    }


    public static void main(String[] args){

        player = new Karakter("Doge");
        Point playerPosition = new Point(3,0);
        player.setCPosition(playerPosition);
        vector = new Vector<>();
        frame = new JFrame();
     newGame();
        boolean life=true;

    }
}
