package model;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Een afdeling binnen ons bedrijf
 */
public class Afdeling {
    private static final String DEFAULT_AFDELINGS_PLAATS = "Onbekend";
    private static final String DEFAULT_AFDELINGS_NAAM = "Onbekend";

    private String afdelingsNaam;
    private String afdelingsPlaats;

    public Afdeling(String afdelingsNaam, String afdelingsPlaats) {
        this.afdelingsNaam = afdelingsNaam;
        this.afdelingsPlaats = afdelingsPlaats;
    }

    public Afdeling() {
        this(DEFAULT_AFDELINGS_NAAM, DEFAULT_AFDELINGS_PLAATS);
    }
}
