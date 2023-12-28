package ba.unsa.etf.rpr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws SQLException {
        GeografijaDAO geo = GeografijaDAO.getInstance();
        System.out.print(ispisiGradove(geo));
        glavniGrad(geo);
    }

    public static String ispisiGradove(GeografijaDAO geo){
        ArrayList<Grad> lista;
        StringBuilder rez= new StringBuilder();
        try {
            lista = geo.gradovi();
            for(Grad grad:lista) rez.append(grad.getNaziv()).append(" (").append(grad.getDrzava()).append(") - ").append(grad.getPopulacija()).append("\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rez.toString();
    }

    public static void glavniGrad(GeografijaDAO geo){
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite drzavu: ");
        String drzava=ulaz.next();
        Grad gr=geo.glavniGrad(drzava);
        if(gr!=null) System.out.println("Glavni grad države "+drzava+" je "+gr.getNaziv());
    }
}
