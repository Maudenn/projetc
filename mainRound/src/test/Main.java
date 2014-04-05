package test;

import algo.Chemins;
import fichier.Rendu;
import fichier.VilleFactory;
import instances.Ville;

public class Main {

	public static void main(String[] args){
		//Ville v = VilleFactory.create("paris_54000.txt");
		Ville v = VilleFactory.create("testVille.txt");
		Rendu.create("resultat.txt", Chemins.solution(v));
	}
}
