
public class test {
	public static void main(String[] args){				
		Monde m = new Monde();
		m.chargerMonde();
		
/*		Personnage p = new Personnage();
		p.genererAleatoire(m.getLiRace());*/
		
		for(int i = 0; i<m.getLiCar().size();i++)
			System.out.println(m.getLiCar().get(i));
	}
}
