package lab4;
import java.io.PrintStream;

public class Paragraph {
    String content;
    Paragraph(String content_){
        content = content_;
    }

    Paragraph setContent(String content_){
        content = content_;
        return this;
    }

    void writeHTML(PrintStream out) {
        out.printf("<p> %s </p>", content);
    }

    String getContent(){
        return this.content;
    }
}


