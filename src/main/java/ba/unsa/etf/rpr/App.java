package ba.unsa.etf.rpr;

import java.sql.SQLException;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) throws SQLException {
        GeografijaDAO geo = GeografijaDAO.getInstance();
        ArrayList<Grad> gradovi=geo.gradovi();
        for(Grad g:gradovi) System.out.println(g.getNaziv()+" "+g.getPopulacija()+" "+g.getDrzava());
        geo.obrisiDrzavu("Bosna i Hercegovina");
        ArrayList<Grad> gradoi=geo.gradovi();
        for(Grad g:gradoi) System.out.println(g.getNaziv()+" "+g.getPopulacija()+" "+g.getDrzava());
        geo.dodajGrad(new Grad("Tuzla",17,"Bosna i Hercegovina"));
        gradoi=geo.gradovi();
        for(Grad g:gradoi) System.out.println(g.getNaziv()+" "+g.getPopulacija()+" "+g.getDrzava());
        geo.dodajGrad(new Grad("El Pari",1231231,"Francuska"));
        gradoi=geo.gradovi();
        for(Grad g:gradoi) System.out.println(g.getNaziv()+" "+g.getPopulacija()+" "+g.getDrzava());

    }
}
