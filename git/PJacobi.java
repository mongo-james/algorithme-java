package Matrice;

import java.util.Scanner;

public class PJacobi {
public double A[] [];
public double B [];
public double X [] [];
public static double E = 1e-6;
public static int cpt =0;

public PJacobi (int n) {
	this.A= new double [n] [n];
	this.B= new double [n];
	this.X= new double [2] [n];
	
	try(Scanner e =new Scanner(System.in)) {
		for (int i=0;i<=n-1;i++) {
			for (int j=0;j<=n-1;j++) {
				System.out.println("A["+(i+1)+"] ["+(j+1)+"] =");
				this.A[i][j]= e.nextFloat();
			}
		}
		System.out.println("\nEntrer l'element de la matrice B");
		
		for(int i=0;i<=n-1;i++) {
		
			System.out.println("\nEntrer l'element de la matrice B["+(i+1)+"]=");
			this.B[i]=e.nextFloat();
			}
	}
	
	for (int i=0;i<=n-1;i++) {
		this.X[0][i]=0;
		this.X[1] [i]=1;
	}
}


public static void TrouverSolution (PJacobi p) {
	 double d = 1;
	while (d>E) {
		cpt ++;
		//calcul des solutions a l'iteration k+1
		
		for (int i=0;i<=p.A.length-1;i++) {
			double s3=0;
			for (int j=0;j<=p.A.length-1;j++) {
				if (i!= j) {
					s3=s3+p.A[i][j]*p.X[0][j];
				}
			}
			p.X[1][i]=(p.B[i]-s3)/p.A[i][i];
		}
		
		double s1=0;
		double s2=0;
		for (int j=0;j<=p.A.length-1;j++) {
			s1=s1+Math.abs(p.X[1][j]-p.X[0][j]);
			s2=s2+Math.abs(p.X[1][j]);
		}
		if(s2>1e-12) 
			d=s1/s2;	
		else
			d=Float.MAX_VALUE;
		
		
		for (int i=0;i<=p.A.length-1;i++) {
			p.X[0][i]=p.X[1][i];
		}
	}
}


public static void AfficheSolution(PJacobi p) {
	 for (int i=0;i<=p.A.length-1;i++) {
		 System.out.println("La solution X["+(i+1)+"] est : " +p.X[1][i]+".");
		 
	 }
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Trouvons les Solutions de l'equation de la forme AX=B");
    
   
    System.out.print("Bien-Vouloir entrer l'ordre de la matrice A : ");
    int n = scanner.nextInt(); 
    
    
    PJacobi p = new PJacobi(n);
    
    TrouverSolution(p);
    AfficheSolution(p);
    System.out.println("le nombre d'iterations est de :"+(cpt-1));
    scanner.close();
}
}
