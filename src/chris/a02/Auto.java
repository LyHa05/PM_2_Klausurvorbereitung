package chris.a02;

import chris.a01.Copyright;

@Copyright(name = "Chris", jahr = 2017, firma = "Brexit Solutions Ltd.")
public class Auto {
    public String farbe;
    private int ps;
    private int anzahlReifen;

    public Auto(String farbe, int ps, int anzahlReifen){
        this.farbe = farbe;
        this.ps = ps;
        this.anzahlReifen = anzahlReifen;
    }

    public Auto(Auto auto){
        this(auto.getFarbe(), auto.getPs(), auto.getAnzahlReifen());
    }

    public void fahren(){}

    private void hupen(){}

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

}
