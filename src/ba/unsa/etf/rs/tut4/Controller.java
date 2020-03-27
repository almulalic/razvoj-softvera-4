package ba.unsa.etf.rs.tut4;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import java.util.ArrayList;

public class ArtikalController {
    public TextArea unosArtikala;
    public TextArea filtiraniArtikli;

    public void DodajArtikal (ActionEvent actionEvent) {
        ArrayList<Artikal> lista = new ArrayList<Artikal>();

        String[] unos = unosArtikala.getText().split("\n");
        String[] temp;

        for(String red:unos){
            temp = red.split(",");
            lista.add(new Artikal(temp[0].trim(),temp[1].trim(),Double.parseDouble(temp[2].trim())));
        }

        Artikal.izbaciDuplikate(lista);

        StringBuilder sb = new StringBuilder();
        for(Artikal a:lista){
            sb.append(a.sifra + ' ' + a.naziv + ' ' + a.cijena);
            sb.append("\n");
        }

        filtiraniArtikli.setText(sb.toString());
    }
}


