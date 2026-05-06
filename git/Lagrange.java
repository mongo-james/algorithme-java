package Interpollation;

import java.util.Scanner;
import java.util.Locale;

public class Lagrange {
public double X [];
public double Y [];
public double F [];

public Lagrange(int n) {
	this.X= new double [n];
	this.Y= new double [n];
	this.F= new double [n];
	
	Scanner e =new Scanner (System.in);
	
	e.useLocale(Locale.US);
		System.out.println("Entrer tous les X");
		for (int i=0;i<=n-1;i++) {
			System.out.println("X["+(i+1)+"] =");
			this.X[i]=e.nextDouble();
		}
		
		System.out.println("Entrer tous les Y");
		for (int i=0;i<=n-1;i++) {
			System.out.println("Y["+(i+1)+"] =");
			this.Y[i]=e.nextDouble();
		}
		
	
}


public static double Fonction(Lagrange L,double x) {
	double R =0;
	
	for (int k=0;k<=L.X.length-1;k++) {
		double P=1;
		for (int i=0;i<=L.X.length-1;i++) {
			if(i!=k) {
				P*=((x-L.X[i])/(L.X[k]-L.X[i]));
			}
		}
		
		L.F[k]=P;
		R+=L.Y[k]*P;
	}
	return R;
}



public static void main (String [] args) {
	Scanner t = new Scanner(System.in);
	t.useLocale(Locale.US);
		System.out.println("Entrer la taille du tableau experimental :");
		int n = t.nextInt();
		
		Lagrange L = new Lagrange(n);
		
		System.out.println("Entrer le nombre dont vous voulez l'image et de preference qui soit contenue entre les bornes du tableau experimentale :");
		
		
	double p= t.nextDouble();
	
	double S=Fonction(L,p);
	
	System.out.println("l'image que vous chercher est:"+S);
	
	t.close();
}
}
