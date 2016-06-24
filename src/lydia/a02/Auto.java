package lydia.a02;

import lydia.a01.Urheberrecht;

/** 
 * @author Lydia Pflug
 * @datum 24.06.2016
 * Klasse, die ein Auto beschreibt.
 * */

@Urheberrecht(urheber = "ich", jahr = 2016)
public class Auto {

	public String farbe;
	
	private int ps;
	
	private int anzahlReifen;
	
	/**Konstruktor*/
	public Auto(String farbe, int ps, int aReifen){
		this.farbe = farbe;
		this.ps = ps;
		this.anzahlReifen = aReifen;
	}
	
	/**Copy-Konstruktor*/
	public Auto(Auto autoObjekt) {
		this.farbe = autoObjekt.getFarbe();
		this.ps = autoObjekt.getPS();
		this.anzahlReifen = autoObjekt.getAnzahlReifen();
	}

	/**Getter-Methode*/
	private String getFarbe() {
		return farbe;
	}

	/**Setter-Methode*/
	@SuppressWarnings("unused")
	private void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	/**Getter-Methode*/
	private int getPS() {
		return ps;
	}

	/**Setter-Methode*/
	@SuppressWarnings("unused")
	private void setPS(int ps) {
		this.ps = ps;
	}

	/**Getter-Methode*/
	private int getAnzahlReifen() {
		return anzahlReifen;
	}

	/**Setter-Methode*/
	@SuppressWarnings("unused")
	private void setAnzahlReifen(int anzahlReifen) {
		this.anzahlReifen = anzahlReifen;
	}

	public void fahren() {
		System.out.println("Brumm!!!!!");
	}
	
	public void hupen() {
		System.out.println("Mööööp!");
	}
	
	/**Ueberschriebene toString Methode*/
	@Override
	public String toString() {
		return "Ein Auto in " + farbe + " mit " + ps + " PS und " + anzahlReifen + "Reifen.";
	}
	
	
	
}
