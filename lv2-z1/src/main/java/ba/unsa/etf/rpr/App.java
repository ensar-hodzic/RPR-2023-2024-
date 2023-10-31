package ba.unsa.etf.rpr;

public class App
{
    public static void main( String[] args )
    {
        if(args.length != 0) {
            System.out.println(Math.sin(Integer.parseInt(args[0])));
            int max = Integer.parseInt(args[0]);
            int rez = 1;
            for (int i = 1; i <= max; i++) rez = rez * i;
            System.out.println(rez);
        }
    }
}
