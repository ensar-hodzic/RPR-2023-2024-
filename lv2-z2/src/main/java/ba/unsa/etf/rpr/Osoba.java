package ba.unsa.etf.rpr;

public class Osoba {
    private
    String ime;
    String prezime;
    public
    Osoba(String i, String p){
        ime=i;
        prezime=p;
    }
    @Override
    public String toString() {
        return  ime + " " + prezime;
    }
}
