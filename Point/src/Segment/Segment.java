package Segment;

import Point.Point;
public class Segment {
	private Point p1;
	private Point p2;
	
	public Segment () {
		this.p1= new Point (0,0);
		this.p2= new Point (0,0);
	}
	
	public Segment (float x1, float x2, float y1, float y2) {
		this.p1 =new Point (x1, y1);
		this.p2= new Point (x2, y2);
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(float x1, float y1) {
		this.p1.setX(x1);
		this.p2.setY(y1);
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(float x2, float y2) {
		this.p1.setX(x2);
		this.p2.setY(y2);
	}
	
	public String Tostring () {
		return "("+ this.p1.toString() +"," + this.p2.toString()+")";
	}
	
	
}
