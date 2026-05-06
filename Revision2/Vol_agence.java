
public class Vol_agence {
	public int libre =0;
	public int capacite;
	public String villeDeDepart;
	public String villeDArriver;
	public String Datevol;
	public String heureDepart;
	public float PrixBillet;
	public double TauxDeRemise;
	public Client passager[];


public Vol_agence (int capacite, double TauxDeRemise) {
	this.passager= new Client[capacite];
	this.capacite=capacite;
	this.villeDeDepart="";
	this.villeDArriver="";
	this.PrixBillet=0;
	this.Datevol="";
	this.heureDepart="";
	this.TauxDeRemise=TauxDeRemise;
}

public boolean AjouterUnClient(Client c) {
	if(libre==capacite) {
		System.out.println("impossible d'ajouter car le vol est plein");
	}
	if(libre<capacite) {
		passager[libre]=  c;
		libre++;
		return true;
	}
	return false;
}

public boolean SupprimerClient(Client c) {
    // Recherche du client
    for (int i = 0; i < libre; i++) {
        if (passager[i] != null && passager[i].equals(c)) {
            // Décalage des éléments
            for (int j = i; j < libre - 1; j++) {
                passager[j] = passager[j + 1];
            }
            // Nettoyage et mise à jour
            passager[libre - 1] = null;
            libre--;
            return true; // Suppression réussie
        }
    }
    return false; // Client non trouvé
}

public int NombrePassager() {
	if (libre==capacite) {
		return capacite;
	}
	else {
		int count =0;
		for (int i=0;i<libre;i++) {
			count ++;
		}
		return count;
	}
}

public int NombrePassagerRegulier() {
	
}

















}
