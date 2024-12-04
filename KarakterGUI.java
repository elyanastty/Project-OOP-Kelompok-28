package GUI;

import Command.CommandProcessor;
import Field.*;
import Main.Main;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * class KarakterGUI
 * merupakan child dari JLabel dan mengimplementasi interface ActionListener
 * class ini mengatur Graphics untuk menampilkan Karakter di JFrame
 * menggunakan Java Swing
 */
public class KarakterGUI extends JLabel implements ActionListener {
    /**
     * Konstruktor KarakterGUI
     * @param startX kondisi awal x
     * @param startY kondisi awal y
     * @param delay selang waktu pemrosesan
     * @param gambar string yang menunjukkan path file gambar
     */
    public KarakterGUI(
            int startX, int startY,
            int delay, String gambar)
    {
        setIcon(new ImageIcon(gambar));
        setSize(40, 40);
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }


    /**
     *     public void actionPerformed(ActionEvent actionEvent)
     *     prosedur untuk mengatur hal hal didalam panel yang akan dirubah saat permainan berlangsung
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        //  Determine next X position
        int nextX =((Main.player.getCPosition().getAbsis()+1)*50 + 5);

        int nextY =(12-(Main.player.getCPosition().getOrdinat()+1))*50 + 5;
        setLocation(nextX, nextY);
    }


}
