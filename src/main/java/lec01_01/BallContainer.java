/**
 * This is part of Lec01_01: Environment Setup and Java Introduction.
 */
package lec01_01;

import java.awt.*;
import java.lang.Iterable;
import java.util.*;

/**
 * This is a container can be used to contain balls.
 * A given ball may only appear in a BallContainer once.
 */
public class BallContainer implements Iterable<Ball> {

    // Contents of the BallContainer.
    private Set<Ball> contents;

    /**
     * Constructor that creates a new ball container.
     */
    public BallContainer() {
        contents = new TreeSet<Ball>((o1, o2) -> {
            if (o1.getVolume() - o2.getVolume() == 0) {
                if (o1 == o2) {
                    return 0;
                } else if (o1.getColor().getRGB() > o2.getColor().getRGB()) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (o1.getVolume() - o2.getVolume() < 0) {
                return -1;
            } else {
                return 1;
            }
        });
    }

    /**
     * Implements the Iterable interface for this container.
     *
     * @return an Iterator over the Ball objects contained
     * in this container
     */
    public Iterator<Ball> iterator() {
        // If we just returned the iterator of "contents", a client
        // could call the remove() method on the iterator and modify
        // it behind our backs.  Instead, we wrap contents in an
        // "unmodifiable set"; calling remove() on this iterator
        // throws an exception.  This is an example of avoiding
        // "representation exposure."  You will learn more about this
        // concept later in the course.
        return Collections.unmodifiableSet(contents).iterator();
    }

    /**
     * Adds a ball to the container. This method returns <tt>true</tt>
     * if the ball was successfully added to the container, i.e., the ball was
     * not already in the container. Of course, you are allowed to put
     * a Ball into a container only once. Hence, this method returns
     * <tt>false</tt>, if the ball is already in the container.
     *
     * @param b ball to be added
     * @return true if the ball was successfully added to the container,
     * i.e., the ball was not already in the container. Returns false, if the ball is
     * already in the container
     */
    public boolean add(Ball b) {
        if (!contents.contains(b)) {
            return contents.add(b);
        }
        return false;
    }

    /**
     * Removes a ball from the container. This method returns
     * <tt>true</tt> if the ball was successfully removed from the
     * container, i.e., the ball was actually in the container. You cannot
     * remove a ball if it is not already in the container, therefore in this
     * case the method returns <tt>false</tt>.
     *
     * @param b ball to be removed
     * @return true if the ball was successfully removed from the container,
     * i.e., the ball was actually in the container. Returns false, if the ball is not
     * in the container
     */
    public boolean remove(Ball b) {
        return contents.remove(b);
    }

    /**
     * Each ball has a volume. This method returns the total volume of
     * all balls in the container.
     *
     * @return the volume of the contents of the container
     */
    public double getVolume() {
        double totalVolume = 0;
        for (Ball ball : contents) {
            totalVolume += ball.getVolume();
        }
        return totalVolume;
    }

    /**
     * Returns the number of balls in this container.
     *
     * @return the number of balls in this container
     */
    public int size() {
        return contents.size();
    }

    /**
     * Returns the number of different colors for the balls in this container.
     *
     * @return the number of different colors for the balls in this container
     */
    public int differentColors() {
        Set<Color> colors = new HashSet<>();
        for (Ball ball : contents) {
            colors.add(ball.getColor());
        }
        return colors.size();
    }

    /**
     * Returns true if all balls in this container have the same color,
     * otherwise returns false.
     *
     * @return true if all balls in this container have the same color,
     * otherwise returns false
     */
    public boolean areSameColor() {
        return !(differentColors() > 1);
    }

    /**
     * Empties the container, i.e., removes all its contents.
     */
    public void clear() {
        contents.clear();
    }

    /**
     * This method returns <tt>true</tt> if this container contains
     * the specified ball. It will return <tt>false</tt> otherwise.
     *
     * @param b ball to be checked if it is in the container
     * @return true if this container contains the specified ball. Returns
     * false otherwise.
     */
    public boolean contains(Ball b) {
        return contents.contains(b);
    }

}