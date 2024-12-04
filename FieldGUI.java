package GUI;

import java.awt.event.*;
import javax.swing.*;
import Main.Main;

/**
 * class FieldGUI
 * merupakan child dari JLabel dan mengimplementasi interface ActionListener
 * class ini mengatur Graphics untuk menampilkan kelas Field di JFrame
 * menggunakan Java Swing
 */

public class FieldGUI extends JLabel implements ActionListener
{
    private int i,j;

    /**
     * Konstruktor
     * @param startX kondisi awal x
     * @param startY kondisi awal y
     * @param delay selang waktu pemrosesan
     * @param gambar string yang menunjukkan path file gambar
     * @param x indeks untuk Field di Vector of Field
     * @param y indeks untuk item di Vector of Boolean
     */
    public FieldGUI(
            int startX, int startY,
            int delay, String gambar, int x, int y)
    {
        this.i=x;
        this.j=y;
        setIcon( new ImageIcon(gambar) );
        setSize(50, 50);
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }

    /**
     * Method actionPerformed
     * Merupakan method implementasi dari kelas ActionListener
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent)
    {
        if (Main.vector.elementAt(i).getClass().getSimpleName().equals("Water")) {
            if (Main.vector.elementAt(i).isItem(j) && j>=0 && j<=6)
                setIcon(new ImageIcon("Log.jpg"));
            else
                setIcon(new ImageIcon("Water.jpg"));
        }
    }
}
