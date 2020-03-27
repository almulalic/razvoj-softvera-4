package ba.unsa.etf.rs.tut4;
import java.util.ArrayList;

public class Artikal {
    public String sifra,naziv;
    public double cijena;

    public Artikal(String sifra, String naziv, double cijena) {
        if(sifra.isEmpty())
            throw new IllegalArgumentException("Sifra je prazna.");
        else if(naziv.isEmpty())
            throw new IllegalArgumentException("Naziv je prazan.");
        else if(cijena <= 0)
            throw new IllegalArgumentException("Cijena je negativna.");

        this.sifra = sifra;
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra.isEmpty())
            throw new IllegalArgumentException("Sifra ne smije biti prazna.");

        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.isEmpty())
            throw new IllegalArgumentException("Naziv ne smije biti prazna.");

        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena <= 0)
            throw new IllegalArgumentException("Cijena ne smije biti negativna.");

        this.cijena = cijena;
    }

    public boolean equals(Object o) {
        Artikal a = (Artikal)o;
        return this.sifra.equals(a.sifra) && this.naziv.equals(a.naziv) && Math.abs(a.cijena - this.cijena) < 0.0001;
    }

    public static void izbaciDuplikate(ArrayList<Artikal> lista) {
        for(int i=0;i<lista.size()-1;i++) {
            for(int j=i+1;j<lista.size();j++) {
                if(lista.get(i).sifra.equals(lista.get(j).sifra) && lista.get(i).naziv.equals(lista.get(j).naziv) && Math.abs(lista.get(j).cijena - lista.get(i).cijena) < 0.0001) {
                    lista.remove(j);
                    j--;
                }
            }
        }

    }

}
