package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Iemand die vrijwillig voor ons bedrijf dingen doet.
 */
public class Vrijwilliger extends Persoon implements Oproepbaar{
    private static final int DEFAULT_UREN_GEWERKT = 0;
    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling) {
        super(naam, woonplaats, afdeling);
        this.urenGewerkt = DEFAULT_UREN_GEWERKT;
    }

    @Override
    public double berekenJaarInkomen() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s en is een vrijwilliger", super.toString());
    }

    @Override
    public void huurIn(int uren) {
//        urenGewerkt += uren;
    }
}
