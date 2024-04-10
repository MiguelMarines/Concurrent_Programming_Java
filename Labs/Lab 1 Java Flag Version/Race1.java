/*
Laboratory 01 Concurrency Java
Miguel Marines
*/

public class Race1
{
	public static void main(String args[]) throws InterruptedException
    {
        int race_distance = 10000;

        // Creates threads with constructor and marks them before they start.
        Animal rabbit = new Animal("Rabbit", 500, 1000, 100, 200, race_distance);
        rabbit.setDaemon(false);

        Animal turtle = new Animal("Turtle", 3, 10, 0, 0, race_distance);
        turtle.setDaemon(false);

        // Starts the threads.
        rabbit.start();
        turtle.start();

        // Waits for threads to finish.
        rabbit.join();
        turtle.join();
    }
}