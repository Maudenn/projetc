package instances;

public class Rue {

	Intersection debut;
	Intersection fin;
	int duree;
	int longueur;
	
	public Rue(Intersection debut, Intersection fin, int duree, int longueur) {
		super();
		this.debut = debut;
		this.fin = fin;
		this.duree = duree;
		this.longueur = longueur;
	}	
}
