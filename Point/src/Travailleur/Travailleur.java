package Travailleur;

public class Travailleur {
	private String  nom;
	private int salaire;
	
	public Travailleur(String nom, int salaire) {
		this.setNom(nom.toUpperCase());
		this.setSalaire(salaire);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	
	public String toString() {
		return "["+this.nom+","+this.getSalaire()+"]";
	}
	
	public boolean equals(Travailleur t) {
		if(this.nom.equals(t.getNom())) {
			return true;
		}
		return false;
	}
	
	protected Object clone () {
		Travailleur tc = new Travailleur (this.nom, this.getSalaire());
		return tc;
	}
	
	public static double salaireMax(Travailleur tab[]) {
		double min =0;
		for (int i=0; i<tab.length;i++) {
			if (min>tab[i].getSalaire()) {
				min = tab[i].getSalaire();
			}
		}
		return min;
	}
}
