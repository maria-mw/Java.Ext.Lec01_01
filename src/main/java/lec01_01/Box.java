/**
 * This is part of Lec01_01: Environment Setup and Java Introduction.
 */
package lec01_01;

import java.lang.Iterable;
import java.util.*;

/**
 * This is a container that can be used to contain Balls. The key
 * difference between a BallContainer and a Box is that a Box has a
 * finite volume. Once a box is full, a client cannot put in more Balls.
 */
public class Box implements Iterable<Ball> {

    /**
     * ballContainer is used to internally store balls for this Box
     */
    private BallContainer ballContainer;
    private final double volume;

    /**
     * Constructor that creates a new box.
     *
     * @param maxVolume Total volume of balls that this box can contain.
     */
    public Box(double maxVolume) {
        this.ballContainer = new BallContainer();
        this.volume = maxVolume;
    }

    /**
     * Implements the Iterable interface for this box.
     *
     * @return an Iterator over the Ball objects contained
     * in this box.
     */
    public Iterator<Ball> iterator() {
        return ballContainer.iterator();
    }


    /**
     * This method is used to add Ball objects to this box of
     * finite volume.  The method returns true if a ball is
     * successfully added to the box, i.e., the ball is not already in the
     * box and if the box is not already full; and it returns false,
     * if the ball is already in the box or if the box is too full
     * to fit the new ball.
     *
     * @param b Ball to be added.
     * @return true if the ball was successfully added to the box,
     * i.e., the ball is not already in the box and if the box is not
     * already full. Returns false, if the ball is already in the box or
     * if the box is too full to fit the new ball.
     */
    public boolean add(Ball b) {
        if (this.volume >= (this.ballContainer.getVolume() + b.getVolume())) {
            return ballContainer.add(b);
        }
        return false;
    }

    /**
     * This method returns an iterator that iterates over all balls in
     * this box in ascending order by their size, i.e., it returns the
     * smallest Ball first, followed by Balls of increasing size.
     *
     * @return an iterator that returns all balls in this box in
     * ascending order by Ball size.
     */
    public Iterator<Ball> getBallsFromSmallest() {
//        Set<Ball> balls = new TreeSet<>((o1, o2) -> {
//            if (o1.getVolume() > o2.getVolume()) {
//                return 1;
//            } else if (o1.getVolume() == o2.getVolume()) {
//                if (o1 == o2) {
//                    return 0;
//                } else if (o1.getColor().getRGB() > o2.getColor().getRGB()) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            } else {
//                return -1;
//            }
//        });
//        for (Ball ball : ballContainer) {
//            balls.add(ball);
//        }
        List<Ball> sortedBalls = new ArrayList<>();
        for (Ball b : ballContainer) {
            sortedBalls.add(b);
        }
        Collections.sort(sortedBalls, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                if (o1.getVolume() < o2.getVolume()) {
                    return -1;
                } else if (o1.getVolume() == o2.getVolume()) {
                    return 0;
            } else {
                return 1;}
            }
        });
        return sortedBalls.iterator();
//        return Collections.unmodifiableSet(balls).iterator();
    }

    /**
     * Removes a ball from the box. This method returns
     * <tt>true</tt> if the ball was successfully removed from the
     * container, i.e., the ball was actually in the box. You cannot
     * remove a Ball if it is not already in the box, therefore in this
     * case the method returns <tt>false</tt>.
     *
     * @param b Ball to be removed.
     * @return true if the ball was successfully removed from the box,
     * i.e., the ball was actually in the box. Returns false, if the ball is not
     * in the box.
     */
    public boolean remove(Ball b) {
        return ballContainer.remove(b);
    }

    /**
     * Each Ball has a volume. This method returns the total volume of
     * all Balls in the box.
     *
     * @return the volume of the contents of the box.
     */
    public double getVolume() {
        return ballContainer.getVolume();
    }

    /**
     * Returns the number of Balls in this box.
     *
     * @return the number of Balls in this box.
     */
    public int size() {
        return ballContainer.size();
    }

    /**
     * Empties the box, i.e., removes all its contents.
     */
    public void clear() {
        ballContainer.clear();
    }

    /**
     * This method returns <tt>true</tt> if this box contains
     * the specified Ball. It returns <tt>false</tt> otherwise.
     *
     * @param b Ball to be checked if its in box
     * @return true if this box contains the specified Ball. Returns
     * false otherwise.
     */
    public boolean contains(Ball b) {
        return ballContainer.contains(b);
    }

}
