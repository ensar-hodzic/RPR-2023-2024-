package ba.unsa.etf.rpr.predavanje02;

import org.w3c.dom.ranges.RangeException;

import java.util.Scanner;
import java.util.Set;

public class Program {

    public static void main(String[] args) throws NeispravanBroj {
        Imenik imenik=new Imenik();
        String broj,ime;
        while(true) {
            System.out.print("Dobrodošli na ETF imenik! Vaše opcije su sljedeće:\n" +
                    "1. Dodajte novog kontakta u imenik\n" +
                    "2. Pretražite kontakta po imenu\n" +
                    "3. Pretražite kontakta po broju\n" +
                    "4. Pretražite kontakte po prvom slovu\n" +
                    "5. Pregledajte sve osobe iz nekog grada\n" +
                    "6. Pregledajte sve brojeve iz nekog grada\n" +
                    "0. Za izlaz\n" +
                    "Vaš izbor (broj 0-6): ");
            Scanner ulaz = new Scanner(System.in);
            int input = 0, x = 0;
            while (true) {
                try {
                    input = ulaz.nextInt();
                    if (input < 0 || input > 6) throw new Exception();
                    if(input==0) return;
                    break;
                } catch (Exception e) {
                    System.out.print("Ooops, greška, probajte opet");
                }
            }
            switch (input) {
                case 1:
                    System.out.print("Unesite ime kontakta: ");
                    ime = ulaz.next();
                    System.out.print("Kakav broj unosite? 1 - Fiksni; 2 - Mobilni; 3 - Međunarodni: ");
                    while (true) {
                        try {
                            x = ulaz.nextInt();
                            if (x < 1 || x > 3) throw new Exception();
                            break;
                        } catch (Exception e) {
                            System.out.print("Ooops, greška, probajte opet");
                        }
                    }
                    switch (x) {
                        case 1:
                            System.out.print("Unesite pozivni broj: ");
                            String grad = ulaz.next();
                            Grad temp1 = Grad.gradIzPozivnog(grad);
                            System.out.print("Unesite broj: ");
                            broj = ulaz.next();
                            imenik.dodaj(ime, new FiksniBroj(temp1, broj));
                            break;
                        case 2:
                            System.out.print("Unesite broj operatera: ");
                            int operater = ulaz.nextInt();
                            System.out.print("Unesite broj: ");
                            broj = ulaz.next();
                            imenik.dodaj(ime, new MobilniBroj(operater, broj));
                            break;
                        case 3:
                            System.out.print("Unesite pozivni broj: ");
                            String pozivni = ulaz.next();
                            System.out.print("Unesite broj: ");
                            broj = ulaz.next();
                            imenik.dodaj(ime, new MedunarodniBroj(pozivni, broj));
                            break;
                    }
                    System.out.println("GOTOVO!");
                    break;
                case 2:
                    System.out.print("Unesite ime kontakta: ");
                    ime = ulaz.next();
                    try {
                       System.out.println("Broj telefona: "+imenik.dajBroj(ime));
                    }catch (Exception e){
                        System.out.println("Nepostojeci kontakt");
                    }
                    break;
                case 3:
                    System.out.print("Kakav broj unosite? 1 - Fiksni; 2 - Mobilni; 3 - Međunarodni: ");
                    while (true) {
                        try {
                            x = ulaz.nextInt();
                            if (x < 1 || x > 3) throw new Exception();
                            break;
                        } catch (Exception e) {
                            System.out.print("Ooops, greška, probajte opet");
                        }
                    }
                    TelefonskiBroj trazeni=new MobilniBroj(61,"000");
                    switch (x) {
                        case 1:
                            System.out.print("Unesite pozivni broj: ");
                            String grad = ulaz.next();
                            Grad temp1 = Grad.gradIzPozivnog(grad);
                            System.out.print("Unesite broj: ");
                            broj = ulaz.next();
                            trazeni=new FiksniBroj(temp1,broj);
                            break;
                        case 2:
                            System.out.print("Unesite broj operatera: ");
                            int operater = ulaz.nextInt();
                            System.out.print("Unesite broj: ");
                            broj = ulaz.next();
                            trazeni = new MobilniBroj(operater,broj);
                            break;
                        case 3:
                            System.out.print("Unesite pozivni broj: ");
                            String pozivni = ulaz.next();
                            System.out.print("Unesite broj: ");
                            broj = ulaz.next();
                            trazeni=new MedunarodniBroj(pozivni,broj);
                            break;
                    }
                    try {
                        System.out.println("Ime kontakta: "+imenik.dajIme(trazeni));
                    }catch (Exception e){
                        System.out.println("Nepostojeci kontakt");
                    }
                    break;
                case 4:
                    System.out.print("Unesite slovo: ");
                    char c=ulaz.next().charAt(0);
                    System.out.print(imenik.naSlovo(c));
                    break;
                case 5:
                    System.out.print("Unesite pozivni broj grada: ");
                    String grad = ulaz.next();
                    Grad temp1 = Grad.gradIzPozivnog(grad);
                    Set<String> imena=imenik.izGrada(temp1);
                    if(imena.isEmpty()) System.out.println("Nema kontakta iz tog grada");
                    else{
                        for(String s:imena) System.out.println(s);
                    }
                    break;
                case 6:
                    System.out.print("Unesite pozivni broj grada: ");
                    String grad1 = ulaz.next();
                    Grad temp2 = Grad.gradIzPozivnog(grad1);
                    Set<TelefonskiBroj> brojevi=imenik.izGradaBrojevi(temp2);
                    if(brojevi.isEmpty()) System.out.println("Nema kontakta iz tog grada");
                    else{
                        for(TelefonskiBroj t:brojevi) System.out.println(t.ispisi());
                    }
                    break;
            }
        }
    }
}