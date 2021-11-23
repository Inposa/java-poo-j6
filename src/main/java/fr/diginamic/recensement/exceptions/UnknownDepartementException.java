package fr.diginamic.recensement.exceptions;

public class UnknownDepartementException extends Exception {
    public UnknownDepartementException(){
        super("Le département entré est inconnu, veuillez réessayer.");
    }
}
