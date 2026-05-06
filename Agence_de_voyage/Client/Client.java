package Client;

public class Client {
	private String nom;
	private String adresse;
	private int numero;
	private int code;
	private static int nextCode =1;
	
	public Client (String nom, String adresse, int numero) {
		this.setNom(nom);
		this.setAdresse(adresse);
		this.setNumero(numero);
		this.setCode(getNextCode());
		setNextCode(getNextCode() + 1);
	}
	
	public String toString() {
		return "["+this.getNom()+","+this.getAdresse()+","+this.getNumero()+","+this.getCode()+"]";
	}
	
	public Object clone () {
		Client c = new Client(this.getNom(),this.getAdresse(),this.getNumero());
		c.setCode(this.getCode());
		return (Client) c;
	}
	
	public boolean equals (Client c) {
		if (this.getCode()==c.getCode()) {
			return true;
		}
		return false;
	}

	public static int getNextCode() {
		return nextCode;
	}

	public static void setNextCode(int nextCode) {
		Client.nextCode = nextCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
