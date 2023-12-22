package ba.unsa.etf.rpr;

public class Grad {
    private String naziv;
    private int populacija;
    private String drzava;

    public Grad(String naziv, int populacija, String drzava) {
        this.naziv = naziv;
        this.populacija = populacija;
        this.drzava = drzava;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPopulacija() {
        return populacija;
    }

    public void setPopulacija(int populacija) {
        this.populacija = populacija;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }
}
