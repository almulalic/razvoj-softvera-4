package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Racun {
    private ArrayList<Stavka> racun = new ArrayList<>();
    private static DecimalFormat df = new DecimalFormat("0.00");

    public class Stavka {
        private String sifra;
        private int kolicina;
        private double ukupnaCijena;

        public Stavka(String sifra, int kolicina, double ukupnaCijena) {
           this.sifra = sifra;
           this.kolicina = kolicina;
           this.ukupnaCijena = ukupnaCijena;
        }
    }

    public void dodajStavku(Artikal ar,int kolicina) {
        this.racun.add(new Stavka(ar.sifra,kolicina,(ar.cijena*kolicina)));
    }

    public double ukupanIznos() {
        double suma = 0;

        for(int i=0;i<this.racun.size();i++) {
            suma+=this.racun.get(i).ukupnaCijena;
        }

        return suma;
    }

    public String izradiRacun(){

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<this.racun.size();i++) {
            sb.append(this.racun.get(i).sifra + "\t" + this.racun.get(i).kolicina + "\t" + df.format(this.racun.get(i).ukupnaCijena) + "\n");
        }

        sb.append("UKUPNO" + "\t" + "\t" + df.format(ukupanIznos()));

        return sb.toString();
    }

}
