package se.henrikroos.montyhall;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

/**
 * Test the class GameSet.
 *
 * @author Henrik Roos
 */
public class GameSetTest
{

    /**
     * Test of isItBetterToSwitch method, winsOnSwitching > winsOnNotSwitching
     */
    @Test
    public void testShouldSwitchDoor()
    {
        //Given
        short winsOnSwitching = 2;
        short winsOnNotSwitching = 1;
        String expected = "yes";

        //When
        String actual = GameSet.isItBetterToSwitch(winsOnSwitching,
                winsOnNotSwitching);

        //Then
        assertEquals(expected, actual);
    }

    /**
     * Test of isItBetterToSwitch method, winsOnSwitching < winsOnNotSwitching
     */
    @Test
    public void testShouldNotSwitchDoor()
    {
        //Given
        short winsOnSwitching = 1;
        short winsOnNotSwitching = 2;
        String expected = "no";

        //When
        String actual = GameSet.isItBetterToSwitch(winsOnSwitching,
                winsOnNotSwitching);

        //Then
        assertEquals(expected, actual);
    }

    /**
     * Test of isItBetterToSwitch method, winsOnSwitching = winsOnNotSwitching
     */
    @Test
    public void testNoMatterToSwitchDoor()
    {
        //Given
        short winsOnSwitching = 1;
        short winsOnNotSwitching = 1;
        String expected = "no matter";

        //When
        String actual = GameSet.isItBetterToSwitch(winsOnSwitching,
                winsOnNotSwitching);

        //Then
        assertEquals(expected, actual);
    }

    /**
     * Test of toNumber method. Not contain a parsable short.
     */
    @Test(expected = NumberFormatException.class)
    public void testToNumberNoNumber()
    {
        //Given
        String[] args = {"2389472"};

        //When
        GameSet.toNumber(args);
    }

    /**
     * Test of toNumber method. No arguments
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToNumberEmptyArgs()
    {
        //Given
        String[] args = {};

        //When
        GameSet.toNumber(args);
    }

    /**
     * Test of toNumber method.
     */
    @Test
    public void testToNumber()
    {
        //Given
        String[] args = {"100"};
        short expected = (short) 100;

        //When
        short actual = GameSet.toNumber(args);

        //Then
        assertEquals(expected, actual);
    }

    /**
     * Test of countWinsOnSwitching method, minium of games (0).
     */
    @Test
    public void testCountWinsOnSwitching_Min()
    {
        //Given
        short number = 0;
        short expected = 0;

        //When
        short actual = GameSet.countWinsOnSwitching(number);

        //Then
        assertEquals(expected, actual);
    }

    /**
     * Test of countWinsOnSwitching method, maximum of games (32767).
     */
    @Test
    public void testCountWinsOnSwitching_Max()
    {
        //Given
        short number = (short) 32767;
        short expectedMin = 0;
        short expectedMax = number;

        //When
        short actual = GameSet.countWinsOnSwitching(number);

        //Then
        assertThat(actual, greaterThanOrEqualTo(expectedMin));
        assertThat(actual, lessThanOrEqualTo(expectedMax));
    }

    /**
     * Test of countWinsOnSwitching method, there argument is negative.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testCountWinsOnSwitching_Negative()
    {
        //Given
        short number = (short) 32768;

        //When
        GameSet.countWinsOnSwitching(number);
    }

    /**
     * Test of countWinsOnNotSwitching method, minium of games (0).
     */
    @Test
    public void testCountWinsOnNotSwitching_Min()
    {
        //Given
        short number = 0;
        short expected = 0;

        //When
        short actual = GameSet.countWinsOnNotSwitching(number);

        //Then
        assertEquals(expected, actual);
    }

    /**
     * Test of countWinsOnNotSwitching method, maximum of games (32767).
     */
    @Test
    public void testCountWinsOnNotSwitching_Max()
    {
        //Given
        short number = (short) 32767;
        short expectedMin = 0;
        short expectedMax = number;

        //When
        short actual = GameSet.countWinsOnNotSwitching(number);

        //Then
        assertThat(actual, greaterThanOrEqualTo(expectedMin));
        assertThat(actual, lessThanOrEqualTo(expectedMax));
    }

    /**
     * Test of countWinsOnNotSwitching method, there argument is negative.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testCountWinsOnNotSwitching_Negative()
    {
        //Given
        short number = (short) 32768;

        //When
        GameSet.countWinsOnNotSwitching(number);
    }
}