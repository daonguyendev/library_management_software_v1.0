package exception.customize_exception;

public class CalculatorException extends RuntimeException {

    public CalculatorException(String title, String error) {
        System.err.println(title + ": " + error);
    }
}
