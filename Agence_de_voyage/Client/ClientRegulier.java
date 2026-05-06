package Client;

public class ClientRegulier extends Client {
	private double tauxDeRemise;
	
	public ClientRegulier(String nom, String adresse, int numero, double tauxDeRemise) {
		super(nom,adresse,numero);
		this.setCode(getNextCode());
		this.setTauxDeRemise(tauxDeRemise);
	}

	public double getTauxDeRemise() {
		return tauxDeRemise;
	}

	public void setTauxDeRemise(double tauxDeRemise) {
		this.tauxDeRemise = tauxDeRemise;
	}
	
	protected Object clone () {
		ClientRegulier c = new ClientRegulier(this.getNom(),this.getAdresse(),this.getNumero(),this.tauxDeRemise);
		c.setCode(this.getCode());
		return (Client) c;
	}
	
	
}
