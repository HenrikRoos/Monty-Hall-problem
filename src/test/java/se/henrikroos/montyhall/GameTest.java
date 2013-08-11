package se.henrikroos.montyhall;

import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;

/**
 * Test methods in the file Game.
 *
 * @author Henrik Roos
 */
public class GameTest
{

    /**
     * Test of getCarLocation method return if and only if all doors.
     */
    @Test(timeout = 3000)
    public void testGetCarLocation()
    {
        //Given
        Integer[] doors = {1, 2, 3};
        HashSet<Integer> carLocations = new HashSet<Integer>(doors.length);

        //When, Then
        while (carLocations.size() < doors.length) {
            Game instance = new Game();
            Integer carLocation = instance.getCarLocation();
            assertThat(doors, hasItemInArray(carLocation));
            carLocations.add(carLocation);
        }
    }

    /**
     * Test of getPlayerChoice method return if and only if all doors.
     */
    @Test(timeout = 3000)
    public void testGetPlayerChoice()
    {
        //Given
        Integer[] doors = {1, 2, 3};
        HashSet<Integer> playerChoices = new HashSet<Integer>(doors.length);

        //When, Then
        while (playerChoices.size() < doors.length) {
            Game instance = new Game();
            Integer playerChoice = instance.getPlayerChoice();
            assertThat(doors, hasItemInArray(playerChoice));
            playerChoices.add(playerChoice);
        }
    }

    /**
     * Test of getHostChoice method, run all doors and the host should not pick the
     * car.
     */
    @Test(timeout = 6000)
    public void testGetHostChoice()
    {
        //Given
        Integer[] doors = {1, 2, 3};
        HashSet<Integer> hostChoices = new HashSet<Integer>(doors.length);

        //When, Then
        while (hostChoices.size() < doors.length) {
            Game instance = new Game();
            Integer hostChoice = instance.getHostChoice();
            assertThat(doors, hasItemInArray(hostChoice));
            assertFalse(instance.getCarLocation() == hostChoice);
            assertFalse(instance.getPlayerChoice() == hostChoice);
            hostChoices.add(hostChoice);
        }
    }

    /**
     * Test of shouldChange method, test true and false outcome.
     */
    @Test(timeout = 1000)
    public void testShouldChange()
    {
        //Given
        Boolean[] legalValues = {true, false};
        HashSet<Boolean> results = new HashSet<Boolean>(legalValues.length);

        //When, Then
        while (results.size() < legalValues.length) {
            Game instance = new Game();
            Integer carLocation = instance.getCarLocation();
            Integer playerChoice = instance.getPlayerChoice();
            Boolean result = instance.shouldChange();
            if (result) {
                assertFalse(playerChoice == carLocation);
            } else {
                assertTrue(playerChoice == carLocation);
            }
            results.add(result);
        }
    }
}