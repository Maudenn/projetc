package instances;

import java.util.ArrayList;
import java.util.List;

public class Chemin{

	List<Rue> r = new ArrayList<>();
	double cout = 0;
	
	public List<Rue> getRues(){
		return r;
	}
	
	public Rue getRue(int i){
		return r.get(i);
	}
	
	public void addRueDebut(Rue rue){
		r.add(0, rue);
	}

	public int nb() {
		return r.size();
	}

	@Override
	public String toString() {
		return "Chemin [r=" + r + "]";
	}
}
