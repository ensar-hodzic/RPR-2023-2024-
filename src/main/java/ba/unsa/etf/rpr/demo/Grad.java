package ba.unsa.etf.rpr.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Grad {
    private SimpleStringProperty naziv;
    private SimpleIntegerProperty populacija;
    private SimpleStringProperty drzava;

    public Grad(SimpleStringProperty naziv, SimpleIntegerProperty populacija, SimpleStringProperty drzava) {
        this.naziv = naziv;
        this.populacija = populacija;
        this.drzava = drzava;
    }

    public Grad(String naziv, int populacija, String drzava) {
        this.naziv = new SimpleStringProperty(naziv);
        this.populacija = new SimpleIntegerProperty(populacija);
        this.drzava = new SimpleStringProperty(drzava);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public int getPopulacija() {
        return populacija.get();
    }

    public SimpleIntegerProperty populacijaProperty() {
        return populacija;
    }

    public void setPopulacija(int populacija) {
        this.populacija.set(populacija);
    }

    public String getDrzava() {
        return drzava.get();
    }

    public SimpleStringProperty drzavaProperty() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava.set(drzava);
    }
}
