package image;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Parser {

	public static void main(String[] args){
		try{
			InputStream ips=new FileInputStream(args[0]); 
			boolean[][] tab = parse(ips);
			List<String> commandes = new ArrayList<>();
			creerFichier("resultat.txt", creerCommandes(tab));
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static boolean[][] parse(InputStream in) throws IOException{
		InputStreamReader ipsr=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(ipsr);
		String ligne = br.readLine();
		String[] s = ligne.split(" ");
		int hauteur = Integer.parseInt(s[0]);
		int largeur = Integer.parseInt(s[1]);
		boolean tab[][] = new boolean[hauteur][largeur];
		int i = 0;
		while ((ligne=br.readLine())!=null){
			for(int j=0; j<largeur; j++){
				if(ligne.charAt(j)=='#') tab[i][j] = true;
				else tab[i][j] = false;
			}
			i++;
		}
		br.close(); 
		return tab;
	}
	
	public static void creerFichier(String nom, List<String> commandes){
		try {
			FileWriter fw = new FileWriter (nom);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw);
			fichierSortie.println(commandes.size());
			for(String s : commandes){
				fichierSortie.println(s);
			}
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}	
	}
	
	public static List<String> creerCommandes (boolean[][] tab){
		List<String> c = new ArrayList<>();
		for(int i=0; i<tab.length; i++){
			for(int j=0; j<tab[0].length; j++){
				if(tab[i][j]) c.add("PAINTSQ "+i+" "+j+" "+ " 0");
			}
		}
		return c;
	}
}
