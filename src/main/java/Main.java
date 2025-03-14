import com.jad.collection2d.Collection2D;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Collection2D<Element> myCollection = new Collection2D<>();
        Element e1 = new Element("E1", 10, 4);
        Element e2 = new Element("E2", 9, 3);
        Element e3 = new Element("E3", 1, 1);
        myCollection.add(e1);
        myCollection.add(e2);
        myCollection.add(e3);
        Dimension dimension = myCollection.getDimension();
        for (int row = 0; row < dimension.height; row++) {
            for (int column = 0; column < dimension.width; column++) {
                List<Element> list = myCollection.get(new Point(column, row));
                if (list == null) {
                    System.out.print("-- ");
                } else {
                    System.out.print(list.get(0).getName());
                }
            }
            System.out.println();
        }
        e2.setPosition(100, 11);

        System.out.println();
        dimension = myCollection.getDimension();
        for (int row = 0; row < dimension.height; row++) {
            for (int column = 0; column < dimension.width; column++) {
                List<Element> list = myCollection.get(new Point(column, row));
                if (list == null) {
                    System.out.print("-- ");
                } else {
                    System.out.print(list.get(0).getName());
                }
            }
            System.out.println();
        }
    }

}
