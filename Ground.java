package Field;

import java.util.Random;

public class Ground extends Field{
    public Ground(){
		super();
        for(int i=0; i<fieldSize; i++){
            item.add(false);
        }
        this.generateRandom();
	}

    public Ground(final Ground G){
        super();
        for(int i=0; i<G.fieldSize; i++){
            item.add(G.isItem(i));
        }
    }

    public void generateRandom(){
        Random random = new Random();
        int numOfItems = random.nextInt(fieldSize/2) + 1;
        while(numOfItems!=0){
            int randomPosition = random.nextInt(fieldSize);
            if(!isItem(randomPosition)){
                this.setItem(randomPosition, true);
                numOfItems--;
            }
        }
    }
}
