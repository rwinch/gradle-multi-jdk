package test;

/**
 * Shows javadoc works for accessing JDK 1.6 source {@link JavaVersionMessageService}.
 * @author Rob Winch
 *
 */
public class Jdk7JavaVersionMessageService {

    public String getMessage() {
        // we can access main classes from jdk 1.6 code for this jar
        String message = new JavaVersionMessageService().getMessage();
        // switch(String) will fail in JDK 1.6
        switch(message) {
            default:
                return message;
        }
    }
}
