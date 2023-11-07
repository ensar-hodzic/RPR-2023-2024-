package ba.unsa.etf.rpr.predavanje02;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    private Grad grad;
    private String broj;

    public Grad getGrad() {
        return grad;
    }

    public String getBroj() {
        return broj;
    }

    public FiksniBroj(Grad grad, String broj) throws NeispravanBroj {
        if(grad==null) throw new NeispravanBroj("Unijeli ste neispravan pozivni broj");
        this.grad = grad;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        if(grad!=null && broj!=null) return grad+"/"+broj;
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad,broj);
    }
}
