package ShangguiguJava.ExceptionExercise;

public class BelowZeroException extends Exception{
    static final long serialVersionUID = -3387516993124229948L;
    public BelowZeroException() {
    }

    public BelowZeroException(String message) {
        super(message);
    }
}
