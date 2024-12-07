public class KarakterGUI extends JLabel implements ActionListener {
    public KarakterGUI(
            int startX, int startY,
            int delay, String gambar)
    {
        setIcon(new ImageIcon(gambar));
        setSize(40, 40);
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }


   
    public void actionPerformed(ActionEvent actionEvent) {
        //  Determine next X position
        int nextX =((Main.player.getCPosition().getAbsis()+1)*50 + 5);

        int nextY =(12-(Main.player.getCPosition().getOrdinat()+1))*50 + 5;
        setLocation(nextX, nextY);
    }


}
