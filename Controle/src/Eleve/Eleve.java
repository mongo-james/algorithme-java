package Eleve;

public class Eleve {
    private String nom;
    private int matricule;
    
    public Eleve(String nom, int mat) {
        this.nom = nom.toUpperCase();
        this.matricule = mat;
    }
    
    public void Setnom(String nom) {
        this.nom = nom;
    }
    
    public void SetMat(int mat) {
        this.matricule = mat;
    }
    
    public String Getnom() {
        return this.nom;
    }  
    
    public int Getmat() {
        return this.matricule;
    }
    
    public String toString() {
        return "[le nom est :" + this.nom + ", et le matricule est :" + this.matricule + "]";
    }
    
    // CORRECTION ICI : i < Eleve.length au lieu de i <= Eleve.length
    public int NombreEleveBoursier(Eleve[] Eleve) {
        int count = 0;
        for (int i = 0; i < Eleve.length; i++) {  // < au lieu de <=
            if (Eleve[i] instanceof EleveBoursier) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Eleve e1 = new Eleve("James", 001);
        Eleve e2 = new Eleve("Joslain", 002);
        Eleve e3 = new Eleve("Lea", 003);
        EleveBoursier e4 = new EleveBoursier("Tamo", 004, 200000);
        EleveBoursier e5 = new EleveBoursier("John", 005, 400000);
        
        // Afficher les informations
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());
        System.out.println(e4.toString());
        System.out.println(e5.toString());
         
        // Créer le tableau d'élèves
        Eleve[] eleves = new Eleve[5];
        eleves[0] = e1;
        eleves[1] = e2;
        eleves[2] = e3;
        eleves[3] = e4; 
        eleves[4] = e5;
        
        // Appeler la méthode
        Eleve test = new Eleve("Test", 0);
        int nombreBoursiers = test.NombreEleveBoursier(eleves);
        System.out.println("Nombre d'élèves boursiers : " + nombreBoursiers);
    }
}