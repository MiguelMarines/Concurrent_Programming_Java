/*
Laboratory 03 Concurrency Java
Miguel Marines
War Simulation
*/

// Class Main
public class Main
{
    // Main to run the program.
    public static void main(String[] args)
    {
        // Creates skirmish object from the class Skirmish.
        Skirmish skirmish = new Skirmish();

        // Prints beginning of the war.
        System.out.println("\nBEGINNING OF SKIRMISH!");

        // Creation of units objects of the Army 1.
        Unit unit11 = new Unit(11, 1, 100, 1, skirmish);
        Unit unit12 = new Unit(12, 1, 100, 1, skirmish);
        Unit unit13 = new Unit(13, 1, 100, 1, skirmish);
        Unit unit14 = new Unit(14, 1, 100, 1, skirmish);
        Unit unit15 = new Unit(15, 1, 100, 1, skirmish);

        // Creation of units objects of the Army 2.
        Unit unit21 = new Unit(21, 2, 100, 1, skirmish);
        Unit unit22 = new Unit(22, 2, 100, 1, skirmish);
        Unit unit23 = new Unit(23, 2, 100, 1, skirmish);
        Unit unit24 = new Unit(24, 2, 100, 1, skirmish);
        Unit unit25 = new Unit(25, 2, 100, 1, skirmish);

        // Creates an array of threads from the class Thread, according to the number of units.
        Thread threads[] = new Thread[10];

        // Creates thread objects from the class Thread and stores them in the threads array.
        threads[0] = new Thread(unit11);
        threads[1] = new Thread(unit12);
        threads[2] = new Thread(unit13);
        threads[3] = new Thread(unit14);
        threads[4] = new Thread(unit15);
        threads[5] = new Thread(unit21);
        threads[6] = new Thread(unit22);
        threads[7] = new Thread(unit23);
        threads[8] = new Thread(unit24);
        threads[9] = new Thread(unit25);

        // Starts the threads.
        for(int i = 0; i < 10; i++)
        {
            threads[i].start();
        }
    }
    
}