package interet;

public class interet {
	public static int NbreAnnees(int somme) {
		int i=0;
		int a=0;
		while(i<100000) {
			i=(2*somme)/100;
			somme= somme+i;
			a++;
		}
		return a;
	}
	public static double g (double x) {
		if (x<40) {return x*x+1;}
		else if (x>=40 && x<=80) {return x*x;}
		else if (x>80) {return x+1;}
		return 0;
	}
	public static float sommeTab (double tab[]) {
		double S=0;
		for(int i=0; i<tab.length; i++) {
			S=S+tab[i];
		}
		return (float) S;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =NbreAnnees(2000);
		System.out.println(x);
		double y =  g(30);
		System.out.println(y);	
		double T1 []= {1,1,1,1};
		double z = sommeTab(T1);
		System.out.println(z);
	}

}
