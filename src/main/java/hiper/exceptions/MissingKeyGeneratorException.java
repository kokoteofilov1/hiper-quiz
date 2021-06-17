package hiper.exceptions;

public class MissingKeyGeneratorException extends Exception {
    public MissingKeyGeneratorException() {
    }

    public MissingKeyGeneratorException(String message) {
        super(message);
    }

    public MissingKeyGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingKeyGeneratorException(Throwable cause) {
        super(cause);
    }
}
