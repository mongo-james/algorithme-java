package Matrice;

import java.util.Scanner;

public class PGauss {
    public float[][] A;
    public float[] B;
    public float[] X;
    
    public PGauss(int n, Scanner e) {  // ✅ Scanner passé en paramètre
        this.A = new float[n][n];
        this.B = new float[n];
        this.X = new float[n];
        for (int i = 0; i < n; i++) {
            this.X[i] = 0;
        }
        
        System.out.println("\nSaisie de la matrice A (" + n + "x" + n + "):");
        // ✅ Plus de try-with-resources - on utilise le scanner reçu
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                System.out.print("A[" + (i + 1) + "][" + (j + 1) + "] = ");
                this.A[i][j] = e.nextFloat();
            }
        }
        System.out.println("\nSaisie du vecteur B (" + n + " éléments):");
        for (int i = 0; i < n; i++) {
            System.out.print("B[" + (i + 1) + "] = ");
            this.B[i] = e.nextFloat();
        }
    }
    
    public static void Triangularisation(PGauss p) { 
        for (int i = 0; i <= p.A.length - 2; i++) {
            for (int j = i + 1; j <= p.A.length - 1; j++) {
                float T = p.A[j][i]; 
                for(int k = 0; k <= p.A.length - 1; k++) {
                    p.A[j][k] = p.A[i][i] * p.A[j][k] - T * p.A[i][k];
                }
                p.B[j] = p.A[i][i] * p.B[j] - T * p.B[i];
            }
        }
    } 
    
    public static float DetA(PGauss p) {
        float P = 1;
        for (int i = 0; i <= p.A.length - 1; i++) {
            P = P * p.A[i][i];
        }
        return P;
    }
    
    public static void Solution(PGauss p) {
        if (DetA(p) == 0) {
            System.out.println("Impossible de trouver les Solutions a votre Systeme car le determinant de votre matrice A est nul");
        } else {
            int n = p.A.length;
            p.X[n - 1] = p.B[n - 1] / p.A[n - 1][n - 1];
            
            for (int i = p.A.length - 2; i >= 0; i--) {
                float S = 0;
                for (int j = i + 1; j <= p.A.length - 1; j++) {
                    S = S + p.A[i][j] * p.X[j];
                }
                p.X[i] = (p.B[i] - S) / p.A[i][i];
            }
        }
    }
    
    public static void AfficheSolution(PGauss p) {
        for (int i = 0; i <= p.A.length - 1; i++) {
            System.out.println("La solution X[" + (i + 1) + "] est : " + p.X[i]);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Trouvons les Solutions de l'equation de la forme AX=B");
        
        System.out.print("Bien-Vouloir entrer l'ordre de la matrice A : ");
        int n = scanner.nextInt();
        
        // ✅ On passe le scanner au constructeur (pas de nouveau scanner)
        PGauss p = new PGauss(n, scanner);
        
        Triangularisation(p);
        Solution(p);
        AfficheSolution(p);
        
        scanner.close();
    }
}