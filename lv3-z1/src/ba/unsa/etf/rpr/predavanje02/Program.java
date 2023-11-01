package ba.unsa.etf.rpr.predavanje02;

import org.w3c.dom.ranges.RangeException;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Imenik imenik=new Imenik();
        System.out.print("Dobrodošli na ETF imenik! Vaše opcije su sljedeće:\n" +
                "1. Dodajte novog kontakta u imenik\n" +
                "2. Pretražite kontakta po imenu\n" +
                "3. Pretražite kontakta po broju\n" +
                "4. Pretražite kontakte po prvom slovu\n" +
                "5. Pregledajte sve osobe iz nekog grada\n" +
                "6. Pregledajte sve brojeve iz nekog grada\n" +
                "Vaš izbor: ");
        Scanner ulaz=new Scanner(System.in);
        int input=0,x=0;
        while(true) {
            try {
                input = ulaz.nextInt();
                if(input<1 || input>6) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.print("Ooops, greška, probajte opet");
            }
        }
        switch (input){
            case 1:
                System.out.print("Kakav broj unosite? 1 - Fiksni; 2 - Mobilni; 3 - Međunarodni");
                while(true) {
                    try {
                        x = ulaz.nextInt();
                        if(x<1 || x>3) throw new Exception();
                        break;
                    } catch (Exception e) {
                        System.out.print("Ooops, greška, probajte opet");
                    }
                }
                System.out.print("Unesite ime i prezime kontakta: ");
                String ime=ulaz.next();
                switch(x){
                    case 1:
                        System.out.print("Unesite pozivni broj: ");
                        String grad=ulaz.next();
                        Grad temp1;

                }
        }
    }
}