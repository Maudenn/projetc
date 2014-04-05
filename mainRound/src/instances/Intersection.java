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

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Rue> getRues() {
		return rues;
	}

	public void setRues(ArrayList<Rue> rues) {
		this.rues = rues;
	}
	@Override
	public boolean equals(Object i){
		if(i==null) return false;
		return ((Intersection)i).numero == numero;
	}

	@Override
	public String toString() {
		return "Intersection [x=" + x + ", y=" + y + ", numero=" + numero
				+ ", rues=" + rues + "]";
	}
	
}
