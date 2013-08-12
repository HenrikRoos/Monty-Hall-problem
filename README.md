Monty-Hall-problem
==================

The Monty Hall problem is a probability puzzle, loosely based on the American television game show Let's Make a Deal and named after the show's original host, Monty Hall.

##Problem
Suppose you're on a game show, and you're given the choice of three doors: Behind one door is a car; behind the others, goats. You pick a door, say No. 1, and the host, who knows what's behind the doors, opens another door, say No. 3, which has a goat. He then says to you, "Do you want to pick door No. 2?" Is it to your advantage to switch your choice?

##Task
Write a program in Java randomly simulating this event over and over again in the quest of answering following question. Do I stand a better chance to win if I change my mind? Maven should be used.

##Install and Run
    $ git clone https://github.com/HenrikRoos/Monty-Hall-problem
    $ cd Monty-Hall-problem/
    $ mvn package
    $ java -jar target/montyhall.jar 1000
*Note: 1000 is number of games*
