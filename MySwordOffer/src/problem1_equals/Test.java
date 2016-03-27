package q1_equals;

import java.awt.Color;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(5, 6);
		ColorPoint cp= new ColorPoint(5, 6, Color.BLUE);
		p.equals(cp);
		cp.equals(p);
	}

}
