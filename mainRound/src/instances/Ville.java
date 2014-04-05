package instances;

import java.util.ArrayList;
import java.util.List;

public class Ville {

	ArrayList<Intersection> intersections;
	int temps;
	int nbVehicules;
	int numIntersection;

	public Ville(int temps, int nbVehicules, int numIntersection) {
		this.temps = temps;
		this.nbVehicules = nbVehicules;
		this.numIntersection = numIntersection;
		intersections = new ArrayList<Intersection>();
	}

	public ArrayList<Intersection> getIntersections() {
		return intersections;
	}

	public void setIntersections(ArrayList<Intersection> intersections) {
		this.intersections = intersections;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public int getNbVehicules() {
		return nbVehicules;
	}

	public void setNbVehicules(int nbVehicules) {
		this.nbVehicules = nbVehicules;
	}

	public int getNumIntersection() {
		return numIntersection;
	}

	public void setNumIntersection(int numIntersection) {
		this.numIntersection = numIntersection;
	}
	
	public void ajouterIntersection(Intersection inter){
		intersections.add(inter);
	}
	
	public void ajouterRue(int debut, int fin, boolean sens, int duree, int longueur){
		if(sens){ //cas ou double sens
 			intersections.get(debut).ajouterRue(new Rue(intersections.get(debut), intersections.get(fin), duree, longueur));
 			intersections.get(fin).ajouterRue(new Rue(intersections.get(fin), intersections.get(debut), duree, longueur));
		}else{
			intersections.get(debut).ajouterRue(new Rue(intersections.get(debut), intersections.get(fin), duree, longueur));
		}
	}
	
	public static double cout(Rue rue){
		if (rue.estVisite){
			return 0;
		}else{
			return rue.getCout();
		}
	}
	
	public static double cout(Chemin rues){
		double c = 0;
		for(Rue r : rues.getRues()) c += cout(r);
		return c;
	}

	@Override
	public String toString() {
		return "Ville [intersections=" + intersections + ", temps=" + temps
				+ ", nbVehicules=" + nbVehicules + ", numIntersection="
				+ numIntersection + "]";
	}
	
}
