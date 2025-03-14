package com.jad.collection2d;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Collection2D<E extends Collection2DElement<E>> extends HashMap<Point, List<E>> {
    public final void updateElementPosition(final E element, final Point oldPosition) {
        if (element == null) throw new IllegalArgumentException("Element cannot be null.");
        if (oldPosition == null) throw new IllegalArgumentException("Old position cannot be null.");
        final List<E> oldList = this.get(oldPosition);
        if (oldList == null) throw new IllegalArgumentException("Element not found at position " + oldPosition + ".");
        oldList.remove(element);
        if (oldList.isEmpty()) this.remove(oldPosition);
        this.add(element);
    }

    public final void add(final E element) {
        if (element == null) throw new IllegalArgumentException("Element cannot be null.");
        List<E> actualList = this.get(element.getPosition());
        if (actualList == null) actualList = new ArrayList<>();
        actualList.add(element);
        this.put(new Point(element.getPosition()), actualList);
        element.setCollection2D(this);
    }

    public final void remove(final E element) {
        if (element == null) throw new IllegalArgumentException("Element cannot be null.");
        Point position = element.getPosition();
        List<E> actualList = this.get(position);
        if (actualList == null) throw new IllegalArgumentException("Element not found at position " + position + ".");
        actualList.remove(element);
        if (actualList.isEmpty()) this.remove(actualList);
    }

    public final boolean contains(final E element) {
        if (element == null) throw new IllegalArgumentException("Element cannot be null.");
        List<E> actualList = this.get(element.getPosition());
        return ((actualList != null) && (actualList.contains(element)));
    }

    public final Dimension getDimension() {
        int width = 0;
        int height = 0;
        for (Point point : this.keySet()) {
            if (width < point.x) width = point.x;
            if (height < point.y) height = point.y;
        }
        return new Dimension(width + 1, height + 1);
    }
}
