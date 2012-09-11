
public class Armure extends Objet {
	private String[] zones;
	private int pa;
	
	public Armure(String n, int e, int p, String[] z, int pa){
		super(n, e, p);
		this.zones = z;
		this.pa = pa;
	}

	public String[] getZones() {
		return zones;
	}

	public void setZones(String[] zones) {
		this.zones = zones;
	}

	public int getPa() {
		return pa;
	}

	public void setPa(int pa) {
		this.pa = pa;
	}
	
	@Override
	public String toString(){
		String s = super.toString() +'\t'+this.pa;
		
		for(int i = 0; i < this.zones.length;i++){
			s+='\t'+this.zones[i];
			if(i < this.zones.length-1)
				s+=", ";
		}
		
		return s;
	}
}
