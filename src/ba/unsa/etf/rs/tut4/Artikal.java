package ba.unsa.etf.rs.tut4;
import java.util.ArrayList;

public class Artikal {
    private String sifra,naziv;
    private double cijena;

    public Artikal(String sifra, String naziv, double cijena) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public static void izbaciDuplikate(ArrayList<Artikal> lista) {
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

}
