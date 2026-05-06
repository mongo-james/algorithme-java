
public class Client {
public String nom;
public String adresse;
public int numero;
public int code;
public static int Nextcode=1;


public Client (String nom, String adresse, int numero) {
	this.nom=nom;
	this.adresse=adresse;
	this.numero=numero;
	this.code= Nextcode;
	Nextcode++;
}

public String Tostring() {
	return "["+this.code+","+this.nom+","+this.adresse+","+this.numero+"]";
}

public Object clone() {
	Client c2=new Client (this.nom,this.adresse,this.numero);
	return c2;
}

public boolean equals (Client c) {
	if (this.code==c.code) {
		return true;
	}
	return false;
}


}
