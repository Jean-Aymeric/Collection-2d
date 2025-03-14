package com.jad.collection2d;

import java.awt.*;

public interface Collection2DElement<E extends Collection2DElement<E>> {
    Point getPosition();
    Collection2D<E> getCollection2D();
    void setCollection2D(final Collection2D<E> collection);
}
