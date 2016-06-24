package dennis.auto;

import dennis.Urheberrecht;

@Urheberrecht(name = "Dennis", jahr = 2016)
public class Auto {
	public String farbe;
	private int ps;
	private int raeder;

	public Auto(String farbe, int ps, int raeder) {
		this.farbe = farbe;
		this.ps = ps;
		this.raeder = raeder;
	}

	/**
	 * 
	 * @param a Zu kopierendes Auto.
	 * @return Neues Auto.
	 */
	public static Auto copyAuto(Auto a) {
		String farbe = a.farbe;
		int ps = a.ps;
		int raeder = a.raeder;
		return new Auto(farbe, ps, raeder);
	}
	
	public void fahren(){
		System.out.println("Brumm");
	}
	
	@SuppressWarnings("unused")
	private void hupen(){
		System.out.println("Meeep");
	}

	public int getPs() {
		return ps;
	}

	public int getRaeder() {
		return raeder;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public void setRaeder(int raeder) {
		this.raeder = raeder;
	}

	@Override
	public String toString() {
		return this.farbe+"es Auto mit " + this.raeder + "Raedern und "+this.ps + "PS.";
	}
}
