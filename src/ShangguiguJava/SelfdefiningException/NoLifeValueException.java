package ShangguiguJava.SelfdefiningException;

public class NoLifeValueException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;

    public NoLifeValueException() {

    }

    public NoLifeValueException(String message) {
        super(message);
    }
}
