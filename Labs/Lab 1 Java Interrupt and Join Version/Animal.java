/*
Laboratory 01 Concurrency Java
Miguel Marines
*/

import java.util.concurrent.ThreadLocalRandom;

public class Animal extends Thread implements Runnable
{
    // Class variables, that are the atributes of the animal.
    Thread otherAnimal;
    private String name;
    private int position, min_speed, max_speed, rest_min_time, rest_max_time, race_distance;

    // Setters to set the atributes of the animal.
    void set_name(String name)
    {
        this.name = name;
    }

    void set_min_speed(int min_speed)
    {
        this.min_speed = min_speed;
    }

    void set_max_speed(int max_speed)
    {
        this.max_speed = max_speed;
    }

    void set_rest_min_time(int rest_min_time)
    {
        this.rest_min_time = rest_min_time;
    }

    void set_rest_max_time(int rest_max_time)
    {
        this.rest_max_time = rest_max_time;
    }

    void set_race_distance(int race_distance)
    {
        this.race_distance = race_distance;
    }
    
    void set_otherAnimal(Thread otherAnimal)
    {
        this.otherAnimal = otherAnimal;
    }

    @Override
    public void run()
    {
        // Loop while, that runs while the position of the thread (Animal)
        // is less than the race distance and there is no winner.
        while (this.position <= race_distance)
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
            
                System.out.println(this.name + " Resting Time: " + rest);
                
                // Thread sleeps or waits for the established time.
                // Animal rests the established time.
                if(rest > 0)
                {
                    Animal.sleep(rest);
                }

                // Advance in the position of the race according to the speed of the thread.
                // Advance in the position of the race according to the animal speed.

                int speed = ThreadLocalRandom.current().nextInt(this.min_speed, this.max_speed + 1);
                System.out.println(this.name + " Speed: " + speed);
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
                if(otherAnimal.isAlive())
                {
                    otherAnimal.interrupt();
                    otherAnimal.join();
                }

                System.out.println("The race is over!");
                System.out.println(this.name + " won the race!");
            }
        }
    }
}