package se.henrikroos.montyhall;

/**
 * Run a set of the Monty Hall game.
 *
 * @author Henrik Roos
 */
public class GameSet
{

    public static void main(String[] args)
    {
        try {
            short number = toNumber(args);
            short winsOnNotSwitching = countWinsOnNotSwitching(number);
            short winsOnSwitching = countWinsOnSwitching(number);

            System.out.println("\nNumber of games: " + number);
            System.out.println("-----------------------");
            System.out.println(
                    "Number of wins when the player do not switch door: "
                    + winsOnNotSwitching);
            System.out.println(
                    "Number of wins when the player do switch door:     "
                    + winsOnSwitching);
            System.out.println(
                    "Is it better to switch the door?                   "
                    + isItBetterToSwitch(winsOnSwitching, winsOnNotSwitching) + "\n");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Is it better to switch? winsOnSwitching > winsOnNotSwitching : yes
     * winsOnSwitching < winsOnNotSwitching : no winsOnSwitching = winsOnNotSwitching
     * : no matter
     *
     * @param winsOnSwitching Number of wins when switching door
     * @param winsOnNotSwitching Number of wins when not switching door
     *
     * @return "no matter", "yes" or "no"
     */
    static String isItBetterToSwitch(short winsOnSwitching, short winsOnNotSwitching)
    {
        if (winsOnSwitching == winsOnNotSwitching) {
            return "no matter";
        }
        return winsOnSwitching > winsOnNotSwitching ? "yes" : "no";
    }

    /**
     * Parse the terminal arguments and try convert to a number
     *
     * @throws IllegalArgumentException No arguments
     * @throws NumberFormatException If the string does not contain a parsable short.
     *
     * @param args an Array of strings.
     *
     * @return First argument as a number
     */
    static short toNumber(String[] args)
    {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                    "Enter the number of games you will run as argument.");
        }
        try {
            return Short.parseShort(args[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The argument must be >= 0 and <= 32767");
        }
    }

    /**
     * Run $number of games where the player swith the door efter the host open one
     * door. Count number of prize.
     *
     * @throws IndexOutOfBoundsException Only positive number
     *
     * @param number How many games will you run.
     *
     * @return number of prizes
     */
    static short countWinsOnSwitching(short number)
    {
        if (number < 0) {
            throw new IndexOutOfBoundsException(
                    "The argument must be >= 0 and <= 32767");
        }
        short countWins = 0;
        for (short i = 0; i < number; i++) {
            Game game = new Game();
            game.switchDoor();
            countWins += game.didPalyerWin() ? 1 : 0;
        }
        return countWins;
    }

    /**
     * Run $number of games where the player NOT swith the door efter the host open
     * one door. Count number of prize.
     *
     * @throws IndexOutOfBoundsException Only positive number
     *
     * @param number How many game will you run.
     *
     * @return number of prizes
     */
    static short countWinsOnNotSwitching(short number)
    {
        if (number < 0) {
            throw new IndexOutOfBoundsException(
                    "The argument must be >= 0 and <= 32767");
        }
        short countWins = 0;
        for (short i = 0; i < number; i++) {
            Game game = new Game();
            countWins += game.didPalyerWin() ? 1 : 0;
        }
        return countWins;
    }
}
