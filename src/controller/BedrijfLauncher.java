package controller;

import model.Persoon;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Ons bedrijf doet dingen, nee echt!
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        System.out.println(Persoon.aantalPersonen);
        Persoon baas = new Persoon("Mark", "Den Haag", 10000);
        System.out.println(Persoon.aantalPersonen);
        Persoon medewerker = new Persoon("Caroline", "Delft", 4000);
        System.out.println(Persoon.aantalPersonen);
        Persoon assistent = new Persoon ("Klaas");
        Persoon manager = new Persoon();
        System.out.println(Persoon.aantalPersonen);

        String bonus = "wel";
        if (!baas.heeftRechtOpBonus()) {
            bonus = "geen";
        }
        System.out.printf("%s verdient %.2f en heeft %s recht op een bonus.\n",
                baas.getNaam(), baas.getMaandSalaris(), bonus);

        bonus = "geen";
        if (medewerker.heeftRechtOpBonus()) {
            bonus = "wel";
        }
        System.out.printf("%s verdient %.2f en heeft %s recht op een bonus.\n",
                medewerker.getNaam(), medewerker.getMaandSalaris(), bonus);
    }

}
