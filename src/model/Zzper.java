package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Houdt de eigenschappen bij van een als zzper ingehuurd persoon
 */
public class Zzper extends Persoon implements Oproepbaar {
    private static final int DEFAULT_UREN_GEWERKT = 0;

    private double uurTarief;
    private int urenGewerkt;

    public Zzper(String naam, String woonplaats, Afdeling afdeling, double uurTarief) {
        super(naam, woonplaats, afdeling);
        this.uurTarief = uurTarief;
        this.urenGewerkt = DEFAULT_UREN_GEWERKT;
    }

    @Override
    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    @Override
    public double berekenJaarInkomen() {
        return urenGewerkt * uurTarief;
    }

    @Override
    public String toString() {
        return String.format("%s en is een zzp-er met een uurtarief van %.2f", super.toString(), this.uurTarief);
    }
}
