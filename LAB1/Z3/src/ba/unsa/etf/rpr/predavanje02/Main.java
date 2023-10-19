package ba.unsa.etf.rpr.predavanje02;

public class Sat{
    int sati, minute, sekunde;
    public:
    Sat(int h, int m, int s){
        Postavi(h,m,s);
    }
    static void Postavi(int h, int m, int s){
        sati=h; minute=m; sekunde=s;
    }
    static void Sljedeci() {
        sekunde++;
        if (sekunde==60) { sekunde=0; minute++; }
        if (minute==60) { minute=0; sati++; }
        if (sati==24) sati=0;
    }
    static void Prethodni() {
        sekunde--;
        if (sekunde==-1) { sekunde=59; minute--; }
        if (minute==-1) { minute=59; sati--; }
        if (sati==-1) sati=23;
    }
    static void PomjeriZa(int pomak) {
        if (pomak>0) for (int i(0); i<pomak; i++) Sljedeci();
                        else for (int i(0); i<-pomak; i++) Prethodni();
    }
    static int DajSate() const { return sati; }
    static int DajMinute() const { return minute; }
    static int DajSekunde() const { return sekunde; }
    static void Ispisi() const { System.out.print(sati+":"+minute+":"+sekunde) }

}

public class Main {
    public static void main(String[] args) {
        // write your code here
        Sat s (15, 30, 45);
        s.Ispisi();
        s.Sljedeci();
        s.Ispisi();
        s.PomjeriZa(-48);
        s.Ispisi();
        s.Postavi(0, 0, 0);
        s.Ispisi();
    }
}
