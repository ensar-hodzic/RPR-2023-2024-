package ba.unsa.etf.rpr;

public class Racun {
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private double stanjeRacuna;
    public Racun(Long broj, Osoba o){
        brojRacuna=broj;
        korisnikRacuna=o;
        odobrenjePrekoracenja=false;
        stanjeRacuna=0;
    }
    private boolean provjeriOdobrenjePrekoracenja(double d){
        return false;
    }
    public boolean izvrsiUplatu(double d){
        stanjeRacuna=stanjeRacuna+d;
        return true;
    }
    public boolean izvrsiIsplatu(double d){
        stanjeRacuna=stanjeRacuna-d;
        return true;
    }
    public void odobriPrekoracenje(double d){
        odobrenjePrekoracenja=true;
    }
}
