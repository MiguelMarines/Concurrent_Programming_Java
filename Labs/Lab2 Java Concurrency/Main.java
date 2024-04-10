/*
Laboratory 02 Concurrency Java
Miguel Marines
*/

// Library to scan inputs from the user.
import java.util.Scanner;

public class Main
{
    // Main to run the program.
    public static void main(String[] args)
    {
        // Creates garden object from the class Garden.
        Botanical_Garden botanical_garden = new Botanical_Garden();
        
        System.out.println("\n ________________________________________________________________________");
        System.out.println("|                                                                        |");
        System.out.println("|                             Vive Mexico                                |");
        System.out.println("|                    Mexico City's Botanical Garden                      |");
        System.out.println("|________________________________________________________________________|");
        System.out.print("\nNumber of Visitors for Today: ");

        // Creates scanner object to get the input from the user.
        Scanner input = new Scanner(System.in);

        // Variable to store the number of visitors.
        int number_visitors;

        // Number of visitors provided by the user with an input.
        number_visitors = input.nextInt();
        input.close();

        // Creates an array of the type person from the class Person, according to the number of visitors.
        Person persons[] = new Person[number_visitors];
        
        // Creates an array of threads from the class Thread, according to the number of visitors.
        Thread threads[] = new Thread[number_visitors];
        
        // The for loop:
        // 1. Creates person objects from the class Person and stores them in the persons array.
        // 2. Creates threads objects from the class Thread and stores them in the threads array.
        // 3. Starts the threads.
        for(int i = 0; i < number_visitors; i++)
        {
            persons[i] = new Person(i, botanical_garden);
            threads[i] = new Thread(persons[i]);
            threads[i].start();
        }
    }
}