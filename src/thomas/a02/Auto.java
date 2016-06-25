package thomas.a02;

import thomas.a01.Urheberrecht;

@Urheberrecht(name = "Thomas", jahr = 2016)
public class Auto {
	
	public String farbe;
	private int ps;
	private int anzahlReifen;
	
	public Auto(String farbe,int ps, int anzahlReifen){
		this.farbe = farbe;
		this.ps = ps;
		this.anzahlReifen = anzahlReifen;
	}
	
	public Auto(Auto auto){
		this.farbe = auto.farbe;
		this.ps = auto.ps;
		this.anzahlReifen = auto.anzahlReifen;
		
	}
	
	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public int getAnzahlReifen() {
		return anzahlReifen;
	}

	public void setAnzahlReifen(int anzahlReifen) {
		this.anzahlReifen = anzahlReifen;
	}

	void fahren(){
		System.out.println("Auto ist fährt");
	}

	@SuppressWarnings("unused")
	private void hupen(){
		System.out.println("Auto hupt");
	}
	
	@Override
	public String toString(){
		return "Auto: "+ farbe +" " + " mit " + ps + "PS und "+ anzahlReifen + "Reifen" ;
	} 
	

}
