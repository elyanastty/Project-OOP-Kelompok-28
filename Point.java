package Point;


public class Point {
	private int x;
	private int y;

	
	public Point(){
		x = 0;
		y = 0;
	}

	
	  @param _x absis
	  @param _y ordinat
	 
	public Point(int _x, int _y){
		x = _x;
		y = _y;
	}

	
	  @param P 
	 
	public Point(final Point P){
		x = P.x;
		y = P.y;
	}

	
	 * @return 
	 
	public int getAbsis(){
		return x;
	}

	
	  @return 
	 
	public int getOrdinat(){
		return y;
	}

	
	  @param _x 
	 
	public void setAbsis(int _x){
		this.x = _x;
	}

	
	 
	  @param _y 
	 
	public void setOrdinat(int _y){
		this.y = _y;
	}

	
	  @param _x 
	  @param _y 
	 
	public void setPoint(int _x, int _y){
		this.setAbsis(_x);
		this.setOrdinat(_y);
	}

	
	  @return 
	 
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
}

