package instances;

import java.util.ArrayList;

public class Ville {

	ArrayList<Intersection> intersections;

	public Ville() {
		super();
		intersections = new ArrayList<Intersection>();
	}

	public ArrayList<Intersection> getIntersections() {
		return intersections;
	}

	public void setIntersections(ArrayList<Intersection> intersections) {
		this.intersections = intersections;
	}
}
