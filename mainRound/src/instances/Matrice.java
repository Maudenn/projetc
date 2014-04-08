package instances;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Matrice {

	public static Random random = new Random();
	
	int nbintersections;
	
	// ville initiale
	HashMap<Integer, Float> ville = new HashMap<>();
	
	public Matrice(int nb) {
		nbintersections = nb;
	}

	private void carre(HashMap<Integer, Float> mapCoutInit , HashMap<Integer, Float> mapCoutFin,  HashMap<Integer, Short> mapInter){
		// effacer les maps d'entrée
		mapCoutFin.clear();
		mapInter.clear();
		// calcule du carré de la matrice
		for(int i=0; i<nbintersections; i++){
			for(int j=0; j<nbintersections; j++){
				// -------------si i = j-------------
				if(i==j){
					continue;
				}
				// ---------------sinon calcul d'une case------------
				else{
					// init du max
					float max = -1;
					List<Short> jmax = new ArrayList<>();
					for(short k=0; k<nbintersections; k++){
						Float a1 = mapCoutInit.get(cle(i, k));
						Float a2 = mapCoutInit.get(cle(k, j));
						// si pas de connexion on continue
						if(a1==null || a2==null){
							continue;
						}
						// on calcule la somme
						float resultat = a1 + a2;
						// si max
						if(resultat > max){
							max = resultat;
							jmax.clear();
							jmax.add(k);
						}
						// égal au max
						else if(resultat == max){
							jmax.add(k);
						}
					}
					//----- fin du calcul d'une case ------
					// si on a un max on modifie la matrice
					if(max != -1){
						// on choisit un des sommets max aléatoirement
						int alea = random.nextInt(jmax.size());
						// on ajoute le cout max
						mapCoutFin.put(cle(i, j), max);
						// on ajoute le sommet qui permet d'aller de i à j
						mapInter.put(cle(i, j), jmax.get(alea));
					}
				}
			}
		}
	}
	
	public  HashMap<Integer, Float> puissance(HashMap<Integer, Float> map, HashMap<Integer, Short> mapInter, int n){
		if(n==1) return map;
		else{
			HashMap<Integer, Float> m = new HashMap<>();
			carre(puissance(map, mapInter, n/2),  m, mapInter);
			return m;
		}
	}
	
	public int meilleureRue(int inter, int pas){
		// on copie la ville pour le calcule
		HashMap<Integer, Float> villePasPrec = new HashMap<>(ville);
		HashMap<Integer, Float> villePas = new HashMap<>();
		HashMap<Integer, Short> mapInter = new HashMap<>();
		/*// on calcule les pas
		for(short i=0; i<pas-1 ;i++){
			// calcule du carré
			carre(villePasPrec, villePas, mapInter);
			// préparatin à l'itération suivante
			villePasPrec = new HashMap<>(villePas);
		}*/
		villePas = puissance(villePasPrec, mapInter, pas);
		// choix de la rue à prendre : on choisit le max dans toutes les intersections possibles
		float max = -1;
		List<Integer> jmax = new ArrayList<>();
		for(int k=0; k<nbintersections; k++){
			Float cout = villePas.get(cle(inter, k));
			if(cout==null) continue;
			System.out.println("c("+inter+","+mapInter.get(cle(inter, k))+") = "+cout );
			if(cout > max){
				max = cout;
				jmax.clear();
				jmax.add(k);
			}
			else if(cout == max){
				jmax.add(k);
			}
		}
		int alea = random.nextInt(jmax.size());
		Short prochaineIntersection = mapInter.get(cle(inter, jmax.get(alea)));
		if(prochaineIntersection==null) return -1;
		else{
			return prochaineIntersection.intValue();
		}
	}

	public void setEstVisite(int inter, int a) {
		ville.put(cle(inter, a), 0f);
	}
	
	public String print(float[][] m){
		String str = "";
		NumberFormat f = new DecimalFormat("000.00");
		for(int i=0; i<nbintersections; i++){
			str+= "   " +i + "    ";
		}
		str+='\n';
		for(int i=0; i<nbintersections; i++){
			for(int j=0; j<nbintersections; j++){
				if(m[i][j] == -1) str += "   X    ";
				else str += f.format(m[i][j]) + "  ";
			}
			str+='\n';
		}
		for(int i=0; i<nbintersections; i++){
			str+= "   " +i + "    ";
		}
		return str;
	}
	
	public String print(int[][] ma){
		String str = "";
		for(int i=0; i<nbintersections; i++){
			str+= "  " +i + "  ";
		}
		str+='\n';
		for(int i=0; i<nbintersections; i++){
			for(int j=0; j<nbintersections; j++){
				if(ma[i][j] == -1) str += "  X  ";
				else str += "  "+ ma[i][j] + "  ";
			}
			str+='\n';
		}
		return str;
	}
	
	public int cle(int a, int b){
		return a*100000 + b;
	}

	public void ajouterRue(int debut, int fin, float d) {
		ville.put(cle(debut, fin), d);
	}

	public void estVisitee(int inter, int a) {
		ville.put(cle(inter, a), 0f);
		ville.put(cle(a, inter), 0f);
	}

	public float getCout(int inter, int a) {
		Float c =  ville.get(cle(inter, a));
		return c;
	}
}
