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

    public ChoiceBox<Artikal> choiceBox;
    ObservableList choiceBoxLista = FXCollections.observableArrayList();

    public Spinner kolicina;
    public TextArea aktuelniRacun;

    Racun ra = new Racun();

    public void DodajArtikal (ActionEvent actionEvent) {
        ArrayList<Artikal> lista = new ArrayList<Artikal>();

        String[] unos = unosArtikala.getText().split("\n");
        String[] temp;

        for(String red:unos) {
            lista.add(new Artikal(red));
        }

        Artikal.izbaciDuplikate(lista);

        StringBuilder sb = new StringBuilder();
        for(Artikal a:lista){
            sb.append(a.sifra + ' ' + a.naziv + ' ' + a.cijena);
            choiceBoxLista.add(a);
            sb.append("\n");
        }

        choiceBox.getItems().addAll(choiceBoxLista);
        filtiraniArtikli.setText(sb.toString());

    }

    public void DodajArtikalNaRacun(ActionEvent actionEvent){

        Artikal novi = choiceBox.getValue();

        int kolicina = Integer.valueOf(this.kolicina.getValue().toString());
        ra.dodajStavku(novi,kolicina);



    }

}


