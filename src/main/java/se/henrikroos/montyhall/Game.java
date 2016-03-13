package se.henrikroos.montyhall;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/**
 * Playing the game of Monty Hall. Should the player switch the door or not?
 *
 * @author Henrik Roos
 */
public class Game
{

    private int carLocation;
    private int playerChoice;

    /**
     * Start a game where the car location and the players choice is random.
     */
    public Game()
    {
        carLocation = getRandomNumber();
        playerChoice = getRandomNumber();
    }

    /**
     * Did the player win the game?
     *
     * @return true or false
     */
    public boolean didPalyerWin()
    {
        return playerChoice == carLocation;
    }

    /**
     * The player can switch the door after the host opens one of the doors. 
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
     * The host opens this door.
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
     * Get the location where the price is (the car), door 1, 2 or 3.
     *
     * @return 1, 2 or 3
     */
    int getCarLocation()
    {
        //return carLocation;
	return 3;
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
