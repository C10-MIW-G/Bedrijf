package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Een persoon die werkzaamheden uitvoert binnen ons bedrijf
 */
public abstract class Persoon implements Comparable<Persoon> {
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    protected static final String DEFAULT_NAAM = "Onbekend";

    public static int aantalPersonen = 0;

    protected int personeelsNummer;
    protected String naam;
    protected String woonplaats;
    protected Afdeling afdeling;

    public Persoon(String naam, String woonplaats, Afdeling afdeling) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.afdeling = afdeling;
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public abstract double berekenJaarInkomen();

    @Override
    public String toString() {
        return String.format("%s woont in %s en werkt op %s", this.naam, this.woonplaats, this.afdeling);
    }

    @Override
    public int compareTo(Persoon anderePersoon) {
        return this.naam.compareTo(anderePersoon.naam);
    }

    public String getNaam() {
        return naam;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public String getWoonplaats() {
        return woonplaats;
    }
}
