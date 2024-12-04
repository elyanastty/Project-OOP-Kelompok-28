package Main;


import java.awt.event.KeyEvent;
import java.util.Random;


public class Karakter {
	private String Name;
	private Point cPosition;
	private int cDirection;
	private boolean alive;
	private final int fieldSize = 7;

	public Karakter(){
		Name = "Doge";
		cPosition = new Point();
		cDirection = 0;
		alive = true;
	}

	public Karakter(String _Name){
		Name = _Name;
		cPosition = new Point();
		alive = true;
	}

	public Karakter(final Karakter K){
		Name = K.Name;
		cPosition = new Point(K.cPosition);
		alive = K.alive;
	}

	public void setKarakter(Karakter _player){
		this.setName(_player.getName());
		this.setStatus(_player.getStatus());
		this.setCPosition(_player.getCPosition());
	}

	public String getName(){
		return Name;
	}

	public void setName(String _Name){
		Name = _Name;
	}

	public Point getCPosition(){
		return cPosition;
	}

	public int getCDirection() {
		return cDirection;
	}

	public boolean getStatus(){
		return alive;
	}

	public void setCPosition(Point P){
		cPosition.setAbsis(P.getAbsis());
		cPosition.setOrdinat(P.getOrdinat());
	}

	public void setCPosition(int x, int y){
		cPosition.setAbsis(x);
		cPosition.setOrdinat(y);
	}

	public void setCDirection(int _direct){
		cDirection = _direct;
	}

	public void setStatus(boolean _alive){
		alive = _alive;
	}

	public void printKarakter(){
		System.out.println(getName());
		System.out.println(getCPosition());
		System.out.println(getCDirection());
		System.out.println(getStatus());
	}

}
