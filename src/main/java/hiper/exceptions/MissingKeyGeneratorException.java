package hiper.exceptions;

public class MissingKeyGeneratorException extends Throwable {
    public MissingKeyGeneratorException() {
        super();
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
