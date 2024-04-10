/*
Laboratory 02 Concurrency Java
Miguel Marines
*/

public class Botanical_Garden
{
    /* Variables that help simulate and control
    the entrance and exit of persons from the botanical garden. */
    private int east_door, west_door;
    
    // Constructor, with the atributes east door and west door.
    public Botanical_Garden()
    {
        // East and West door counters.
        east_door = 0;
        west_door = 0;
    }

    // Method to simulate the entrance of a person through the East door.
    public synchronized void east_door_entrance()
    {
        east_door ++;
        System.out.println("Persons in the Botanical Garden: " + number_persons_in());
    }
    
    // Method to simulate the entrance of a person through the West door.
    public synchronized void west_door_entrance()
    {
        west_door ++;
        System.out.println("Persons in the Botanical Garden: " + number_persons_in());
    }
    
    // Method to simulate the exit of a person through the East door.
    public synchronized void east_door_exit()
    {
        east_door --;
        System.out.println("Persons in the Botanical Garden: " + number_persons_in());
    }
    
    // Method to simulate the exit of a person through the West door.
    public synchronized void west_door_exit()
    {
        west_door --;
        System.out.println("Persons in the Botanical Garden: " + number_persons_in());
    }
    
    // Method that returns the number of persons inside the botanical garden.
    public synchronized int number_persons_in()
    {
        if ((east_door + west_door) == 0)
        {
            System.out.println("There is no more persons in the botanical garden.");
            System.out.println("The botanical garden is empty.");
        }

        return east_door + west_door;
    }
}