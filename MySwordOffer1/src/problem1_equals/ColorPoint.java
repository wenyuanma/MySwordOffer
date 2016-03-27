package problem1_equals;

import java.awt.Color;

public class ColorPoint extends Point {
	private Color color;
	public ColorPoint(int x, int y,Color c) {
		super(x, y);
		this.color = c;

	}
	
    @Override
    public boolean equals(Object obj){
    	if(!(obj instanceof ColorPoint)){
    		System.err.println("color not instance");
    		return false;
    	}
    	ColorPoint cp = (ColorPoint)obj;
    	return super.equals(obj)&& cp.color==this.color;
    }

}
