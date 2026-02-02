package GestioneUtenti.Exceptions;

public class UsernameGiaInUsoException extends RuntimeException {
    public UsernameGiaInUsoException(String message) {
        super(message);
    }
}
