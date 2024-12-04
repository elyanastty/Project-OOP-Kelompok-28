package Field;

import Main.Main;
import java.util.Vector;

public abstract class Field extends Thread {
    static protected boolean direction=true;
    protected final int fieldSize = 7;
    protected boolean rdirection;
    protected Vector<Boolean> item;
    private boolean run=true;

    public Field(){
        rdirection=direction;
        direction = !direction;
        item = new Vector<>(fieldSize);
	}

    public void run() {
        while (run && Main.player.getStatus()) {
            try {
                this.moveField();
                if (Main.vector.elementAt(0).getClass().getSimpleName().equals("Water")
                        && this == Main.vector.elementAt(0)) {
                    if (!Main.vector.elementAt(0).getDirection()) {
                        int x = Main.player.getCPosition().getAbsis() + 1;
                        if (x > 6)
                            x = 0;
                        Main.player.setCPosition(x, Main.player.getCPosition().getOrdinat());
                    } else {
                        int x = Main.player.getCPosition().getAbsis() - 1;
                        if (x < 0)
                            x = 6;
                        Main.player.setCPosition(x, Main.player.getCPosition().getOrdinat());
                    }
                }
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e){

            }
        }
    }

    public void stopThread() {
        this.run=false;
    }

    public boolean getDirection(){return rdirection;}

    public void setDirection(boolean _direction){ rdirection = _direction; }

	public int getFieldSize() { return fieldSize; }

    public abstract void generateRandom();

    public void moveField(){
        if(rdirection) {
            boolean temp = item.remove(0);
            item.add(temp);
        } else {
            boolean temp = item.remove(this.getFieldSize()-1);
            item.add(0, temp);
        }
    }

    public boolean isItem(int index){
        return item.elementAt(index);
    }

    public void setItem(int index, boolean _item) { item.setElementAt(_item, index);}
}
