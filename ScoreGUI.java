package GUI;

import java.awt.event.*;
import javax.swing.*;

import Main.Main;

/**
 * class ScoreGUI
 * kelas ini berguna untuk menampilkan score selama permainan berlangsung
 */

public class ScoreGUI extends JLabel implements ActionListener {
    /**
     * Konstruktor
     * @param delay untuk selang waktu pemrosesan
     */
    public ScoreGUI(int delay){
        setText(("score: " + Main.score));
        setSize(100, 50);
        setLocation(0,600);
        new javax.swing.Timer(delay, this).start();
    }
    /**
     * Method actionPerformed
     * Method untuk mengatur hal-hal didalam panel yang akan dirubah saat permainan berlangsung
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        setText(("score: "+Main.score));
    }
}
