package ba.unsa.etf.rpr.predavanje02;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    @Test
    void izGrada() throws NeispravanBroj {
        Imenik imenik=new Imenik();
        Grad temp1 = Grad.gradIzPozivnog("033");
        imenik.dodaj("Ensar Hodžić", new FiksniBroj(temp1,"334323"));
        Set<String> temp=new TreeSet<String>();
        temp.add("Ensar Hodžić");
        assertEquals(temp, imenik.izGrada(temp1));
    }

    @Test
    void dajBroj() throws NeispravanBroj {
        Imenik imenik=new Imenik();
        Grad temp1 = Grad.gradIzPozivnog("033");
        imenik.dodaj("Ensar Hodžić", new FiksniBroj(temp1,"334323"));
        assertEquals("033/334323", imenik.dajBroj("Ensar Hodžić"));
    }

    @Test
    void izGradaBrojevi() throws NeispravanBroj {
        Imenik imenik=new Imenik();
        Grad temp1 = Grad.gradIzPozivnog("033");
        imenik.dodaj("Ensar Hodžić", new FiksniBroj(temp1,"334323"));
        Set<TelefonskiBroj> temp= new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });
        temp.add(new FiksniBroj(temp1,"334323"));
        assertEquals(temp, imenik.izGradaBrojevi(temp1));
    }
}