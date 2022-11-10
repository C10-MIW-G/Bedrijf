package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Vult persoon aan met specifieke eigenschappen van een werknemer.
 */
public class Werknemer extends Persoon {
    private static final double GRENSWAARDE_BONUS = 4500.0;
    private static final int DEFAULT_MAAND_SALARIS = 0;
    private static final int AANTAL_MAANDEN_PER_JAAR = 12;

    private double maandSalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandSalaris) {
        super(naam, woonplaats, afdeling);
        this.setMaandSalaris(maandSalaris);
    }

    public Werknemer(String naam) {
        super(naam);
        this.setMaandSalaris(DEFAULT_MAAND_SALARIS);
    }

    public Werknemer() {
        super();
        this.setMaandSalaris(DEFAULT_MAAND_SALARIS);
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    @Override
    public double berekenJaarInkomen() {
        double jaarSalaris = maandSalaris * AANTAL_MAANDEN_PER_JAAR;

        if (heeftRechtOpBonus()) {
            jaarSalaris += maandSalaris;
        }

        return jaarSalaris;
    }

    @Override
    public String toString() {
        String bonus = "zonder";
        if (heeftRechtOpBonus()) {
            bonus = "met";
        }
        return String.format("%s en is een werknemer %s recht op een bonus", super.toString(), bonus);
    }

    public void setMaandSalaris(double maandSalaris) {
        if (maandSalaris < 0) {
            throw new IllegalArgumentException("Het maandsalaris mag niet negatief zijn");
        } else {
            this.maandSalaris = maandSalaris;
        }
    }

    public double getMaandSalaris() {
        return maandSalaris;
    }
}
