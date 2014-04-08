package instances;

public class Rue {

	@Override
	public String toString() {
		return "Rue["+debut.getNumero()+","+fin.getNumero()+"]";
	}

	Intersection debut;
	Intersection fin;
	int duree;
	int longueur;
	boolean estVisite = false;
	double cout = -1;
	
	public Rue(Intersection debut, Intersection fin, int duree, int longueur) {
		super();
		this.debut = debut;
		this.fin = fin;
		this.duree = duree;
		this.longueur = longueur;
		cout = (1.0*getLongueur()) / getDuree();
	}

	public Intersection getDebut() {
		return debut;
	}

	public void setDebut(Intersection debut) {
		this.debut = debut;
	}

	public Intersection getFin() {
		return fin;
	}

	public void setFin(Intersection fin) {
		this.fin = fin;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getLongueur() {
		return longueur;
	}
	
	public double getCout() {
		if(!estVisite) return cout;
		else return 0;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public boolean isEstVisite() {
		return estVisite;
	}

	public void setEstVisite(boolean estVisite) {
		this.estVisite = estVisite;
	}
	
}
