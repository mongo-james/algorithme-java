package Vol;
import Client.Client;
import Client.ClientRegulier;

public class Vol {
	private Client passager[];
	private int capacite;
	private int libre;
	private String villeDepart;
	private String villeArriver;
	private String dateVol;
	private String HeureDepart;
	private double prixBillet;
	private double tauxDeRemise;
	
	public Vol(int nombrePlaces, double tauxDeRemise) {
		this.capacite= nombrePlaces;
		this.setTauxDeRemise(tauxDeRemise);
		this.setPassager(new Client [capacite]);
		this.setLibre(0);
		this.setVilleDepart("");
		this.setVilleArriver("");
		this.setDateVol("");
		this.setHeureDepart("");
		this.setPrixBillet(0.0);
	}

	public Client[] getPassager() {
		return passager;
	}

	public void setPassager(Client passager[]) {
		this.passager = passager;
	}

	public int getLibre() {
		return libre;
	}

	public void setLibre(int libre) {
		this.libre = libre;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArriver() {
		return villeArriver;
	}

	public void setVilleArriver(String villeArriver) {
		this.villeArriver = villeArriver;
	}

	public String getDateVol() {
		return dateVol;
	}

	public void setDateVol(String dateVol) {
		this.dateVol = dateVol;
	}

	public String getHeureDepart() {
		return HeureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		HeureDepart = heureDepart;
	}

	public double getPrixBillet() {
		return prixBillet;
	}

	public void setPrixBillet(double prixBillet) {
		this.prixBillet = prixBillet;
	}

	public double getTauxDeRemise() {
		return tauxDeRemise;
	}

	public void setTauxDeRemise(double tauxDeRemise) {
		this.tauxDeRemise = tauxDeRemise;
	}
	
	//faire une reservation
	public boolean effectuerReservation(Client client) {
		if(libre<capacite) {
			passager[libre]=client;
			libre++;
			return true;
		}
		return false;
	}
	
	// pour annuler une reservation
	public void annulerReservation(Client client) {
		for (int i=0;i<libre;i++) {
			if(passager[i].equals(client)) {
				for(int j=i; j<libre-1;j++) {
					passager[j]=passager[j+1];
				}
				passager[libre-1] = null;
				libre--;
				break;
			}
		}
	}
	
	//Nombre de client regulier
	
	public int getNombreClientRegulier() {
		int count=0;
		for(int i=0; i<libre; i++) {
			if(passager[i] instanceof ClientRegulier) {
				count ++;
			}
		}
		return count;
	}
	
	//duplication en profondeur 
	
	public Vol dupliquer() {
		Vol copie= new Vol(capacite,tauxDeRemise);
		copie.villeDepart=this.villeDepart;
		copie.villeArriver=this.villeArriver;
		copie.dateVol=this.dateVol;
		copie.HeureDepart=this.HeureDepart;
		copie.prixBillet=this.prixBillet;
		copie.libre=this.libre;
		for(int i=0;i<libre;i++) {
			copie.passager[i]=(Client) passager[i].clone();
			
		}
		return copie;
	}
	
}
