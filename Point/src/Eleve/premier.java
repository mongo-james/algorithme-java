package Eleve;

public class premier {
	public static boolean premier(int x) {
		if(x<=0) {
			return false;
		}else if(x<=1) {
			return false;
		}
	for(int i=2;i<=(x+2)/2;i++) {
		if(x%i==0) {
			return false;
		}
	}
	return true;
	}
	public static void main(String[] args) {
	
		boolean y=premier(17);
		System.out.println(y);
	}

}
