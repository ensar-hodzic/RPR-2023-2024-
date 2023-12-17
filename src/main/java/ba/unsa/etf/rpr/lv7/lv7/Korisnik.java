package ba.unsa.etf.rpr.lv7.lv7;

import javafx.beans.property.SimpleStringProperty;

public class Korisnik {
    private SimpleStringProperty ime;
    private SimpleStringProperty prezime;
    private SimpleStringProperty email;
    private SimpleStringProperty username;
    private SimpleStringProperty pass;


    public Korisnik() {
        this.ime = new SimpleStringProperty("");;
        this.prezime = new SimpleStringProperty("");;
        this.email = new SimpleStringProperty("");;
        this.username = new SimpleStringProperty("");;
        this.pass = new SimpleStringProperty("");;
    }

    public Korisnik(String ime, String prezime, String email, String username, String pass) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
        this.username = new SimpleStringProperty(username);
        this.pass = new SimpleStringProperty(pass);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPass() {
        return pass.get();
    }

    public SimpleStringProperty passProperty() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass.set(pass);
    }
    @Override
    public String toString() {
        String s="";
        s=s+this.prezimeProperty().getValue()+" "+this.imeProperty().getValue();
        return s;
    }
}
