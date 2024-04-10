/*
Laboratory 01 Concurrency Java
Miguel Marines
*/

public class Race3
{
	public static void main(String args[]) throws InterruptedException
    {
        int race_distance = 1000;

        // Creates threads with constructor and marks them before they start.
        Animal rabbit = new Animal("Rabbit", 50, 100, 10, 20, race_distance);
        rabbit.setDaemon(false);

        Animal turtle = new Animal("Turtle", 10, 30, 0, 10, race_distance);
        turtle.setDaemon(false);

        // Starts the threads.
        rabbit.start();
        turtle.start();

        // Waits for threads to finish.
        rabbit.join();
        turtle.join();
    }
}