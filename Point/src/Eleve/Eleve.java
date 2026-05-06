package Eleve;

import Point.Point;
public class Eleve {
	private String nom;
	private float Note_M;
	private float Note_P;
	private float Note_F;
	private float Note_A;
	private int Matricule;
	
	public int NbreCreation=0;
	private static Eleve eleve1;
	
	/*public  Eleve (String Nom) {
		this.setNom(Nom.toUpperCase());
	}*/
	
	public Eleve (String Nom, float M, float P, float F, float A) {
		this.setNom(Nom.toUpperCase());
		this.setNote_M(M);
		this.setNote_P(P);
		this.setNote_F(F);
		this.setNote_A(A);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getNote_M() {
		return Note_M;
	}

	public void setNote_M(float note_M) {
		Note_M = note_M;
	}

	public float getNote_P() {
		return Note_P;
	}

	public void setNote_P(float note_P) {
		Note_P = note_P;
	}

	public float getNote_F() {
		return Note_F;
	}

	public void setNote_F(float note_F) {
		Note_F = note_F;
	}

	public float getNote_A() {
		return Note_A;
	}

	public void setNote_A(float note_A) {
		Note_A = note_A;
	}
	
	public String toString() {
		return "["+ this.nom + ",Math:" + Note_M + ",Phy:" + Note_P + ",fra:" + Note_F + ",ang:" + Note_A + "]";  
	}
	
	public float Moyenne () {
		return (this.Note_A + this.Note_F + this.Note_M + this.Note_P)/4;
	}

	public int getMatricule() {
		return Matricule;
	}
	
	public  void EleveM (String Nom) {
		this.setNom(Nom.toUpperCase());
		this.Matricule= NbreCreation;
		NbreCreation ++;
	}
	
	public void EleveM (String Nom, float M, float P, float F, float A) {
		this.setNom(Nom.toUpperCase());
		this.setNote_M(M);
		this.setNote_P(P);
		this.setNote_F(F);
		this.setNote_A(A);
		this.Matricule= NbreCreation;
		NbreCreation ++;
	}
	
	public boolean equals(Eleve e) {
		return (this.Matricule == e.Matricule);
	}
	
	protected Object Clone () {
		Eleve clone = new Eleve (this.nom, this.Note_M, this.Note_P, this.Note_F, this.Note_A);
		return clone;
	}
	
	public String Mention () {
		if (this.Moyenne()>=10 && this.Moyenne()<12) System.out.println("Passable");
		else if (this.Moyenne()>=12 && this.Moyenne()<14) System.out.println("Assez bien");
		else if (this.Moyenne()>=14 && this.Moyenne()<16) System.out.println("Bien");
		else if (this.Moyenne()>=16 && this.Moyenne()<18) System.out.println("Tres Bien");
		else if (this.Moyenne()>=18 && this.Moyenne()<=20) System.out.println("Excellent");
		else System.out.println("Mediocre");
		return nom;
	}
	
	public static float F (float x) {
		return (float) (x*x+2*x+1);
	}
	
	public static float G (float x) {
	    if (x < 4)
	        return x * x + 2 * x + 1;
	    else if (x >= 4 && x <= 40)
	        return x * x;
	    else if (x > 40)
	        return x + 1;
	    else
	        return 0;  
	}
	
	public static float h (Point p) {
		return (p.getX()*p.getX()+p.getY()*p.getY()+2*p.getX()*p.getY()+1);
	}
	
	public static float EquationPD (float a, float b) {
		if (a==b && b==0)
			System.out.println("Infinite de Solution");
		else if (a==b && b!=0)
			System.out.println("Il n'ya pas de solution");
		else if (a!=0) {
			System.out.println("Il ya exactement une solution qui est si dessous");
			return (float) (-b/a);
		}
			return 0;
	}
	
	public static void EquationSD (float a, float b, float c) {
		if (a==b && b==c && c==0)
			System.out.println("Infinite de Solution");
		else if (a==b && b==0 && c!=0)
			System.out.println("Il n'ya pas de solution");
		else if (a==0 && b!=0)
			System.out.println("Il y'a exactement une solution");
		else {
			float d = b*b-4*a*c;
			if (d<0)
				System.out.println("Il n'ya pas de solution");
			else if (d==0)
				System.out.println("Il y'a exactement une solution");
			else if (d>0)
				System.out.println("Il y'a exactement deux solutions");
			
		}
	}
	
	
	public static int NbreAnnees (int somme) {
		int interet = 0;
		int a = 0;
		while (interet< 100000) {
			interet = (somme*2)/100;
			somme = somme + interet;
			a++;
		}
		return a;
	}
	
	public static boolean Premier(int x) {
	    if (x <= 1) {
	        System.out.println(x + " n'est pas premier");
	        return false;
	    }

	    for (int i = 2; i <= Math.sqrt(x); i++) { // plus efficace que (x+2)/2
	        if (x % i == 0) {
	            System.out.println(x + " n'est pas premier");
	            return false;
	        }
	    }

	    System.out.println(x + " est premier");
	    return true;
	}
	public static void main (String[] args)  {
		String james = "james";
		eleve1 = new Eleve (james,12,14,13,18);
		String x = eleve1.Mention();
		System.out.println ("est la mention de  "+ x);
		NbreAnnees(1000000);
	}
	/*public static boolean Parfait (int x) {
		
	}*/
	
	}

