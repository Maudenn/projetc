package fichier;

import instances.Chemin;
import instances.Rue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class Rendu {

	public static void create(String fichier, List<Chemin> l){
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
			// nb voitures
			fichierSortie.println(l.size());
			// affichage des chemins
			for(Chemin chemin : l){
				// nb intersections
				fichierSortie.println(chemin.nb()+1);
				for(Rue r : chemin.getRues()){
					// intersections
					fichierSortie.println(r.getDebut().getNumero());
				}
				// intersection de fin
				fichierSortie.println(chemin.getDerniere().getFin().getNumero());
			}
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
	}
	
	public static void createM(String fichier, List<List<Integer>> l){
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
			// nb voitures
			fichierSortie.println(l.size());
			// affichage des chemins
			for(List<Integer> li : l){
				// nb intersections
				fichierSortie.println(li.size());
				for(Integer ri : li){
					// intersections
					fichierSortie.println(ri);
				}
			}
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
	}
}
