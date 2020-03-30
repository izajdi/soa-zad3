package lab4;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class Section {
    String title;
    List<Paragraph> paragraphs = new ArrayList<>();

    Section( String _title){
        title = _title;
    }

    Section addParagraph(String paragraphText){
        paragraphs.add(new Paragraph(paragraphText));
        return this;
    }

    Section addParagraph(Paragraph p1){
        paragraphs.add(p1);
        return this;
    }
     void writeHTML(PrintStream out){
        out.println("<div>");
        out.printf("<h1> %s </h1>\n", title);
        for(Paragraph i: paragraphs){
            i.writeHTML(out);
        }
        out.println("</div>");
     }
}
