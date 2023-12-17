package ba.unsa.etf.rpr.lv7.lv7;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici;
    private final SimpleObjectProperty<Korisnik> trenutni;

    public KorisniciModel(){
        korisnici= observableArrayList();
        trenutni = new SimpleObjectProperty<>();
    }

    public void napuni(ArrayList<Korisnik> podaci) {
        korisnici= FXCollections.<Korisnik>observableArrayList();
        korisnici.addAll(podaci);
        this.setTrenutni(podaci.get(0));
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public SimpleObjectProperty<Korisnik> getTrenutni() {
        return trenutni;
    }

    public SimpleObjectProperty trenutniProperty() {
        return trenutni;
    }

    public void setTrenutni(Korisnik trenutni) {
        this.trenutni.set(trenutni);
    }

    public void dodajNovogKorisnika(Korisnik k)
    {
        this.korisnici.add(k);
        this.setTrenutni(k);
    }


}
