import com.jad.collection2d.Collection2D;

public class Main {
    public static void main(String[] args) {
        Collection2D<Element> myCollection = new Collection2D<>();
        Element e1 = new Element("E1", 10, 12);
        Element e2 = new Element("E1", 10, 12);
        Element e3 = new Element("E1", 12, 10);
        myCollection.add(e1);
        myCollection.add(e2);
        myCollection.add(e3);
    }

}
