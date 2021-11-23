package fr.diginamic.recensement.exceptions;

public class WrongInputException extends Exception {
    public WrongInputException(String expected, String provided) {
        super("L'input entré par l'utilisateur ne convient pas :\n" +
                "Expected: " + expected + "\n" +
                "Provided: " + provided);
    }
}
