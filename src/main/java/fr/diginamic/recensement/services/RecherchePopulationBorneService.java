package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exceptions.RangeFormatException;
import fr.diginamic.recensement.exceptions.UnknownDepartementException;
import fr.diginamic.recensement.exceptions.WrongInputException;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 *
 * @author DIGINAMIC
 */
public class RecherchePopulationBorneService extends MenuService {

    @Override
    public void traiter(Recensement rec, Scanner scanner) throws RangeFormatException, WrongInputException, UnknownDepartementException {

        System.out.println("Quel est le code du département recherché ? ");
        String choix = scanner.nextLine();

        System.out.println("Choississez une population minimum (en milliers d'habitants): ");
        String saisieMin = scanner.nextLine();

        System.out.println("Choississez une population maximum (en milliers d'habitants): ");
        String saisieMax = scanner.nextLine();

        int min;
        int max;

        try {
            min = Integer.parseInt(saisieMin) * 1000;
            max = Integer.parseInt(saisieMax) * 1000;
        } catch (NumberFormatException e) {
            throw new WrongInputException("Integer", "String");
        }

        if (min > max) {
            throw new RangeFormatException();
        }

        List<Ville> villes = rec.getVilles();

        boolean isFound = false;

        for (Ville ville : villes) {
            if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
                isFound = true;
                if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
                    System.out.println(ville);
                }
            }
        }
        if (!isFound) {
            throw new UnknownDepartementException();
        }
    }

}
