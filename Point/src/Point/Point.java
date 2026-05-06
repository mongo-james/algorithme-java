package Point;

public class Point {
private float x;
private float y;
public  Point(float a, float b) {
	this.x=a;
	this.y=b;
}

public Point(float a) {
	this(a, a);
}

public float getX() {return this.x ;}
public float getY() {return this.y ;}
public void setX(float a) {this.x=a ;}
public void setY(float b) {this.y=b ;}

public String toString() {
	return "(" + this.x + ","+ this.y +")" ;
}
	public void presenteToi() {
		System.out.println(this);
	}
	// distance entre deux point 
	public float distance (Point p) {
		return (float) Math.sqrt(Math.pow(p.x - this.x,2) + Math.pow(p.y - this.y, 2));
	}
	public Point milieu (Point p) {
		float a;
		float b;
		a= (p.x+this.x)/2;
		b=(p.y+this.y)/2;
		Point M = new Point (a,b);
		return (Point) M;
	}
	public static Point milieu (Point p1, Point p2) {
		float a;
		float b;
		a= (p1.x+p2.x)/2;
		b=(p1.y+p2.y)/2;
		Point M = new Point (a,b);
		return (Point) M;
	}
	public boolean equals (Point p) {
		return ((this.x==p.x && this.y==p.y));
	}
	public Object clone () {
		Point Pclone= new Point(this.x, this.y);
		return Pclone;
	}
public static void main(String[] args) {
float f=14;
Point p1= new Point(13,12);
Point p2;
p2=p1;
p1.setY(20);
p2.setX(19);
System.out.println(p1);
System.out.println(p2);
p1.getX();
System.out.println(p1.getX());
Point p3= new Point(120);
System.out.println(p3);
System.out.println(milieu(p3, p1));
System.out.println(p3.equals(p1));
Point p4 = (Point) p3.clone();
System.out.println(p4);
System.out.println(p3.distance(p1));
}
}


