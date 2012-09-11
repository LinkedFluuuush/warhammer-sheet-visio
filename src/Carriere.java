
public class Carriere {
	private String nom;
	private Caracteristique carac;
	private Competence[][] comp;
	private Talent[][] tal;
	private Objet[] obj;
	
	public  Carriere(Caracteristique carac, Competence[][] comp, Talent[][] tal, Objet[] obj, String nom){
		this.carac = carac;
		this.comp = comp;
		this.tal = tal;
		this.nom = nom;
		this.obj = obj;
	}

	public Caracteristique getCarac() {
		return carac;
	}

	public void setCarac(Caracteristique carac) {
		this.carac = carac;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Objet[] getObj() {
		return obj;
	}

	public void setObj(Objet[] obj) {
		this.obj = obj;
	}

	public String toString(){
		String s = this.nom +'\n';
		s += carac.toString() +'\n';
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
		s+='\n';
		for(int i = 0;i<obj.length;i++){
			s+=obj[i];
			if(i < obj.length -1){
				s += ", ";
			}
			else
				s += '.';
		}
		return s;
	}
}
