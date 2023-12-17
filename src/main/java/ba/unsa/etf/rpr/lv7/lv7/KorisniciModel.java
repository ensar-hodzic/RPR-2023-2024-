package ba.unsa.etf.rpr.lv7.lv7;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici= FXCollections.observableArrayList();;
    private final SimpleObjectProperty<Korisnik> trenutni= new SimpleObjectProperty<>();;

    public void napuni() {
        korisnici.add(new Korisnik("Ensar","Hodzic","ensi","banan","hejho"));
        korisnici.add(new Korisnik("Turkman","Kokuz","elien","ale ale","majmuneee"));
        trenutni.set(null);
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public SimpleObjectProperty<Korisnik> getTrenutni() {
        return trenutni;
    }

    public SimpleObjectProperty<Korisnik> trenutniProperty() {
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
