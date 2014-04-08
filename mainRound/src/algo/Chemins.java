package algo;

import instances.Chemin;
import instances.Intersection;
import instances.Matrice;
import instances.MatriceVille;
import instances.Rue;
import instances.Ville;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chemins {

	public static Random r = new Random();
	
	// retourne tous les chemins de taille n depuis l'intersection (triés)
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
					c.addRueDebut(r);
				}
				// on ajoute les chemins au résultat
				l.addAll(cheminsRec);
			}
			return l;
		}
	}
	
	// retourne une solution pour le problème posé
	public static List<Chemin> solution (Ville v, int pas){
		List<Chemin> l = new ArrayList<>();
		double score = 0;
		System.out.println("Calcule de la solution pour un pas "+pas);
		// pour chaque voiture
		for(int i=0; i<v.getNbVehicules(); i++){
			System.out.print("Voiture "+(i+1)+" : ");
			// on choisit le meilleur chemin
			l.add(meilleurChemin(v, pas));
			System.out.println("calcul fini.");
			score += l.get(i).getCout();
		}
		System.out.println("============> score finale = "+score);
		
		return l;
	}
	
	// retourne le meilleur chemin à partir du début
	public static Chemin meilleurChemin(Ville v, int n){
		Chemin cheminRetour = new Chemin();
		int temps = 0;
		Intersection inter = v.getIntersections().get(v.getNumIntersection());
		while(temps < v.getTemps()){
			List<Chemin> liste = chemins(v, inter, n);
			// si pas de chemin
			if(liste.size()==0) return cheminRetour;
			// choisir la meilleure rue
			Rue r = rueCoutMax(liste);
			if(temps+r.getDuree()<=v.getTemps()){
				// l'ajouter à la liste
				cheminRetour.addRue(r);
				// on a visité la rue
				r.setEstVisite(true);
				// mettre à jour inter
				inter = r.getFin();
			}
			// mettre à jour temps
			temps += r.getDuree();
		}
		return cheminRetour;
	}
	
	// retourne la prochaine rue à chosir (première rue du meilleur chemin de llr) 
	public static Rue rueCoutMax(List<Chemin> llr){
		double max = -1;
		List<Integer> imax = new ArrayList<>();
		for(int i=0; i<llr.size(); i++){
			double coutChemin = llr.get(i).getCout();		
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
	
	//============================ Amelioration ==========================
	
	// retourne une solution pour le problème posé
	public static List<List<Integer>> solutionAmelioree (MatriceVille v, int pas){
		if(pas%2!=0) {
			System.out.println("pas, doit être paire");
			return null;
		}
		List<List<Integer>> l = new ArrayList<>();
		double score = 0;
		System.out.println("Calcule de la solution pour un pas "+pas);
		// pour chaque voiture
		for(int i=0; i<v.getNbVehicules(); i++){
			System.out.print("Voiture "+(i+1)+" : ");
			// on choisit le meilleur chemin
			l.add(meilleurCheminAmeliore(v, pas));
			System.out.println("calcul fini.");
		}
		System.out.println("============> score finale = "+score);
		return l;
	}
	
	// retourne le meilleur chemin à partir du début
	public static List<Integer> meilleurCheminAmeliore(MatriceVille v, int n){
		List<Integer> cheminRetour = new ArrayList<>();
		// on ajoute la première intersection
		cheminRetour.add(v.getNumIntersection());
		// temps écoulé sur le chemin
		int temps = 0;
		// intersection de début
		int inter = v.getNumIntersection();
		// ====== calcul successif des intersections à prendre =====
		while(temps < v.getTemps()){
			// meilleure prochaine intersection
			int a = v.meilleureIntersection(inter, n);
			if(a==-1) return cheminRetour;
			else if(temps+v.getDuree(inter, a) <= v.getTemps()){
				// l'ajouter à la liste
				cheminRetour.add(a);
				System.out.println("choix de "+inter+" à "+a+" cout="+v.getCout(inter, a));
				// on a visité la rue
				v.setEstVisite(inter, a);
			}
			// mettre à jour temps
			temps += v.getDuree(inter, a);
			// mettre à jour inter
			inter = a;
		}
		return cheminRetour;
	}
}
