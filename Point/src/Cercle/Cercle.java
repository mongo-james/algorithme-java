package Cercle;

import Point.Point;

public class Cercle {
	public static final float PI=3.14f ; // Constante de classe
	private Point centre ;
	private static float rayon ;
	public Cercle(float x, float y, float ray) {
		this.centre=new Point(x,y);
		this.rayon=ray;
	}
	public Cercle(float x, float ray) {
		this.centre=new Point(x);
		this.rayon=ray;
	}
	public Cercle(Point center, float ray) {
		this.centre=center;
		this.rayon= ray;
	}
	float getRayon() { return this.rayon ;}
	Point getCentre() { return this.centre ;}
	void setRayon(float rayon) {this.rayon=rayon ;}
	void setCentre(Point centre) {this.centre=centre ;}
	void setCentre(float a, float b) {
		this.centre.setX(a);
		this.centre.setY(b);
	}
	public String toString() {
		return "[" +(this.centre).toString()+","+this.rayon+"]";
	}
	public float Perimetre () {
		return (this.rayon*PI*2);
	}
	public static float Perimetre(Cercle c) {
		return (2*c.rayon*PI);
	}
	public float Surface () {
		return (float) (Math.pow(rayon,2)*PI);
	}
	public static float Surface (Cercle c) {
		return (float) (Math.pow(c.rayon,2)*PI);
	}
	public boolean SurleCercle (Point p) {
		return (this.centre.distance(p)== rayon);
	}
	public boolean DansleCercle (Point p) {
		return (this.centre.distance(p)== rayon || this.centre.distance(p)<rayon);
	}
	public boolean equals (Cercle c) {
		return (this.centre == c.centre && this.rayon == c.rayon);
	}
	protected Object Clone () {
		Cercle c= new Cercle (this.centre, this.rayon);
		return c;
	}
	public static void main(String[] args) {
		Cercle c = new Cercle (10,3,5);
		Point p1= new Point(15,17);
		p1.setX(17);
		c.setCentre(p1);
		System.out.println(c);
		Cercle c2= new Cercle(p1, 25);
		System.out.println(c2);
		System.out.println(c.Perimetre());
		System.out.println(Perimetre(c));
		System.out.println(c.SurleCercle(p1));
	}
}
