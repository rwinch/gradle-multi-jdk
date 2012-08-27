package test;

import static org.fest.assertions.Assertions.assertThat;

import java.io.DataInputStream;
import java.io.InputStream;

import org.junit.Test;

public class JavaVersionMessageServiceTest {

    public static String NOT_NULL = "Not Null";

    @Test
    public void getMessage() {
        String javaVersion = new JavaVersionMessageService().getMessage();
        assertThat(javaVersion).startsWith("1.6.");
    }

    @Test
    public void checkBytes() throws Exception {
        assertClassVersion("test/JavaVersionMessageService.class");
        assertClassVersion("test/JavaVersionMessageServiceTest.class");
    }

    private void assertClassVersion(String classLocation) throws Exception {
        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("test/JavaVersionMessageService.class");
        try {
            DataInputStream data = new DataInputStream(input);
            data.readInt();
            data.readShort(); // minor
            int major = data.readShort();
            assertThat(major).isEqualTo(49);
        } finally {
            try { input.close(); } catch(Exception e) {}
        }
    }
}
