
package lab4;
import java.io.PrintStream;


public class Photo {
    String url;
    Photo(String url_){
        this.url = url_;
    }
    void writHTML(PrintStream out){
        out.printf("<img src =\"%s\" alt = \" Smiley face\" height=\"42\" width= \"42\"/>\n ", url);
    }
}
