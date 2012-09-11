
public class Arme extends Objet {
	private String groupe;
	private String degats;
	private int porteeCourte;
	private int porteeLongue;
	private int rechargement;
	private String[] attributs;
	
	public Arme(String n, int e, int p, String g, String d, int pC, int pL, int r, String[] a){
		super(n, e, p);
		this.groupe = g;
		this.degats = d;
		this.porteeCourte = pC;
		this.porteeLongue = pL;
		this.rechargement = r;
		this.attributs = a;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getDegats() {
		return degats;
	}

	public void setDegats(String degats) {
		this.degats = degats;
	}

	public int getPorteeCourte() {
		return porteeCourte;
	}

	public void setPorteeCourte(int porteeCourte) {
		this.porteeCourte = porteeCourte;
	}

	public int getPorteeLongue() {
		return porteeLongue;
	}

	public void setPorteeLongue(int porteeLongue) {
		this.porteeLongue = porteeLongue;
	}

	public int getRechargement() {
		return rechargement;
	}

	public void setRechargement(int rechargement) {
		this.rechargement = rechargement;
	}

	public String[] getAttributs() {
		return attributs;
	}

	public void setAttributs(String[] attributs) {
		this.attributs = attributs;
	}
	
	@Override
	public String toString(){
		String s;
		s = super.toString()+'\t'+this.groupe+'\t'+this.degats+'\t'+this.porteeCourte+'/'+this.porteeLongue
				+'\t'+this.rechargement+'\t';
		
		for(int i = 0; i < this.attributs.length; i++){
			s+=this.attributs[i];
			if(i < this.attributs.length-1)
				s+=", ";
		}
		return s;
	}
}
