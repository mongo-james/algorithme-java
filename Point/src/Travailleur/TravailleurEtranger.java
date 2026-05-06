package Travailleur;

public class TravailleurEtranger extends Travailleur {

	private String nationalite;
	
	public TravailleurEtranger(String nom, int salaire, String nationalite) {
		super(nom, salaire);
		this.nationalite=nationalite;
	}
	
	public String toString() {
		return "TravailleurEtranger["+this.getNom()+","+this.getSalaire()+","+this.nationalite+"]";
	}
	
	protected Object clone() {
		TravailleurEtranger te = new TravailleurEtranger(this.getNom(),this.getSalaire(),this.nationalite);
		return te;
	}
	
	public static double sommeSalaireTE(Travailleur tab[]) {
			double S=0;
			for(int i=0; i<tab.length; i++) {
				if (tab[i] instanceof TravailleurEtranger) {
					S=S+tab[i].getSalaire();
				}
			}
			return  S;
		
	}
	
	public static float Salairemax(Travailleur tab[]) {
		float max=0;
		for (int i=0;i<tab.length;i++) {
			if (max<tab[i].getSalaire()) {
				max=tab[i].getSalaire();
			}
		}
		return max;
	}
	
	
	public static void main (String args[]) {
		Travailleur t1 = new Travailleur("NLONG",1000000);
		Travailleur t2 = new Travailleur("MBALLA",3500000);
		Travailleur t3 = (Travailleur) t2.clone();

		t3.setNom("NLONG");
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(t3.toString());
		
		System.out.println(t1.equals(t2));
		System.out.println(t2.equals(t3));
		System.out.println(t1.equals(t3));
		
		TravailleurEtranger t4 = new TravailleurEtranger("DUPOND",2000000,"Francaise");
		TravailleurEtranger t5 = (TravailleurEtranger) t4.clone();
		t5.setNom("DUC");
		
		System.out.println(t4.toString());
		System.out.println(t5.toString());
		
		Travailleur Tab[]= {t1,t2,t3,t4,t5};
		System.out.println(Salairemax(Tab)); 
	}
}
