package ba.unsa.etf.rpr.predavanje02;

import java.util.Objects;

public class MedunarodniBroj extends TelefonskiBroj{
    private String drzava;
    private String broj;

    @Override
    public String ispisi() {
        if(drzava!=null && broj!=null) return drzava+broj;
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drzava, broj);
    }

    public String getDrzava() {
        return drzava;
    }

    public String getBroj() {
        return broj;
    }

    public MedunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }
}
