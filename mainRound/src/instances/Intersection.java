package instances;

import java.util.ArrayList;

public class Intersection {
 
	double x,y;
	int numero;
	ArrayList<Rue> rues = new ArrayList<Rue>();	
	public Intersection(double x, double y, int numero){
		this.x = x;
		this.y = y;
		this.numero = numero;
	}
	
	public void ajouterRue(Rue r){
		rues.add(r);
	}
}
