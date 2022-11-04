package ba.unsa.etf.rpr;

public class MobilniBroj extends TelefonskiBroj{

    private int mobilnaMreza;
    private String broj;
    public MobilniBroj(int mobilnaMreza, String broj) {
        if(mobilnaMreza>67 || mobilnaMreza<60) throw new Izuzetak("Ne valja");
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    public int getMobilnaMreza() {
        return mobilnaMreza;
    }

    public void setMobilnaMreza(int mobilnaMreza) {
        this.mobilnaMreza = mobilnaMreza;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    @Override
    public String ispisi() {
            if(mobilnaMreza==60)
                return "060/"+broj;
            else if(mobilnaMreza==61)
                return "061/"+broj;
            else if(mobilnaMreza==62)
                return "062/"+broj;
            else if(mobilnaMreza==63)
                return "063/"+broj;
            else if(mobilnaMreza==64)
                return "064/"+broj;
            else if(mobilnaMreza==65)
                return "065/"+broj;
            else if(mobilnaMreza==66)
                return "066/"+broj;
            return "067/"+broj;

    }
    @Override
    public int hashCode() {
        return 0;
    }
}
