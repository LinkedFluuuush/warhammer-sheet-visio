import java.util.Random;


public class Caracteristique {
	private int cc, ct, f, e, ag, intel, fm, soc, a, b, bf, be, m, mag, pf, pd;
	
	public Caracteristique(int cc, int ct, int f, int e, int ag, int intel,
			int fm, int soc, int a, int b, int bf, int be, int m, int mag,
			int pf, int pd) {
		super();
		this.cc = cc;
		this.ct = ct;
		this.f = f;
		this.e = e;
		this.ag = ag;
		this.intel = intel;
		this.fm = fm;
		this.soc = soc;
		this.a = a;
		this.b = b;
		this.bf = bf;
		this.be = be;
		this.m = m;
		this.mag = mag;
		this.pf = pf;
		this.pd = pd;
	}
	
	public Caracteristique(int[] modif){
		this.cc = modif[0];
		this.ct = modif[1];
		this.f = modif[2];
		this.e = modif[3];
		this.ag = modif[4];
		this.intel = modif[5];
		this.fm = modif[6];
		this.soc = modif[7];
		this.a = modif[8];
		this.b = modif[9];
		this.m = modif[10];
		this.mag = modif[11];
		this.bf = (int)(f/10);
		this.be = (int)(e/10);
		this.pf = 0;
		this.pd = 0;
	}
	
	public Caracteristique(){
		super();
	}
	
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getCt() {
		return ct;
	}
	public void setCt(int ct) {
		this.ct = ct;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	public int getE() {
		return e;
	}
	public void setE(int e) {
		this.e = e;
	}
	public int getAg() {
		return ag;
	}
	public void setAg(int ag) {
		this.ag = ag;
	}
	public int getIntel() {
		return intel;
	}
	public void setIntel(int intel) {
		this.intel = intel;
	}
	public int getFm() {
		return fm;
	}
	public void setFm(int fm) {
		this.fm = fm;
	}
	public int getSoc() {
		return soc;
	}
	public void setSoc(int soc) {
		this.soc = soc;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getBf() {
		return bf;
	}
	public void setBf(int bf) {
		this.bf = bf;
	}
	public int getBe() {
		return be;
	}
	public void setBe(int be) {
		this.be = be;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getMag() {
		return mag;
	}
	public void setMag(int mag) {
		this.mag = mag;
	}
	public int getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	public int getPd() {
		return pd;
	}
	public void setPd(int pd) {
		this.pd = pd;
	}
	
	
	
	public Caracteristique genererCarac(Race race){
		Random r = new Random();
		int i;

		int[] mod = race.getModif();
		int[] ble = race.getBless();
		int[] des = race.getDest();
		
		this.cc = mod[0]+r.nextInt(10)+r.nextInt(10)+2;
		this.ct = mod[1]+r.nextInt(10)+r.nextInt(10)+2;
		this.f = mod[2]+r.nextInt(10)+r.nextInt(10)+2;
		this.e = mod[3]+r.nextInt(10)+r.nextInt(10)+2;
		this.ag = mod[4]+r.nextInt(10)+r.nextInt(10)+2;
		this.intel = mod[5]+r.nextInt(10)+r.nextInt(10)+2;
		this.fm = mod[6]+r.nextInt(10)+r.nextInt(10)+2;
		this.soc = mod[7]+r.nextInt(10)+r.nextInt(10)+2;
		
		this.a = 1;
		i = r.nextInt(10)+1;
		if(i < 3)
			this.b = ble[0];
		else if(i < 6)
			this.b = ble[1];
		else if(i < 9)
			this.b = ble[2];
		else
			this.b = ble[3];
		
		this.bf = (int)(this.f/10);
		this.be = (int)(this.e/10);
		
		this.m = mod[8];
		
		this.mag = 0;
		this.pf = 0;
		
		i = r.nextInt(10)+1;
		if(i < 4)
			this.pd = des[0];
		else if(i < 7)
			this.pd = des[1];
		else
			this.pd = des[2];
		
		return this;
	}
	
	Caracteristique ajouterCar(Carriere car){
		Caracteristique carac = car.getCarac();
		
		this.cc += carac.getCc();
		this.ct += carac.getCt();
		this.f += carac.getF();
		this.e += carac.getE();
		this.ag += carac.getAg();
		this.intel += carac.getIntel();
		this.fm += carac.getFm();
		this.soc += carac.getSoc();
		
		this.a += carac.getA();
		this.b += carac.getB();
		this.bf = (int)this.f/10;
		this.be = (int)this.e/10;
		this.m += carac.getM();
		this.mag += carac.getMag();
		this.pf = 0;
		this.pd = 0;
		
		return this;
	}

	@Override
	public String toString() {
		return "Caracteristiques" 
				+"\nCC\tCT\tF\tE\tAg\tInt\tFM\tSoc"
				+"\n"+cc+"\t"+ct+"\t"+f+"\t"+e+"\t"+ag+"\t"+intel+"\t"+fm+"\t"+soc
				+"\n\nA\tB\tBF\tBE\tM\tMag\tPF\tPD"
				+"\n"+a+"\t"+b+"\t"+bf+"\t"+be+"\t"+m+"\t"+mag+"\t"+pf+"\t"+pd;
	}
}
