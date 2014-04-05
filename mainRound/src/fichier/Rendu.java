package fichier;

import instances.Rue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class Rendu {

	public static void create(String fichier, List<List<Rue>> l){
		try {
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
			// nb voitures
			fichierSortie.println(l.size());
			// affichage des chemins
			for(List<Rue> ll : l){
				// nb intersections
				fichierSortie.println(ll.size()+1);
				for(Rue r : ll){
					// intersections
					fichierSortie.println(r.getDebut().getNumero());
				}
				// intersection de fin
				fichierSortie.println(ll.get(ll.size()-1).getFin().getNumero());
			}
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
	}
}
