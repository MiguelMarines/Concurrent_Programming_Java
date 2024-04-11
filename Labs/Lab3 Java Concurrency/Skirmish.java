/*
Laboratory 03 Concurrency Java
Miguel Marines
War Simulation
*/

// Class Skirmish
public class Skirmish
{
    // Variabes that help simulate and control the armies.
    private int army_1, army_2;

    // Constructor, with the atributes army_1 and army_2.
    public Skirmish()
    {
        // Army 1 and Army 2 counters.
        army_1 = 5;
        army_2 = 5;
    }

    // Method to simulate the loss of a unit.
    public synchronized void loss_unit_army1()
    {
        army_1 --;
        System.out.println("Army 1 lost a unit!");
    }

    // Method to simulate the loss of a unit.
    public synchronized void loss_unit_army2()
    {
        army_2 --;
        System.out.println("Army 2 lost a unit!");
    }

    // Method to print the remaining units.
    public synchronized void remaining_units()
    {
        System.out.println("Army 1, remaining units: " + army_1);
        System.out.println("Army 2, remaining units: " + army_2);
    }

    // Method to return the remaining units.
    public synchronized int remaining_units_army_1()
    {
        return army_1;
    }
    
    public synchronized int remaining_units_army_2()
    {
        return army_2;
    }
}