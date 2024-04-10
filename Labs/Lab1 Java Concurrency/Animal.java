/*
Laboratory 01 Concurrency Java
Miguel Marines
*/

import java.util.concurrent.ThreadLocalRandom;

public class Animal extends Thread implements Runnable
{
    // Class variables, that are the atributes of the animal.
    private String name;
    private int position, min_speed, max_speed, rest_min_time, rest_max_time, race_distance;

    private static boolean winner = false;

    // Constructor of the animal, with the animal class variables,
    // that are the atributes of the animal.
    public Animal(String name, int min_speed, int max_speed, int rest_min_time, int rest_max_time, int race_distance)
    {
        this.name = name;
        this.min_speed = min_speed;
        this.max_speed = max_speed;
        this.rest_min_time = rest_min_time;
        this.rest_max_time = rest_max_time;
        this.race_distance = race_distance;
    }

    @Override
    public void run()
    {
        // Loop while, that runs while the position of the thread (Animal)
        // is less than the race distance and there is no winner.
        while (this.position <= race_distance && !winner)
        {
            // Prints the name of the thread (Animal) and its position.
            System.out.println(this.name + ": " + this.position + " yards");

            try
            {
                // Resting time of the thread (Animal).
                int rest;

                if(this.rest_max_time == 0)
                {
                    rest = 0;
                }
                else
                {
                    rest = ThreadLocalRandom.current().nextInt(this.rest_min_time, this.rest_max_time + 1);
                }               
            
                //System.out.println(this.name + " Resting Time: " + rest);
                
                // Thread sleeps or waits for the established time.
                // Animal rests the established time.
                if(rest > 0)
                {
                    Animal.sleep(rest);
                }

                // Advance in the position of the race according to the speed of the thread.
                // Advance in the position of the race according to the animal speed.

                int speed = ThreadLocalRandom.current().nextInt(this.min_speed, this.max_speed + 1);
                //System.out.println(this.name + " Speed: " + speed);
                this.position += speed;

                // Salto de linea.
                System.out.println();

            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }

            // When the animal finishes the race.
            if(this.position >= race_distance)
            {
                winner = true;
                
                System.out.println("The race is over!");
                System.out.println(this.name + " won the race!");
            }
        }
    }
}