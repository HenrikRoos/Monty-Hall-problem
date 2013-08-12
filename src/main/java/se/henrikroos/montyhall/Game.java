package se.henrikroos.montyhall;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/**
 * Playing one game of Monty Hall. Should the player swish the door?
 *
 * @author hero
 */
public class Game
{

    private int carLocation;
    private int playerChoice;

    /**
     * Create an instance with randomized car location and player choice.
     */
    public Game()
    {
        carLocation = getRandomNumber();
        playerChoice = getRandomNumber();
    }

    /**
     * Did the palyer win the game?
     *
     * @return true or false
     */
    public boolean didPalyerWin()
    {
        return playerChoice == carLocation;
    }

    /**
     * The player switch the door after the host open one door. Use
     *
     * @see getPlayerChoice() for get the new door.
     */
    public void switchDoor()
    {
        Integer[] doors = {1, 2, 3};
        TreeSet<Integer> doorsSet = new TreeSet<Integer>(Arrays.asList(doors));
        doorsSet.remove(playerChoice);
        doorsSet.remove(getHostChoice());
        playerChoice = doorsSet.first();
    }

    /**
     * The host, who knows what's behind the doors, opens this door.
     *
     * @return 1, 2 or 3
     */
    int getHostChoice()
    {
        Integer[] doors = {1, 2, 3};
        TreeSet<Integer> doorsSet = new TreeSet<Integer>(Arrays.asList(doors));
        doorsSet.remove(carLocation);
        doorsSet.remove(playerChoice);
        return doorsSet.first();
    }

    /**
     * Get the location where the car is (the price), door 1, 2 or 3.
     *
     * @return 1, 2 or 3
     */
    int getCarLocation()
    {
        return carLocation;
    }

    /**
     * Get the players first choice, door 1, 2 or 3.
     *
     * @return 1, 2 or 3
     */
    int getPlayerChoice()
    {
        return playerChoice;
    }

    /**
     * Get a number 1, 2, or 3, randomize.
     *
     * @return 1, 2 or 3
     */
    private int getRandomNumber()
    {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
}
