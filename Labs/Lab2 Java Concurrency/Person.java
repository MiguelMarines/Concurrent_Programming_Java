/*
Laboratory 02 Concurrency Java
Miguel Marines
*/

// Library to generate random numbers.
import java.util.Random;

public class Person implements Runnable
{
    // Variable garden from the class botanical garden to use the methods in that class.
    private Botanical_Garden botanical_garden;

    // Variables to control the time.
    private int time_in_botanical_garden, time_out_botanical_garden;

    // Variable to identify the persons.
    private int person_id;
    
    // Variables to 
    private boolean east_door_entrance, east_door_exit;

    // Constructor of the person, with the atributes person id and botanical garden.
    public Person (int person_id, Botanical_Garden botanical_garden)
    {
        this.person_id = person_id;
        this.botanical_garden = botanical_garden;

        // Creates an object of the Random class to generate random numbers.
        Random random = new Random();

        // Generates random numbers to wait out of the garden and to stay in the garden.
        time_in_botanical_garden = random.nextInt(20000);
        time_out_botanical_garden = random.nextInt(2500);
        
        // Selects random through which door the person is going to acces.
        east_door_entrance = random.nextBoolean();
        east_door_exit = random.nextBoolean();
    }

    // Method run, specific to specify the actions that the threads perform.
    @Override
    public void run()
    {
        try
        {
            // Person on line waiting to enter to the botanical garden.
            System.out.println("Person " + person_id + " is on line waiting to enter the Botanical Garden.");
            System.out.println("Estimated waiting time: " + time_out_botanical_garden);
            Thread.sleep(time_out_botanical_garden);

            // Person enters the botanical garden through the east door.
            if(east_door_entrance)
            {
                System.out.println("Person " + person_id + " enters the Botanical Garden through the East door.");
                botanical_garden.east_door_entrance();
            }
            // Person enters the botanical garden through the west door.
            else
            {
                System.out.println("Person " + person_id + " enters the Botanical Garden through the West door.");
                botanical_garden.west_door_entrance();
            }
            // Person stays random time in botanical garden.
            Thread.sleep(time_in_botanical_garden);
            
            // Person exits the botanical garden through the east door.
            if(east_door_exit)
            {
                System.out.println("Person " + person_id + " exits the Botanical Garden through the East door.");
                botanical_garden.east_door_exit();
            }
            // Person exits the botanical garden through the west door.
            else
            {
                System.out.println("Person " + person_id + " exits the Botanical Garden through the West door.");
                botanical_garden.west_door_exit();
            }
        }
        catch (Exception e)
        {
            // In case something goes wrong in the program.
            System.out.println("\n");
            System.out.println("The program has presented a problem!");
            System.out.println("Please, contact the IT department.");
        }   
    }
}