/*
Laboratory 01 Concurrency Java
Miguel Marines
*/

public class Race1
{
	public static void main(String args[]) throws InterruptedException
    {
        // // Creates threads with constructor.
        Animal rabbit = new Animal();
        Animal turtle = new Animal();
        
        // Sets the atributes.
        rabbit.setDaemon(false);
        turtle.setDaemon(false);

        rabbit.set_name("Rabbit");
        turtle.set_name("Turtle");

        rabbit.set_min_speed(500);
        turtle.set_min_speed(3);

        rabbit.set_max_speed(1000);
        turtle.set_max_speed(10);

        rabbit.set_rest_min_time(100);
        turtle.set_rest_min_time(0);

        rabbit.set_rest_max_time(200);
        turtle.set_rest_max_time(0);

        rabbit.set_race_distance(10000);
        turtle.set_race_distance(10000);

        rabbit.set_otherAnimal(turtle);
        turtle.set_otherAnimal(rabbit);

        // Starts the threads.
        rabbit.start();
        turtle.start();

        // Waits for threads to finish.
        rabbit.join();
        turtle.join();
    }
}