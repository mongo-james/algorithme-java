package cholesky;

import java.util.Scanner;

public class Cho {
	public double [] [] A;
	public double []  B;
	public double [] X;
	public double [] [] L;
	public double [] [] LT;
	public double [] Y;
	private static double somme;
	private static double somme2;
	private static Scanner e;
	
	public Cho (int n) {
		this.A= new double [n] [n] ;
		this.B= new double  [n] ;
		this.X= new double [n]  ;
		this.L= new double [n] [n] ;
		this.LT= new double [n] [n] ;
		this.Y= new double [n]  ;
		
		//Pour entrer les valeurs de A et B et en meme temps initialiser les valeurs des tableau x et y
		for (int i = 0; i < n; i++) {
            this.X[i] = 0;
            this.Y[i] =0;
        }
        
        System.out.println("/nSaisie de la matrice A (" + n + "x" + n + "):");
        System.out.println("/nRemarquer bien que nous entrons uniquement une partie des valeurs de la matrice car elle est deja symetrique  de base");
        System.out.println("/n Bien vouloir eviter une matrice non carre et non symetrique merci !!!");
        try (Scanner e = new Scanner(System.in)) {
            for (int i = 0; i <= n - 1; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("A[" + (i + 1) + "][" + (j + 1) + "] = ");
                    this.A[i][j] = e.nextFloat();
                }
            }
            System.out.println("/nSaisie du vecteur B (" + n + " éléments):");
            for (int i = 0; i < n; i++) {
                System.out.print("B[" + (i + 1) + "] = ");
                this.B[i] = e.nextFloat();
            }
        }
	}
	
	//fonction pour calculer la premiere matrice L
public static void MatriceL(Cho c) {
	    int n = c.A.length;
	    
	    for (int i = 0; i < n; i++) {
	        // Calcul des éléments sous-diagonaux (j < i)
	        for (int j = 0; j < i; j++) {
	            double somme = 0;
	            for (int k = 0; k < j; k++) {
	                somme += c.L[i][k] * c.L[j][k];
	            }
	            c.L[i][j] = (c.A[i][j] - somme) / c.L[j][j];
	       }
	        
	        // Calcul de l'élément diagonal
	        double somme = 0;
	       for (int k = 0; k < i; k++) {
	            somme += Math.pow(c.L[i][k], 2);
	       }
	        c.L[i][i] = Math.sqrt(c.A[i][i] - somme);
	   }
}

//on peut finalement commencer a calculer les y grace au element de L
public static void CalculY(Cho c) {
	for(int i=0;i<=c.A.length-1;i++) {
		somme =0;
		for (int j=0;j<=i;j++) {
			somme = somme + c.L[i][j]*c.Y[j];
		}
		
		c.Y[i]= (c.B[i]-somme)/c.L[i][i];
	}
}

//ici il s'agit de faire passer les elements de la matrice L vers sa transposer afin de calculer les valeurs de x qui sont les solutions finales
public static void MatriceLTransposer(Cho c) {
	for(int i=0;i<=c.L.length-1;i++) {
		for (int j=0;j<=i;j++) {
			c.LT[j][i]=c.L[i][j];
		}
	}
	// Pour vérifier que ta transposition est correcte :
	System.out.println("Vérification symétrie :");
	for (int i = 0; i < c.L.length; i++) {
	    for (int j = i; j < c.L.length; j++) {
	        if (c.LT[i][j] != c.L[j][i]) {
	            System.out.println("Erreur à [" + i + "][" + j + "]");
	        }
	    }
	}
	
	c.L=null;
}


public static void  CalAfficheSolution (Cho c) {
	System.out.println("/nLes solutions de votre systeme d'equations sont les suivantes:");
	for (int i=c.LT.length-1;i>=0;i--) {
		somme = 0;
		for (int j=i+1;j<=c.LT.length-1;j++) {
			somme = somme + c.LT[i][j]*c.X[j];
		}
		c.X[i]=(c.Y[i]-somme)/c.LT[i][i];
		
		System.out.println("X"+(i+1)+"="+c.X[i]);
	}
}
	
	
	public static void main(String[] args) {
		e = new Scanner(System.in);
		System.out.println("/nEntrer l'ordre de la matrice A de votre systeme");
		int n =e.nextInt();
		Cho c = new Cho(n);
		MatriceL(c);
		CalculY(c);
		MatriceLTransposer(c);
		CalAfficheSolution(c);
		
	}

}
