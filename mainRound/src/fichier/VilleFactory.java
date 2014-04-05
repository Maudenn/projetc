package fichier;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import instances.Intersection;
import instances.Ville;

public class VilleFactory {

	public static Ville create(String fichier){
		try{
			InputStream ips=new FileInputStream(fichier);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			// lecture
			String ligne;
			// première ligne
			ligne=br.readLine();
			String[] s = ligne.split(" ");
			Ville v = new Ville(Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]));
			// suite
			int i = 0;
			while ((ligne=br.readLine())!=null){
				s = ligne.split(" ");
				if(s.length==2){
					v.ajouterIntersection(new Intersection(Double.parseDouble(s[0]), Double.parseDouble(s[1]), i++)); 
				}else{
					boolean b;
					if (Integer.parseInt(s[2]) == 1) b=false;
					else b = true;
					v.ajouterRue(Integer.parseInt(s[0]), Integer.parseInt(s[1]), b, Integer.parseInt(s[3]), Integer.parseInt(s[4]));
				}
			
			}
			return v;
		}	
		catch (Exception e){
			System.out.println(e.toString());
		}
		return null;
	}
}
