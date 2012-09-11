
public class Talent {
	private String nom;
	private String description;
	
	public Talent(String n, String d){
		this.nom = n;
		this.description = d;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this)
			return true;
		if(o.getClass() == this.getClass()){
			Talent c = (Talent) o;
			if(c.getNom().equals(this.getNom()) && c.getDescription().equals(this.getDescription()))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return this.nom;
	}
}
