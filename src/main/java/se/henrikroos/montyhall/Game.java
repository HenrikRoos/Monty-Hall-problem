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

    public Game()
    {
        carLocation = getRandomNumber();
        playerChoice = getRandomNumber();
    }

    /**
     * Get the location where the car is (the price), door 1, 2 or 3.
     *
     * @return 1, 2 or 3
     */
    public int getCarLocation()
    {
        return carLocation;
    }

    /**
     * Get the players first choice, door 1, 2 or 3.
     *
     * @return 1, 2 or 3
     */
    public int getPlayerChoice()
    {
        return playerChoice;
    }

    /**
     * The host, who knows what's behind the doors, opens this door.
     *
     * @return 1, 2 or 3
     */
    public int getHostChoice()
    {
        Integer[] doors = {1, 2, 3};
        TreeSet<Integer> doorsSet = new TreeSet<Integer>(Arrays.asList(doors));
        doorsSet.remove(carLocation);
        doorsSet.remove(playerChoice);
        return doorsSet.first();
    }

    /**
     * Should the player switch the door for pick the car?
     *
     * @return true or false
     */
    public boolean shouldChange()
    {
        return playerChoice != carLocation;
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
