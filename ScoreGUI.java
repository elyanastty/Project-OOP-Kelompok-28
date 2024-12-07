public class ScoreGUI extends JLabel implements ActionListener {
  
    public ScoreGUI(int delay){
        setText(("score: " + Main.score));
        setSize(100, 50);
        setLocation(0,600);
        new javax.swing.Timer(delay, this).start();
    }
  
    public void actionPerformed(ActionEvent actionEvent) {
        setText(("score: "+Main.score));
    }
}
