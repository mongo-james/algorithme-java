package Eleve;

public class EleveBoursier extends Eleve {
	private float MontantB;
	
	public EleveBoursier (String nom, int mat, float MontantB) {
		super(nom,mat);
		this.MontantB=MontantB;
	}
	
	public float GetMontantB () {
		return this.MontantB;
	}
	
	public void SetMontantB(float MontantB) {
		this.MontantB=MontantB;
	}
	
	
}
