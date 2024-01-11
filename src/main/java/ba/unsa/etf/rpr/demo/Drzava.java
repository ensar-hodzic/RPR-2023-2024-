package ba.unsa.etf.rpr.demo;

import javafx.beans.property.SimpleStringProperty;

public class Drzava {
    private SimpleStringProperty naziv;
    private SimpleStringProperty glavni_grad;

    public Drzava(SimpleStringProperty naziv, SimpleStringProperty glavni_grad) {
        this.naziv = naziv;
        this.glavni_grad = glavni_grad;
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

    public String getGlavni_grad() {
        return glavni_grad.get();
    }

    public SimpleStringProperty glavni_gradProperty() {
        return glavni_grad;
    }

    public void setGlavni_grad(String glavni_grad) {
        this.glavni_grad.set(glavni_grad);
    }

    public Drzava(String naziv, String glavni_grad) {
        this.naziv = new SimpleStringProperty(naziv);
        this.glavni_grad = new SimpleStringProperty(glavni_grad);
    }
}
