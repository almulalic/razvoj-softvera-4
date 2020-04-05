package ba.unsa.etf.rs.tut4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacunTest {

    // Testovi tutorial 3

    @Test
    void test1() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        r.dodajStavku(new Artikal("JAJ", "Jaje", 0.25), 5);
        assertEquals(3.45, r.ukupanIznos());
    }

    @Test
    void testPrazno() {
        Racun r = new Racun();
        assertEquals(0, r.ukupanIznos());
    }

    // Testovi tutorial 4

    @Test
    void testDodajStavku() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("CAJ","Čaj",1.50),5);
    }

    @Test
    void testUkupanIznos() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("CAJ","Čaj",1.50),5);
        r.dodajStavku(new Artikal("KAF","Kafa",1.00),2);
        assertEquals(r.ukupanIznos(),9.50);
    }

    @Test
    void testIzradiRacun() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("CAJ","Čaj",1.50),5);
        r.dodajStavku(new Artikal("KAF","Kafa",1.00),2);
        r.dodajStavku(new Artikal("SOK","Coca Cola",3.00),3);

        assertEquals(r.izradiRacun(),"CAJ\t5\t7.50\n" + "KAF\t2\t2.00\n" + "SOK\t3\t9.00\n" + "UKUPNO\t\t18.50");
    }
}