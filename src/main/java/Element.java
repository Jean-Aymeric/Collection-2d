import com.jad.collection2d.Collection2D;
import com.jad.collection2d.Collection2DElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
class Element implements Collection2DElement<Element> {

    final private String name;
    private Point position;
    @Setter
    private Collection2D<Element> collection2D;

    public Element(final String name, final int x, final int y) {
        this.name = name;
        this.position = new Point(x, y);
    }

    public void setPosition(final int x, final int y) {
        final Point oldPosition = new Point(this.position);
        this.position.x = x;
        this.position.y = y;
        if (this.collection2D != null) this.collection2D.updateElementPosition(this, oldPosition);
    }
}
