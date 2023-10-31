package ba.unsa.etf.rpr;

public class Osoba {
    private String ime;
    private String prezime;
    public
    Osoba(String i, String p){
        ime=i;
        prezime=p;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return  ime + " " + prezime;
    }

}
