public class FieldGUI extends JLabel implements ActionListener
{
    private int i,j;

   
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
