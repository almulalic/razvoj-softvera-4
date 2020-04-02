package ba.unsa.etf.rs.tut4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import java.util.ArrayList;

public class Controller {
    public TextArea unosArtikala;
    public TextArea filtiraniArtikli;

    public ChoiceBox<String> choiceBox;
    ObservableList choiceBoxLista = FXCollections.observableArrayList();

    public Spinner kolicina;
    public TextArea aktuelniRacun;

    ArrayList<Artikal> listaArtikala = new ArrayList<>();
    Racun racun = new Racun();

    public void DodajArtikal (ActionEvent actionEvent) {

        String[] unos = unosArtikala.getText().split("\n");

        for(String red:unos) {
            listaArtikala.add(new Artikal(red.trim()));
        }

        Artikal.izbaciDuplikate(listaArtikala);

        StringBuilder sb = new StringBuilder();
        for(Artikal a:listaArtikala){
            sb.append(a.sifra + ' ' + a.naziv + ' ' + a.cijena);
            choiceBoxLista.add(a.sifra);
            sb.append("\n");
        }

        choiceBox.getItems().addAll(choiceBoxLista);
        filtiraniArtikli.setText(sb.toString());

    }

    public void DodajArtikalNaRacun(ActionEvent actionEvent){

        String sifra = choiceBox.getValue();
        int kolicina = Integer.valueOf(this.kolicina.getValue().toString());

        for(Artikal a:listaArtikala) {
            if(a.sifra.equals(sifra)) {
                racun.dodajStavku(a,kolicina);
                break;
            }
        }

        aktuelniRacun.setText(racun.izradiRacun());
    }

}


