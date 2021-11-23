package fr.diginamic.recensement.exceptions;

public class RangeFormatException extends Exception {
    public RangeFormatException() {
        super("Le format de range ne convient pas, le nombre minimum est plus grand que le nombre maximum.");
    }
}
