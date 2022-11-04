package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Een persoon die werkzaamheden uitvoert binnen ons bedrijf
 */
public class Persoon {
    private static final int MAANDEN_PER_JAAR = 12;
    public static int aantalPersonen = 0;

    public int personeelsNummer;
    public String naam;
    public String woonplaats;
    public double maandSalaris;

    public Persoon(String naam, String woonplaats, double maandSalaris) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.maandSalaris = maandSalaris;
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this.naam = naam;
        this.woonplaats = "Onbekend";
        this.maandSalaris = 0;
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon() {
        this.naam = "Onbekend";
        this.woonplaats = "Onbekend";
        this.maandSalaris = 0;
        this.personeelsNummer = ++aantalPersonen;
    }

    public double berekenJaarInkomen() {
        return maandSalaris * MAANDEN_PER_JAAR;
    }

}
