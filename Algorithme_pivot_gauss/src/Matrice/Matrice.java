package Matrice;

import java.util.Scanner;



public class Matrice {
public static double  [] [] A;
public double [] B;
public static int n;
public static double [] [] cs;
public static double [] B2;
public static double [] X;

public Matrice (int n) {
	Matrice.A= new double [n] [n];
	this.B= new double [n];
	Matrice.X= new double [n];

	System.out.println("Saisie de la matrice A (" + n + "x" + n + "):");
	try (Scanner e = new Scanner(System.in)) {
		for (int i=0;i<=n-1;i++) {
			for (int j=0;j<=n-1;j++) {
				System.out.print("A[" + (i+1) + "][" + (j+1) + "] = ");
				Matrice.A[i][j]= e.nextDouble();
			}
		}
		System.out.println("\nSaisie du vecteur B (" + n + " éléments):");
		for (int i = 0; i < n; i++) {
		    System.out.print("B[" + (i+1) + "] = ");
		    this.B[i] = e.nextDouble();
		}
	}
}




public static void Triangularisation(double [] [] A3, double [] B3, int n,Matrice m) {
	double x;
	Matrice.B2= B3;
	Matrice.cs = A3;
	for (int i=0;i<=n-2;i++) {
		for(int j=i+1;j<=n-1;j++) {
			x= A3 [i] [j];
			for(int k=0;k<=n-1;k++) {
				Matrice.cs[j] [k] = A3[i] [i] *A3[j] [k] - x*A3[i] [k];
			}
			Matrice.B2[j]= A3[i] [i] * B3[j]- x *B3[i];
		}
	}
}

public static double Det (Matrice m) {
	double P =1;
	for (int i=0;i<=n-1;i++) {
		P=P*cs[i][i];
	}
	return P;
}

public static double AfficherSolution (int n,double [] [] cs, double [] B2,Matrice m) {
	if(Det(m)==0) {
		System.out.println ("Impossible d'avoir des solutions pour votre systeme d'equation");
	}
	else {
		X [n-1] = B2[n-1] /cs[n-1][n-1];
		System.out.println("Premier X"+(n)+":"+(float) X [n-1]+".");
		for(int i=n-2;i>=0;i--) {
			double s1=0;
			for (int j=i+1;j<=n-1;j++) {
				s1=s1+cs[i][j]*X[j];
			}
			X[i]=(B2[i]-s1)/ cs [i] [i];
			System.out.println("Ensuite X"+(i+1)+":"+(float) X[i]+".");
		}
	}
	return 0;
}

public static void main (String [] args) {
	Matrice g = new Matrice (4);
	Triangularisation(g.A,g.B,4,g);
	Det(g);
	g.AfficherSolution(4,Matrice.cs,Matrice.B2,g);
	
}
}
