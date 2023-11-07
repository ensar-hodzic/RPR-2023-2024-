package ba.unsa.etf.rpr.predavanje02;

import java.util.*;


public class Imenik {
    private Map<String, TelefonskiBroj> imenik;

    public Imenik() {
        this.imenik = new HashMap<String,TelefonskiBroj>();
    }

    public Map<String, TelefonskiBroj> getImenik() {
        return imenik;
    }

    public void setImenik(Map<String, TelefonskiBroj> imenik) {
        this.imenik = imenik;
    }

    public void dodaj(String ime, TelefonskiBroj broj){
        imenik.put(ime,broj);
    }

    public String dajBroj(String ime){
        return imenik.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String, TelefonskiBroj> x:imenik.entrySet()){
            if(x.getValue().ispisi().equals(broj.ispisi())) return x.getKey();
        }
        return null;
    }

    public String naSlovo(char s){
        int i=1;
        String rez=new String("");
        if(s>'Z') s-=32;
        for(Map.Entry<String, TelefonskiBroj> x:imenik.entrySet()){
            if(x.getKey().toLowerCase().charAt(0)==s) {
                String temp=i+". "+x.getKey()+" - "+x.getValue().ispisi()+"\n";
                i++;
                rez=rez+temp;
            };
        }
        return rez;
    }

    public Set<String> izGrada(Grad g){
        Set<String> rez=new TreeSet<String>();
        for(Map.Entry<String, TelefonskiBroj> x:imenik.entrySet()) {
            if(x.getValue() instanceof FiksniBroj){
                if(((FiksniBroj) x.getValue()).getGrad().equals(g)){
                    rez.add(x.getKey());
                }
            }
        }
        return rez;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj> rez=new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });
        for(Map.Entry<String, TelefonskiBroj> x:imenik.entrySet()) {
            if(x.getValue() instanceof FiksniBroj){
                if(((FiksniBroj) x.getValue()).getGrad().equals(g)){
                    rez.add(x.getValue());
                }
            }
        }
        return rez;
    }

}
