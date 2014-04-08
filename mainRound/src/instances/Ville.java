package instances;

import java.util.ArrayList;

public class Ville {

	ArrayList<Intersection> intersections;
	int temps;
	int nbVehicules;
	int numIntersection;
	int nbintersections;

	public Ville(int temps, int nbVehicules, int nbintersections, int numIntersection) {
		this.temps = temps;
		this.nbVehicules = nbVehicules;
		this.nbintersections = nbintersections;
		this.numIntersection = numIntersection;
		intersections = new ArrayList<Intersection>();
		
	}

	public ArrayList<Intersection> getIntersections() {
		return intersections;
	}

	public int getTemps() {
		return temps;
	}

	public int getNbVehicules() {
		return nbVehicules;
	}

	public int getNumIntersection() {
		return numIntersection;
	}

	
	public void ajouterIntersection(Intersection inter){
		intersections.add(inter);
	}
	
	public void ajouterRue(int debut, int fin, boolean sens, int duree, int longueur){
		Rue r = new Rue(intersections.get(debut), intersections.get(fin), duree, longueur);
		intersections.get(debut).ajouterRue(r);
		if(sens){ //cas ou double sens
 			intersections.get(fin).ajouterRue(new Rue(intersections.get(fin), intersections.get(debut), duree, longueur));
		}
	}

	@Override
	public String toString() {
		return "Ville [intersections=" + intersections + ", temps=" + temps
				+ ", nbVehicules=" + nbVehicules + ", numIntersection="
				+ numIntersection + "]";
	}
	
}
