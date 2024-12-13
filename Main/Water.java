package Main;

import java.util.Random;
import java.util.Vector;

public class Water extends Field {

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

