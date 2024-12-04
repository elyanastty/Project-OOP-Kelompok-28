package Main;

import java.awt.event.KeyEvent;

public class MoveBackward implements Command {

    public MoveBackward(){

    }

    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_DOWN);
    }
}
