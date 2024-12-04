package Main;

import java.awt.event.KeyEvent;

public class MoveForward implements Command {

    public MoveForward() {
    }

    public void execute(){
        Main.player.keyReleased(KeyEvent.VK_UP);
    }
}
