package instances;

import java.util.HashMap;

public class MatriceVille {

	int temps;
	int nbVehicules;
	int numIntersection;
	int nbintersections;
	// matrice pour les cacules
	Matrice m;
	// map contenant les durées entre deux intersections
	HashMap<Integer, Integer> mapDurees = new HashMap<>();

	public MatriceVille(int temps, int nbVehicules, int nbintersections, int numIntersection) {
		this.temps = temps;
		this.nbVehicules = nbVehicules;
		this.nbintersections = nbintersections;
		this.numIntersection = numIntersection;
		m = new Matrice(nbintersections);
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
	
	public void ajouterRue(int debut, int fin, boolean sens, int duree, int longueur){
		float cout = (1.0f *longueur) / duree;
		mapDurees.put(cle(debut, fin), duree);
		m.ajouterRue(debut, fin, cout);
		if(sens){ //cas ou double sens
			mapDurees.put(cle(fin, debut), duree);
			m.ajouterRue(fin, debut, cout);
		}
	}

	public int meilleureIntersection(int inter, int n) {
		return m.meilleureRue(inter, n);
	}

	public void setEstVisite(int inter, int a) {
		m.estVisitee(inter, a);
	}


	public int getDuree(int inter, int a) {
		Integer duree = mapDurees.get(cle(inter, a));
		if(duree==null){
			return Integer.MAX_VALUE;
		}
		return duree;
	}
	
	public int cle(int a, int b){
		return a*100000 + b;
	}


	public float getCout(int inter, int a) {
		return m.getCout(inter, a);
	}
}
