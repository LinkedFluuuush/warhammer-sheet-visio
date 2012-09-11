
public class Race {
	private int[] modif;
	private int[] bless;
	private int[] dest;
	
	private String[] yeux;
	private String[] cheveux;
	private int[] poids;
	private int[] age;
	private String[] nomsF;
	private String[] nomsM;

	private Competence[][] comp;
	private Talent[][] tal;
	
	private String nomRace;
	
	public Race(int[] modif, int[] bless, int[] dest, String[] yeux,
			String[] cheveux, int[] poids, int[] age,
			String[] nomsF, String[] nomsM, Competence[][] comp, Talent[][] tal, String nomRace) {
		super();
		this.modif = modif;
		this.bless = bless;
		this.dest = dest;
		this.yeux = yeux;
		this.cheveux = cheveux;
		this.poids = poids;
		this.age = age;
		this.nomsF = nomsF;
		this.nomsM = nomsM;
		this.nomRace = nomRace;
		this.comp = comp;
		this.tal = tal;
	}

	public Competence[][] getComp() {
		return comp;
	}

	public void setComp(Competence[][] comp) {
		this.comp = comp;
	}

	public Talent[][] getTal() {
		return tal;
	}

	public void setTal(Talent[][] tal) {
		this.tal = tal;
	}

	public int[] getModif() {
		return modif;
	}

	public void setModif(int[] modif) {
		this.modif = modif;
	}

	public int[] getBless() {
		return bless;
	}

	public void setBless(int[] bless) {
		this.bless = bless;
	}

	public int[] getDest() {
		return dest;
	}

	public void setDest(int[] dest) {
		this.dest = dest;
	}

	public String getNomRace() {
		return nomRace;
	}

	public void setNomRace(String nom) {
		this.nomRace = nom;
	}
	
	public String[] getYeux() {
		return yeux;
	}

	public void setYeux(String[] yeux) {
		this.yeux = yeux;
	}

	public String[] getCheveux() {
		return cheveux;
	}

	public void setCheveux(String[] cheveux) {
		this.cheveux = cheveux;
	}

	public int[] getPoids() {
		return poids;
	}

	public void setPoids(int[] poids) {
		this.poids = poids;
	}

	public int[] getAge() {
		return age;
	}

	public void setAge(int[] age) {
		this.age = age;
	}

	public String[] getNomsF() {
		return nomsF;
	}

	public void setNomsF(String[] nomsF) {
		this.nomsF = nomsF;
	}

	public String[] getNomsM() {
		return nomsM;
	}

	public void setNomsM(String[] nomsM) {
		this.nomsM = nomsM;
	}

	@Override
	public String toString(){
		String s = this.nomRace +'\n';
		for(int i = 0;i<comp.length;i++){
			for(int j = 0;j<comp[i].length;j++){
				s+=comp[i][j];
				if(j<comp[i].length-1)
					s+=" ou ";
				else if(i<comp.length-1)
					s+=", ";
				else
					s+='.';
			}
		}
		s+='\n';
		for(int i = 0;i<tal.length;i++){
			for(int j = 0;j<tal[i].length;j++){
				s+=tal[i][j];
				if(j<tal[i].length-1)
					s+=" ou ";
				else if(i<tal.length-1)
					s+=", ";
				else
					s+='.';
			}
		}
		return s;
	}
}
