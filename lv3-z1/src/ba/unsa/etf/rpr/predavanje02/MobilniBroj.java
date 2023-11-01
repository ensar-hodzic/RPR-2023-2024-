package ba.unsa.etf.rpr.predavanje02;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj{
    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) throws NeispravanBroj {
        if(mobilnaMreza<60 || mobilnaMreza>67) throw new NeispravanBroj("Pogrešan pozivni broj");
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    public int getMobilnaMreza() {
        return mobilnaMreza;
    }

    public String getBroj() {
        return broj;
    }

    @Override
    public String ispisi() {
        if(broj!=null) return "0"+mobilnaMreza+"/"+broj;
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza,broj);
    }
}
