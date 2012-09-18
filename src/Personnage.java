import java.util.LinkedList;
import java.util.Random;

public class Personnage {
	private String nom;
	private boolean homme;
	
	private Race race;
	private Carriere carriere;
	
	private Caracteristique carac;
	private LinkedList<Arme> armes;
	private LinkedList<Armure> armures;
	private LinkedList<Competence> comp;
	private LinkedList<Talent> talents;
	
	private LinkedList<Objet> equip;
	
	private int couronnes;
	private int pistoles;
	private int sous;

	//Constructeur
	
	public Personnage(String nom, boolean homme, Race race, Carriere carriere,
			Caracteristique carac, LinkedList<Arme> armes, LinkedList<Armure> armures,
			LinkedList<Competence> comp, LinkedList<Talent> talents,
			LinkedList<Objet> equip, int couronnes, int pistoles, int sous) {
		super();
		this.nom = nom;
		this.homme = homme;
		this.race = race;
		this.carriere = carriere;
		this.carac = carac;
		this.armes = armes;
		this.armures = armures;
		this.comp = comp;
		this.talents = talents;
		this.equip = equip;
		this.couronnes = couronnes;
		this.pistoles = pistoles;
		this.sous = sous;
	}
	
	public Personnage(){
		this.nom = "aAa";
		this.homme = true;
		this.race = null;
		this.carriere = null;
		this.carac = new Caracteristique();
		this.armes = new LinkedList<Arme>();
		this.armures = new LinkedList<Armure>();
		this.comp = new LinkedList<Competence>();
		this.talents = new LinkedList<Talent>();
		this.equip = new LinkedList<Objet>();
		this.couronnes = 0;
		this.pistoles = 0;
		this.sous = 0;
	}
	
	public Personnage(Race race, Carriere c, boolean homme){
		Random r = new Random();
		this.race = race;
		this.homme = homme;
		this.carriere = c;
		
		if(this.homme)
			this.nom = race.getNomsM()[r.nextInt(20)];
		else
			this.nom = race.getNomsF()[r.nextInt(20)];
		
		this.carac = new Caracteristique();
		carac.genererCarac(race);
		carac.ajouterCar(c);
	}
	
	//Getters et Setters
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean isHomme() {
		return homme;
	}
	
	public void setHomme(boolean homme) {
		this.homme = homme;
	}
	
	public Race getRace() {
		return race;
	}
	
	public void setRace(Race race) {
		this.race = race;
	}
	
	public Carriere getCarriere() {
		return carriere;
	}
	
	public void setCarriere(Carriere carriere) {
		this.carriere = carriere;
	}
	
	public Caracteristique getCaracBase() {
		return carac;
	}
	
	public void setCaracBase(Caracteristique carac) {
		this.carac = carac;
	}

	public LinkedList<Arme> getArmes() {
		return armes;
	}
	
	public void setArmes(LinkedList<Arme> armes) {
		this.armes = armes;
	}
	
	public LinkedList<Armure> getArmures() {
		return armures;
	}
	
	public void setArmures(LinkedList<Armure> armures) {
		this.armures = armures;
	}
	
	public LinkedList<Competence> getComp() {
		return comp;
	}
	
	public void setComp(LinkedList<Competence> comp) {
		this.comp = comp;
	}
	
	public LinkedList<Talent> getTalents() {
		return talents;
	}
	
	public void setTalents(LinkedList<Talent> talents) {
		this.talents = talents;
	}
	
	public LinkedList<Objet> getEquip() {
		return equip;
	}
	
	public void setEquip(LinkedList<Objet> equip) {
		this.equip = equip;
	}
	
	public int getCouronnes() {
		return couronnes;
	}
	
	public void setCouronnes(int couronnes) {
		this.couronnes = couronnes;
	}
	
	public int getPistoles() {
		return pistoles;
	}
	
	public void setPistoles(int pistoles) {
		this.pistoles = pistoles;
	}
	
	public int getSous() {
		return sous;
	}
	
	public void setSous(int sous) {
		this.sous = sous;
	}
	
	// Methodes
	
	public void genererAleatoire(LinkedList<Race> liRace){
		Random r = new Random();

		this.race = liRace.get(r.nextInt(liRace.size()));
		this.homme = r.nextBoolean();
		
		if(homme){
			this.nom = this.getRace().getNomsM()[r.nextInt(20)];
		}
		else{
			this.nom = this.getRace().getNomsF()[r.nextInt(20)];
		}
		
		this.carac.genererCarac(this.race);
		
		
	}
	
	@Override
	public String toString(){
		return("Nom : " +this.nom +"\nRace : " +this.race 
				+"\nCarriere : " +this.carriere 
				+"\nSexe : " +(homme?"Masculin":"Féminin"))
				+"\n\n"
				+this.carac;
	}
}