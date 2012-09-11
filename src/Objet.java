
public class Objet {
	private String nom;
	private int enc;
	private int prix;
	
	public Objet(String n, int e, int p){
		this.nom = n;
		this.enc = e;
		this.prix = p;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEnc() {
		return enc;
	}

	public void setEnc(int enc) {
		this.enc = enc;
	}
	
	@Override
	public String toString(){
		return '\n'+this.nom +'\t'+this.enc+'\t'+prixDecompose(this.prix);
	}
	
	public String prixDecompose(int prix){
		int co, pa, sc, temp;
		co = (int)prix/240;
		temp = (int)prix%240;
		pa = (int)temp/12;
		sc = temp%12;
		
		return co +" co, "+pa+" pa, "+sc+" sc";
	}
}
