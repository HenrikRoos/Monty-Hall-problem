package se.henrikroos.montyhall;

import java.util.HashSet;
import org.junit.Test;
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
            assertFalse("Same as car location", instance.getCarLocation()
                    == hostChoice);
            assertFalse("Same as player location", instance.getPlayerChoice()
                    == hostChoice);
            hostChoices.add(hostChoice);
        }
    }

    /**
     * Test of switchDoor method, of class Game.
     */
    @Test(timeout = 6000)
    public void testSwitchDoor()
    {
        //Given
        Integer[] doors = {1, 2, 3};
        HashSet<Integer> switchDoors = new HashSet<Integer>(doors.length);

        //When, Then
        while (switchDoors.size() < doors.length) {
            Game instance = new Game();
            Integer playerChoiceBefore = instance.getPlayerChoice();
            instance.switchDoor();
            Integer playerChoiceAfter = instance.getPlayerChoice();

            assertThat(doors, hasItemInArray(playerChoiceAfter));
            assertFalse("No switch", playerChoiceAfter == playerChoiceBefore);
            assertFalse("Same as host", playerChoiceAfter == instance.getHostChoice());
            switchDoors.add(playerChoiceAfter);
        }
    }

    /**
     * Test of didPalyerWin method, of class Game.
     */
    @Test(timeout = 3000)
    public void testDidPalyerWin()
    {
        //Given
        HashSet<Boolean> result = new HashSet<Boolean>(2);

        //When, Then
        while (result.size() < 2) {
            Game instance = new Game();
            result.add(instance.didPalyerWin());
        }

        result.clear();
        while (result.size() < 2) {
            Game instance = new Game();
            instance.switchDoor();
            result.add(instance.didPalyerWin());
        }
    }
}