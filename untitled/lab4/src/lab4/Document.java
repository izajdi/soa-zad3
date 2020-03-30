package lab4;
import java.io.PrintStream;
import java.util.*;

public class Document {
    String title;
    Photo photo;
    List<Section> sections = new ArrayList<>();


    Document(String title_){
        this.title = title_;
    }
    Document setTitle(String title_){
        this.title = title_;
        return this;
    }
    Document setPhoto(String photoUrl){
        photo = new Photo (photoUrl);
        return this;
    }
    Section addSection(String sectionTitle){
        Section sec = new Section(sectionTitle);
        sections.add(sec);
        return sec;
    }
    Section addSection(Section sec){
        sections.add(sec);
        return sec;
    }
    void writeHTML(PrintStream out){
        out.println("<DOCTYPE! html>");
        out.println("<html lang='pl'>");
        out.println("<head>");
        out.printf("<title> %s </title>", title);
        out.println("</head>");
        out.println("<body>");
        photo.writHTML(out);
        for(Section i: sections){
            i.writeHTML(out);
        }
        out.println("</body>");
        out.println("</html");

    }





}
