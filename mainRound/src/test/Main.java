package test;


import algo.Chemins;
import fichier.Rendu;
import fichier.VilleFactory;
import instances.MatriceVille;
import instances.Ville;

public class Main {

	public static void main(String[] args){
		MatriceVille v= VilleFactory.createM("paris_54000.txt");
		Rendu.createM("resultat.txt", Chemins.solutionAmelioree(v, 2));
		//Ville vi = VilleFactory.create("paris_54000.txt");
		//Rendu.create("resultat.txt", Chemins.solution(vi, 2));
	}
}
