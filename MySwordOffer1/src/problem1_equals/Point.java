package problem1_equals;

public class Point {
	private int x;
	private int y;
	
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	@Override 
	public boolean equals(Object obj){
		if(!(obj instanceof Point)){
			return false;
		}
		Point p = (Point) obj;
		return p.x==this.x && p.y==this.y;
	}

}
