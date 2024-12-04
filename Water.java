package Field;

import java.util.Random;
import java.util.Vector;

/**
 * class Water
 * merupakan child dari Field, class ini adalah class yg bergerak
 * dan memiliki antara water sendiri jika nilai vector di indeks
 * tersebut false, atau log jika nilai vector di indeks tersebut true
 */
public class Water extends Field {
    /**
     * Konstruktor
     */
    public Water(){
		super();
        item = new Vector<>(fieldSize);
        for(int i=0; i<fieldSize; i++){
            item.add(false);
        }
        this.generateRandom();
	}

    /**
     * Method generateRandom
     * Set vector of boolean di indeks random dengan true (berarti ada Log)
     */
    public void generateRandom(){
        Random random = new Random();
        int numOfTrees = random.nextInt(fieldSize/2) + 2;
        while(numOfTrees!=0){
            int randomPosition = random.nextInt(fieldSize);
            if(!isItem(randomPosition)){
                this.setItem(randomPosition, true);
                numOfTrees--;
            }
        }
    }
}

