
public class ClientRegulier extends Client {
public double TauxDeRemise;

public ClientRegulier (String nom,String adresse,int numero, double TauxDeRemise) {
	super(nom,adresse,numero);
	this.TauxDeRemise=TauxDeRemise;
	this.code=Nextcode;
	Nextcode++;
}

public Object clone(ClientRegulier c) {
	ClientRegulier c2= new ClientRegulier(c.nom;c.adresse,c.numero,c.TauxDeRemise);
	c2.code=c.code;
	return c2;
}


}
