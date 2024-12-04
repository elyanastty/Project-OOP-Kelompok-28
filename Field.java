package Field;

import Main.Main;
import java.util.Vector;

/**
 * Abstract class Field
 * Kelas ini merupakan child dari Thread
 */

public abstract class Field extends Thread {
    static protected boolean direction=true;
    protected final int fieldSize = 7;
    protected boolean rdirection;
    protected Vector<Boolean> item;
    private boolean run=true;

    /**
     * Konstruktor
     */
    public Field(){
        rdirection=direction;
        direction = !direction;
        item = new Vector<>(fieldSize);
	}

    /**
     * Method run
     * Override method run dari thread
     * Method ini menggerakan setiap class Water yang berada di 'Map'
     * dengan setiap log di dalamnya
     */
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

    /**
     * Method stopThread
     * mengubah boolean run menjadi false
     */
    public void stopThread() {
        this.run=false;
    }

    /**
     * Method getDirection
     * @return direction di Field ini
     */
    public boolean getDirection(){return rdirection;}

    /**
     * Method setDirection
     * @param _direction arah baru
     */
    public void setDirection(boolean _direction){ rdirection = _direction; }

    /**
     * Method getFieldSize
     * @return fieldSize
     */
	public int getFieldSize() { return fieldSize; }

    /**
     * Abstract method generateRandom
     */
    public abstract void generateRandom();

    /**
     * Method moveField
     * 'Memindahkan' Vector of Boolean dr indeks pertama ke indeks terakhir jika direction true
     * atau sebaliknya, dari indeks terakhir ke indeks pertama jika direction false
     */
    public void moveField(){
        if(rdirection) {
            boolean temp = item.remove(0);
            item.add(temp);
        } else {
            boolean temp = item.remove(this.getFieldSize()-1);
            item.add(0, temp);
        }
    }

    /**
     * Method isItem
     * @param index indeks item
     * @return true jika di index terdapat item
     */
    public boolean isItem(int index){
        return item.elementAt(index);
    }

    /**
     * Method setItem
     * @param index indeks yang akan diubah
     * @param _item boolean baru
     */
    public void setItem(int index, boolean _item) { item.setElementAt(_item, index);}
}

