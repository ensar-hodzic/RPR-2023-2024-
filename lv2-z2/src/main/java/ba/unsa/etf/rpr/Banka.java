package ba.unsa.etf.rpr;

import java.util.List;

public class Banka {
    private Long brojRacuna;
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;
    Banka(){
        brojRacuna=(long)1231231;
    }
    public Korisnik kreirajNovogKorisnika(String i, String p){
        return new Korisnik(i,p);
    }
    public Uposlenik kreirajNovogUposlenika(String i, String p){
        return new Uposlenik(i,p);
    }
    public Racun kreirajRacunZaKorisnika(Korisnik k){
        return new Racun((long)Math.floor(Math.random()*1000),k);
    }
}
