package Main;

import java.awt.event.KeyEvent;

public class MoveLeft implements Command {

    public MoveLeft(){

    }

    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_LEFT);
    }
}
