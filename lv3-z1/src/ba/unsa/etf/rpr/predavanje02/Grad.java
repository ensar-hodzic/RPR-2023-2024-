package ba.unsa.etf.rpr.predavanje02;

public enum Grad {
    SARAJEVO("033"),ZENICA("032"), TUZLA("035"), MOSTAR("036"), LIVNO("034"), ORAŠJE("031"),
    TRAVNIK("030"), BIHAĆ("037"), GORAŽDE("038"), POSUŠJE("039"), BRČKO("049");
    private final String name;

    Grad(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public static Grad gradIzPozivnog(String pozivni){
        for(Grad g:Grad.values()){
            if(g.getName().equals(pozivni)) return g;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
