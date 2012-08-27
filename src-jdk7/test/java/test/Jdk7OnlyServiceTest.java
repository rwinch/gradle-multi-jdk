package test;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * Can use javadoc for jdk 1.6 {@link JavaVersionMessageServiceTest}
 * @author Rob Winch
 *
 */
public class Jdk7OnlyServiceTest {
    @Test
    public void compileAgainstJava16Source() {
        new JavaVersionMessageService();
    }

    @Test
    public void getMessage() {
        // can access JDK 7 source for this jar
        String message = new Jdk7JavaVersionMessageService().getMessage();
        // switch(String) would fail with JDK 1.6
        switch(message) {
            default:
                assertThat(message).startsWith("1.7.");
        }
    }

    @Test
    public void checkAccessJdk6Test() {
        // we can access test classes from 1.6
        assertThat(JavaVersionMessageServiceTest.NOT_NULL).isNotNull();
    }
}
