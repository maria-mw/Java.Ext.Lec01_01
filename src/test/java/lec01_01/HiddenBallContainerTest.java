/**
 * This is part of HW0: Environment Setup and Java Introduction.
 */
package lec01_01;

import java.awt.Color;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 * BallContainerTest is a glassbox test of the BallContainer class.
 *
 * Recall that the BallContainer is a container for balls. However, you can only
 * put a Ball into a BallContainer once. After you put the Ball into the BallContainer,
 * further attempts to do so will fail, since the Ball is already in
 * the BallContainer! Similarly, you cannot expect to remove a Ball from a BallContainer
 * if it is not inside the BallContainer.
 *
 * @see lec01_01.Ball
 * @see lec01_01.BallContainer
 */
public class HiddenBallContainerTest {

    private static BallContainer ballcontainer = null;
    private static Ball[] b = null;

    private static final int NUM_BALLS_TO_TEST = 3;
    private static final double BALL_UNIT_VOLUME = 20.0;
    private static final double JUNIT_DOUBLE_DELTA = 0.0001;
    private static final Color[] COLORS = {Color.BLUE, 
    		new Color(Color.BLUE.getRGB()),
    		new Color(0, 0, 255)};
    private static final int COLOR_COUNT = COLORS.length;

    @BeforeClass
    public static void setupForTests() throws Exception {

    	assertTrue("Test case error, you must test at least 1 Ball!", NUM_BALLS_TO_TEST > 0);

    	ballcontainer = new BallContainer();

        // Let's create the balls we need.
        b = new Ball[NUM_BALLS_TO_TEST];
        for (int i=0; i<NUM_BALLS_TO_TEST; i++) {
            b[i] = new Ball((i+1)*BALL_UNIT_VOLUME, COLORS[i % COLOR_COUNT]);
        }
    }
    
    /** Test that BallContainer.differentColors() is implemented correctly, hidden */
    @Test
    public void testDifferentColors() {
        ballcontainer.clear();
        assertEquals("The number of different colors of an empty "
        		     + "BallContainer is not zero!",
                     0, ballcontainer.differentColors(), JUNIT_DOUBLE_DELTA);
        for (int i=0; i<NUM_BALLS_TO_TEST; i++) {
            ballcontainer.add(b[i]);
            assertEquals("The number of different colors of a "
            		     + "BallContainer with "+(i+1)+" ball(s)",
            		     1,
                         ballcontainer.differentColors());
        }
    }    

}