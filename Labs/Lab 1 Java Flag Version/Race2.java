/*
Laboratory 01 Concurrency Java
Miguel Marines
*/

public class Race2
{
	public static void main(String args[]) throws InterruptedException
    {
        int race_distance = 100;

        // Creates threads with constructor and marks them before they start.
        Animal rabbit = new Animal("Rabbit", 5, 15, 100, 200, race_distance);
        rabbit.setDaemon(false);

        Animal turtle = new Animal("Turtle", 1, 3, 0, 50, race_distance);
        turtle.setDaemon(false);

        // Starts the threads.
        rabbit.start();
        turtle.start();

        // Waits for threads to finish.
        rabbit.join();
        turtle.join();
    }
}