import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.io.File;

public class Monde {
	private LinkedList<Competence> liComp;
	private LinkedList<Talent> liTal;
	private LinkedList<Objet> liObj;
	private LinkedList<Carriere> liCar;
	private LinkedList<Race> liRace;
	private LinkedList<Arme> liArme;
	private LinkedList<Armure> liArmure;
	
	public Monde(LinkedList<Competence> liComp, LinkedList<Talent> liTal, LinkedList<Race> liRace, 
			LinkedList<Objet> liObj, LinkedList<Arme> liArme, LinkedList<Armure> liArmure){
		this.liComp = liComp;
		this.liTal = liTal;
		this.liRace = liRace;
		this.liObj = liObj;
		this.liArme = liArme;
		this.liArmure = liArmure;
	}
	
	public Monde(){
		this.liComp = new LinkedList<Competence>();
		this.liTal = new LinkedList<Talent>();
		this.liRace = new LinkedList<Race>();
		this.liObj = new LinkedList<Objet>();
		this.liArme = new LinkedList<Arme>();
		this.liArmure = new LinkedList<Armure>();
	}

	public LinkedList<Arme> getLiArme() {
		return liArme;
	}

	public void setLiArme(LinkedList<Arme> liArme) {
		this.liArme = liArme;
	}

	public LinkedList<Armure> getLiArmure() {
		return liArmure;
	}

	public void setLiArmure(LinkedList<Armure> liArmure) {
		this.liArmure = liArmure;
	}

	public LinkedList<Competence> getLiComp() {
		return liComp;
	}

	public void setLiComp(LinkedList<Competence> liComp) {
		this.liComp = liComp;
	}

	public LinkedList<Talent> getLiTal() {
		return liTal;
	}

	public void setLiTal(LinkedList<Talent> liTal) {
		this.liTal = liTal;
	}

	public LinkedList<Carriere> getLiCar() {
		return liCar;
	}

	public void setLiCar(LinkedList<Carriere> liCar) {
		this.liCar = liCar;
	}

	public LinkedList<Race> getLiRace() {
		return liRace;
	}

	public void setLiRace(LinkedList<Race> liRace) {
		this.liRace = liRace;
	}
	
	public LinkedList<Objet> getLiObj(){
		return this.liObj;
	}
	
	public void setLiObj(LinkedList<Objet> liObj){
		this.liObj = liObj;
	}
	
	public void chargerComp(){
		LinkedList<Competence> liC = new LinkedList<Competence>();
		String s = new String();
		int n;
		try {
			BufferedReader br = new BufferedReader(new FileReader("./Competences"));
			while(br.ready()){
				s = br.readLine();
				n = s.lastIndexOf(" ");
				liC.add(new Competence(s.substring(0, n),s.substring(n+1)));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		this.liComp = liC;
	}
	
	public void chargerTal(){
		LinkedList<Talent> liT = new LinkedList<Talent>();
		String s = new String();
		int n;
		try {
			BufferedReader br = new BufferedReader(new FileReader("./Talents"));
			while(br.ready()){
				s = br.readLine();
				n = s.indexOf(":");
				liT.add(new Talent(s.substring(0, n),s.substring(n+1)));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		this.liTal = liT;
	}
	
	public void chargerObjets(){
		LinkedList<Objet> liO = new LinkedList<Objet>();
		String s = new String();
		int n, n1;
		try {
			BufferedReader br = new BufferedReader(new FileReader("./Objets"));
			while(br.ready()){
				s = br.readLine();
				n = s.indexOf(":");
				n1 = s.lastIndexOf(":");
				liO.add(new Objet(s.substring(0,n),stringToInt(s.substring(n+1, n1)), stringToInt(s.substring(n1+1))));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		this.liObj = liO;
	}
	
	public void  chargerArmes(){
		LinkedList<Objet> liA = new LinkedList<Objet>();
		String s;
		String[] att, s1;
		try {
			BufferedReader br = new BufferedReader(new FileReader("./Armes"));
			while(br.ready()){
				s = br.readLine();
				att=s.substring(s.lastIndexOf(":")+1).split(",");
				s1=s.split(":");
				
				liA.add(new Arme(s1[0], stringToInt(s1[1]), stringToInt(s1[2]), s1[3], s1[4], stringToInt(s1[5]), stringToInt(s1[6]), stringToInt(s1[7]), att));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		this.liObj.addAll(liA);
	}
	
	public void  chargerArmures(){
		LinkedList<Objet> liA = new LinkedList<Objet>();
		String s;
		String[] zones, s1;
		try {
			BufferedReader br = new BufferedReader(new FileReader("./Armures"));
			while(br.ready()){
				s = br.readLine();
				zones=s.substring(s.lastIndexOf(":")+1).split(",");
				s1=s.split(":");
				
				liA.add(new Armure(s1[0], stringToInt(s1[1]), stringToInt(s1[2]), zones, stringToInt(s1[3])));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		this.liObj.addAll(liA);
	}
	
	public void chargerRaces(){
		LinkedList<Race> liR = new LinkedList<Race>();
		String[] s, t;
		int[] modif, bless, dest, poids, ages;
		int n;
		String[] yeux, cheveux, nomsF, nomsM;
		Competence[] comp2;
		Competence[][] comp;
		Talent [] tal2;
		Talent[][] tal;
		BufferedReader br;
		
		File dir = new File("./Races");
		File[] files = dir.listFiles();
		
		for(int i = 0;i<files.length;i++){
			try{
				br = new BufferedReader(new FileReader("./Races/"+files[i].getName()));
				s = br.readLine().split(",");
				modif = new int[s.length];
				for(int c = 0;c<s.length;c++){
					modif[c] = stringToInt(s[c]);
				}
				s = br.readLine().split(",");
				bless = new int[s.length];
				for(int c = 0;c<s.length;c++){
					bless[c] = stringToInt(s[c]);
				}
				s = br.readLine().split(",");
				dest = new int[s.length];
				for(int c = 0;c<s.length;c++){
					dest[c] = stringToInt(s[c]);
				}
				s = br.readLine().split(",");
				nomsF = s;
				s = br.readLine().split(",");
				nomsM = s;
				s = br.readLine().split(",");
				cheveux = s;
				s = br.readLine().split(",");
				yeux = s;
				s = br.readLine().split(",");
				poids = new int[s.length];
				for(int c = 0;c<s.length;c++){
					poids[c] = stringToInt(s[c]);
				}
				s = br.readLine().split(",");
				ages = new int[s.length];
				for(int c = 0;c<s.length;c++){
					ages[c] = stringToInt(s[c]);
				}
				
				s= br.readLine().split(",");
				comp = new Competence[s.length][];
				for(int c = 0;c<s.length;c++){
					t = s[c].split(":");
					comp2 = new Competence[t.length];
					for(int d = 0;d<t.length;d++){
						n=placeCompetenceListe(t[d]);
						if(n != -1)
							comp2[d] = liComp.get(n);
					}
					comp[c]=comp2;
				}
				
				s= br.readLine().split(",");
				tal = new Talent[s.length][];
				for(int c = 0;c<s.length;c++){
					t = s[c].split(":");
					tal2 = new Talent[t.length];
					for(int d=0;d<t.length;d++){
						n=placeTalentListe(t[d]);
						if(n != -1)	
							tal2[d]=liTal.get(n);
					}
						tal[c] = tal2;
				}
				liR.add(new Race(modif, bless, dest, yeux, cheveux, poids, ages, nomsF, nomsM, comp, tal, files[i].getName()));
				
				br.close();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
		}
		this.liRace = liR;
	}
	
	public void chargerCarrieres(){
		LinkedList<Carriere> liCar = new LinkedList<Carriere>();
		String[] s,t;
		int[] modif;
		int n;
		Competence[][] comp;
		Competence[] comp2;
		Talent[][] tal;
		Talent[] tal2;
		Objet[] obj;
		File dir = new File("./Carrieres");
		File[] files = dir.listFiles();
		BufferedReader br = null;
		
		for(int i = 0; i < files.length; i++){
			try {
				br = new BufferedReader(new FileReader("./Carrieres/" +files[i].getName()));
				
				s = br.readLine().split(",");
				modif = new int[s.length];
				for(int j = 0; j < s.length; j++){
					modif[j] = stringToInt(s[j]);
				}
				
				s = br.readLine().split(",");
				comp = new Competence[s.length][];
				for(int c = 0; c < s.length; c++){
					t = s[c].split(":");
					comp2 = new Competence[t.length];
					for(int d = 0; d < t.length;d++){
						n = placeCompetenceListe(t[d]);
						if(n != -1){
							comp2[d] = liComp.get(n);
						}
					}
					comp[c] = comp2;
				}
				
				s = br.readLine().split(",");
				tal = new Talent[s.length][];
				for(int c = 0; c < s.length; c++){
					t = s[c].split(":");
					tal2 = new Talent[t.length];
					for(int d = 0; d < t.length;d++){
						n = placeTalentListe(t[d]);
						if(n != -1){
							tal2[d] = liTal.get(n);
						}
					}
					tal[c] = tal2;
				}
				
				s = br.readLine().split(",");
				obj = new Objet[s.length];
				for(int c=0;c<s.length;c++){
					n = placeObjetListe(s[c]);
					if(n != -1){
						obj[c] = liObj.get(n);
					}
				}
				
				liCar.add(new Carriere(new Caracteristique(modif), comp, tal, obj, files[i].getName()));
				
				br.close();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
		}
		
		this.liCar = liCar;
	}
	
	public int stringToInt(String s){
		int res = 0;
		int length = s.length();
		
		for(int i = 0; i<length;i++){
			res += ((int)s.charAt(i)-48)*Math.pow(10,length-i-1);
		}
		
		return res;
	}
	
	public int placeCompetenceListe(String nomComp){
		for(int i =0; i<this.liComp.size();i++){
			if(nomComp.equals(this.liComp.get(i).getNom()))
				return i;
		}
		
		return -1;
	}
	
	public int placeTalentListe(String nomTal){
		for(int i =0; i<this.liTal.size();i++){
			if(nomTal.equals(this.liTal.get(i).getNom()))
				return i;
		}
		
		return -1;
	}
	
	public int placeObjetListe(String nomObj){
		for(int i =0; i<this.liObj.size();i++){
			if(nomObj.equals(this.liObj.get(i).getNom()))
				return i;
		}
		
		return -1;
	}
	
	public int placeCarriereListe(String nomCar){
		for(int i =0; i<this.liCar.size();i++){
			if(nomCar.equals(this.liCar.get(i).getNom()))
				return i;
		}
		
		return -1;
	}
	
	public void chargerMonde(){
		this.chargerComp();
		this.chargerTal();
		this.chargerObjets();
		this.chargerArmes();
		this.chargerArmures();
		this.chargerRaces();
		this.chargerCarrieres();
	}
}
