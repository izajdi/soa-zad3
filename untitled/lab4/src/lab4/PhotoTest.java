package lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PhotoTest {

    @org.junit.jupiter.api.Test
    void writHTML() {
        ByteArrayOutputStream byos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byos);
        String imgsrc = "eloelo";
        new Photo(imgsrc).writHTML(ps);
        String result = null;
        result = byos.toString();
        assertTrue(result.contains("<img"));
        assertTrue(result.contains("eloelo"));


    }
}