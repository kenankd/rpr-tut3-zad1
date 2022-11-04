package ba.unsa.etf.rpr;

import java.util.*;

public class Imenik {
    private HashMap<String, TelefonskiBroj> mapa;

    public Imenik() {
        mapa = new HashMap<String, TelefonskiBroj>();
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        mapa.put(ime, broj);
    }

    public String dajBroj(String ime) {
        return mapa.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        if (mapa.containsValue(broj)) {
            for (Map.Entry<String, TelefonskiBroj> clan : mapa.entrySet()) {
                if (clan.getValue().equals(broj)) return clan.getKey();
            }
        }
        return "Broj nije nadjen.";
    }

    public String naSlovo(char s) {
        String rez = "";
        int index = 0;
        for (Map.Entry<String, TelefonskiBroj> clan : mapa.entrySet()) {
            if (clan.getKey().charAt(0) == s)
                rez += ++index + ". " + clan.getKey() + " - " + clan.getValue().ispisi() + "\n";
        }
        return rez;
    }

    public Set<String> izGrada(Grad g) {
        Set<String> rez = new TreeSet<>();
        for (Map.Entry<String, TelefonskiBroj> clan : mapa.entrySet()) {
            if (clan.getValue() instanceof FiksniBroj && ((FiksniBroj) clan.getValue()).getGrad().equals(g))
                rez.add(clan.getKey());

        }
        return rez;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> rez = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                if (o1 instanceof FiksniBroj && o2 instanceof FiksniBroj)
                    return o1.ispisi().compareTo(o2.ispisi());
                return 0;
            }
        });

        for (Map.Entry<String, TelefonskiBroj> clan : mapa.entrySet()) {
            if (clan.getValue() instanceof FiksniBroj && ((FiksniBroj) clan.getValue()).getGrad().equals(g))
                rez.add(clan.getValue());
        }

        return rez;

    }
}
