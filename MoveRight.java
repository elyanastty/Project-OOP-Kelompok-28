package Main;

import java.awt.event.KeyEvent;

public class MoveRight implements Command{

    public MoveRight(){
    }

    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_RIGHT);
    }
}
