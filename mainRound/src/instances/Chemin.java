package instances;

import java.util.ArrayList;
import java.util.List;

public class Chemin implements Comparable{

	List<Rue> r = new ArrayList<>();
	double cout = 0;
	
	public List<Rue> getRues(){
		return r;
	}
	
	public Rue getRue(int i){
		return r.get(i);
	}
	
	public void addRueDebut(Rue rue){
		cout += rue.getCout();
		r.add(0, rue);
	}

	public int nb() {
		return r.size();
	}
	
	public double getCout(){
		return cout;
	}

	@Override
	public String toString() {
		return "Chemin [r=" + r + "]";
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Chemin){
			if(cout > ((Chemin)o).getCout()) return 1;
			else if(cout == ((Chemin)o).getCout()) return 0;
			else return -1;
		}
		return -1;
	}
}
