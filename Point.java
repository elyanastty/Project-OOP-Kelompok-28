package Point;


public class Point {
	private int x;
	private int y;

	
	public Point(){
		x = 0;
		y = 0;
	}


	public Point(int _x, int _y){
		x = _x;
		y = _y;
	}

	
	  
	 
	public Point(final Point P){
		x = P.x;
		y = P.y;
	}

	
	 
	 
	public int getAbsis(){
		return x;
	}

	
	  
	 
	public int getOrdinat(){
		return y;
	}

	
	  
	 
	public void setAbsis(int _x){
		this.x = _x;
	}

	
	 
	  
	 
	public void setOrdinat(int _y){
		this.y = _y;
	}

	
	  
	public void setPoint(int _x, int _y){
		this.setAbsis(_x);
		this.setOrdinat(_y);
	}

	
	  
	 
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
}

