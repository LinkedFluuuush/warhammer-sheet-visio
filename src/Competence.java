public class Competence {
	private String nom;
	private String carac;
	
	
	public Competence(String nom, String carac){
		this.nom = nom;
		this.carac = carac;
	}
	
	@Override
	public String toString(){
		return this.nom +" " +this.carac;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCarac() {
		return carac;
	}

	public void setCarac(String carac) {
		this.carac = carac;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this)
			return true;
		
		if(o.getClass() == this.getClass()){
			Competence c = (Competence) o;
			if(c.getNom().equals(this.getNom()) && c.getCarac().equals(this.getCarac()))
				return true;
		}
		
		return false;
	}
}