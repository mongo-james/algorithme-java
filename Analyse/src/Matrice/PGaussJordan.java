package Matrice;


import java.util.Scanner;

public class PGaussJordan {
    public float[][] A;
    public float[] B;
    public float[] X;
    
    public PGaussJordan(int n) {
        this.A = new float[n][n];
        this.B = new float[n];
        this.X = new float[n];
        for (int i = 0; i < n; i++) {
            this.X[i] = 0;
        }
        
        System.out.println("/nSaisie de la matrice A (" + n + "x" + n + "):");
        try (Scanner e = new Scanner(System.in)) {
            for (int i = 0; i <= n - 1; i++) {
                for (int j = 0; j <= n - 1; j++) {
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
    
    public static void Triangularisation(PGaussJordan p) { 
        for (int i = 0; i <= p.A.length - 2; i++) {
            for (int j = i + 1; j <= p.A.length - 1; j++) {
                float T = p.A[j][i]; 
                for(int k=0;k<=p.A.length-1;k++) {
                	p.A[j] [k] = p.A[i][i]*p.A[j][k]-T*p.A[i][k];
                }
                p.B[j]= p.A[i][i]*p.B[j]-T*p.B[i];
            }
        }
        //apres premiere triangularisation on triangularise le superieure donc ici on a change juste l'ordre des boucles for
        for (int i = p.A.length-1; i>=1 ; i--) {
            for (int j = i - 1; j>=0; j--) {
                float T = p.A[j][i]; 
                for(int k=p.A.length-1;k>=0;k--) {
                	p.A[j] [k] = p.A[i][i]*p.A[j][k]-T*p.A[i][k];
                }
                p.B[j]= p.A[i][i]*p.B[j]-T*p.B[i];
            }
        }
    } 
    
     public static float DetA(PGaussJordan p) {
    	 float P=1;
    	 for (int i=0;i<=p.A.length-1;i++) {
    		 P=P*p.A[i][i];
    	 }
    	 return P;
     }
     //ici pour les solutions on fait juste comme pour n-1 avec tout le reste assez facile 
     public static void Solution(PGaussJordan p) {
    	 if (DetA(p)==0) {
    		 System.out.println("Impossible de trouver les Solutions a votre Systeme car le determinant de votre matrice A est nul");
    	 }
    	 else {
    		 int n=p.A.length;
    		 for (int i=0;i<=p.A.length-1;i++) {
    			 p.X[i]=p.B[i]/p.A[i][i];
    		 }
    	 }
     }
     
     public static void AfficheSolution(PGaussJordan p) {
    	 for (int i=0;i<=p.A.length-1;i++) {
    		 System.out.println("La solution X["+(i+1)+"] est : " +p.X[i]);
    	 }
     }
     
     public static void main(String[] args) {
    	    Scanner scanner = new Scanner(System.in);
    	    
    	    System.out.println("Trouvons les Solutions de l'equation de la forme AX=B");
    	    
    	   
    	    System.out.print("Bien-Vouloir entrer l'ordre de la matrice A : ");
    	    int n = scanner.nextInt(); 
    	    
    	    
    	    PGaussJordan p = new PGaussJordan(n);
    	    
    	    
    	    Triangularisation(p);      
    	    Solution(p);               
    	    AfficheSolution(p);       
    	    
    	    scanner.close();
    	}
} 