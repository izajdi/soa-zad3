package lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ParagraphTest {

    @org.junit.jupiter.api.Test
    void setContent() {
        Paragraph p1 = new Paragraph("content1");
        String s1 = "ichangeddcontent";
        p1.setContent(s1);
        assertEquals(p1.getContent(), s1);
    }

    @org.junit.jupiter.api.Test
    void writeHTML() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        new Paragraph("contentsiezgadza").writeHTML(ps);
        String result = null;
        result = baos.toString();
        assertTrue(result.contains("<p>"));
        assertTrue(result.contains("siezgadza"));
    }

}