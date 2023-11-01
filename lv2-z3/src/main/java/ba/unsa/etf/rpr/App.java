package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        List<Double> lista = new ArrayList<Double>();
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite brojeve u listu: ");
        while(true){
            String u=ulaz.next();
            if("stop".equalsIgnoreCase(u.trim())) break;
            try{
                lista.add(Double.parseDouble(u));
            }
            catch(NumberFormatException e){}
        }
        Double min=lista.get(0),max=lista.get(0), avg=new Double(0),dev=new Double(0);
        for(double x:lista){
            if(x<=min) min=x;
            if(x>=max) max=x;
            avg=avg+x;
        };
        avg=avg/lista.size();
        for(double x:lista){
            dev=dev+Math.pow((x-avg),2);
        }
        dev=Math.sqrt(dev/lista.size());
        System.out.println("Minimalna vrijednost: "+min);
        System.out.println("Maksimalna vrijednost: "+max);
        System.out.println("Srednja vrijednost: "+avg);
        System.out.println("Standardna devijacija: "+dev);
    }
}
