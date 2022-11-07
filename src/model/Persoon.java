package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Een persoon die werkzaamheden uitvoert binnen ons bedrijf
 */
public class Persoon {
    private static final double GRENSWAARDE_BONUS = 4500.0;
    private static final int MAANDEN_PER_JAAR = 12;

    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final int DEFAULT_MAAND_SALARIS = 0;
    private static final String DEFAULT_NAAM = "Onbekend";

    public static int aantalPersonen = 0;

    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private double maandSalaris;
    private Afdeling afdeling;

    public Persoon(String naam, String woonplaats, double maandSalaris, Afdeling afdeling) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        setMaandSalaris(maandSalaris);
        this.afdeling = afdeling;
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, DEFAULT_MAAND_SALARIS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public double berekenJaarInkomen() {
        return maandSalaris * MAANDEN_PER_JAAR;
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    public void setMaandSalaris(double maandSalaris) {
        if (maandSalaris < 0) {
            this.maandSalaris = 0;
            System.err.println("Het maandsalaris mag niet negatief zijn.");
        } else {
            this.maandSalaris = maandSalaris;
        }
    }

    public String getNaam() {
        return naam;
    }

    public double getMaandSalaris() {
        return maandSalaris;
    }
}
