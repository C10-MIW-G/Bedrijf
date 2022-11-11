package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * <p>
 * Ons bedrijf doet dingen, nee echt!
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        ArrayList<Afdeling> afdelingen = leesAfdelingenIn("resources/Afdelingen.txt");
        ArrayList<Persoon> personen = leesPersonenIn("resources/Personen.csv", afdelingen);

        Collections.sort(personen);
        for (Persoon persoon : personen) {
            System.out.println(persoon);
        }
    }

    public static ArrayList<Afdeling> leesAfdelingenIn(String bestandsNaam) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        File afdelingenBestand = new File(bestandsNaam);
        try (Scanner afdelingenScanner = new Scanner(afdelingenBestand)) {
            while (afdelingenScanner.hasNext()) {
                String afdelingsNaam = afdelingenScanner.nextLine();
                String afdelingsPlaats = afdelingenScanner.nextLine();

                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het is niet gelukt het bestand te openen");
        }

        return afdelingen;
    }

    public static ArrayList<Persoon> leesPersonenIn(String bestandsNaam, ArrayList<Afdeling> afdelingen) {
        ArrayList<Persoon> personen = new ArrayList<>();
        File personenBestand = new File(bestandsNaam);
        try (Scanner bestandsScanner = new Scanner(personenBestand)) {
            while (bestandsScanner.hasNext()) {
                String[] persoonsGegevens = bestandsScanner.nextLine().split(",");

                String werknemerType = persoonsGegevens[0];
                String naam = persoonsGegevens[1];
                String woonplaats = persoonsGegevens[2];
                int afdelingsIndex = Integer.parseInt(persoonsGegevens[3]);
                Afdeling afdeling = afdelingen.get(afdelingsIndex);
                double ietsMetGeld = Double.parseDouble(persoonsGegevens[4]);

                switch (werknemerType) {
                    case "Werknemer":
                        personen.add(new Werknemer(naam, woonplaats, afdeling, ietsMetGeld));
                        break;
                    case "Zzper":
                        personen.add(new Zzper(naam, woonplaats, afdeling, ietsMetGeld));
                        break;
                    case "Vrijwilliger":
                        personen.add(new Vrijwilliger(naam, woonplaats, afdeling));
                        break;
                    default:
                        System.out.printf("Persoon met onbekend type gevonden, type: %s", werknemerType);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het is niet gelukt het bestand te openen");
        }
        return personen;
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar.\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }
}
