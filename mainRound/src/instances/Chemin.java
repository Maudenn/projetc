package instances;

import java.util.ArrayList;
import java.util.List;

public class Chemin {

	List<Rue> r = new ArrayList<>();
	
	public List<Rue> getRues(){
		return r;
	}
	
	public Rue getRue(int i){
		return r.get(i);
	}
	
	public void addRue(Rue rue){
		r.add(rue);
	}
	
	public void addRue(int i, Rue rue){
		r.add(i, rue);
	}

	public int nb() {
		return r.size();
	}

	@Override
	public String toString() {
		return "Chemin [r=" + r + "]";
	}
	
	
}
