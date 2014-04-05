package algo;

import instances.Chemin;
import instances.Intersection;
import instances.Rue;
import instances.Ville;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chemins {

	public static Random r = new Random();
	
	// retourne tous les chemins de taille n depuis l'intersection
	public static List<Chemin> chemins(Ville v, Intersection intersection, int n){
		List<Chemin> l = new ArrayList<Chemin>();
		// si fini
		if(n == 0){
			l.add(new Chemin());
			return l;
		}
		//sinon
		else{
			// pour toutes les rues accessibles depuis intersection
			for(Rue r : intersection.getRues()){
				// on appelle recursivement
				List<Chemin> cheminsRec = chemins(v, r.getFin(), n-1);
				// on ajoute la rue r à tous les chemins obtenus
				for(Chemin c : cheminsRec){
					c.addRue(0, r);
				}
				// on ajoute les chemins au résultat
				l.addAll(cheminsRec);
			}
			return l;
		}
	}
	
	// retourne une solution pour le problème posé
	public static List<List<Rue>> solution (Ville v){
		List<List<Rue>> l = new ArrayList<>();
		// pour chaque voiture
		for(int i=0; i<v.getNbVehicules(); i++){
			// on choisit le meilleur chemin
			l.add(meilleurChemin(v));
		}
		
		return l;
	}
	
	// retourne le meilleur chemin à partir du début
	public static List<Rue> meilleurChemin(Ville v){
		List<Rue> l = new ArrayList<>();
		int temps = 0;
		Intersection inter = v.getIntersections().get(v.getNumIntersection());
		while(temps < v.getTemps()){
			List<Chemin> liste = chemins(v, inter, 15);
			// si pas de chemin
			if(liste.size()==0) return l;
			// choisir la meilleure rue
			Rue r = rueCoutMax(liste);
			if(temps+r.getDuree()<=v.getTemps()){
				// l'ajouter à la liste
				l.add(r);
				// on a visité la rue
				r.setEstVisite(true);
				// mettre à jour inter
				inter = r.getFin();
			}
			// mettre à jour temps
			temps += r.getDuree();
		}
		return l;
	}
	
	// retourne la prochaine rue à chosir (première rue du meilleur chemin de llr)
	public static Rue rueCoutMax(List<Chemin> llr){
		double max = -1;
		List<Integer> imax = new ArrayList<>();
		for(int i=0; i<llr.size(); i++){
			double coutChemin = Ville.cout(llr.get(i));
			
			// si un meilleur
			if(coutChemin > max){
				max = coutChemin;
				imax.clear();
				imax.add(i);
			}
			// sinon si c'est le même
			else if(coutChemin == max){
				imax.add(i);
			}
		}
		// si plusieurs chemin au même coût, on en choisit un aléatoirement
		int alea = r.nextInt(imax.size());
		return llr.get(imax.get(alea)).getRue(0);
	}
}
