package lab4;


public class Main {
    public static void main(String []arg){
        Document cv = new Document("BartekZajda - CV");
        Section section = new Section("sekcja1");
        section.addParagraph("contentcontentcontentcontentcontentcontentcontent");
        cv.setTitle("Title");
        cv.addSection(section);
        cv.setPhoto("aaaaa");
        cv.writeHTML(System.out);

    }
}
