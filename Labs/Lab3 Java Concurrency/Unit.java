/*
Laboratory 03 Concurrency Java
Miguel Marines
War Simulation
*/

// Library to generate random numbers.
import java.util.Random;

public class Unit implements Runnable
{
    // Variable from the class Skirmish to use the methods in that class.
    private Skirmish skirmish;

    // Variables to control the attack.
    private int time_attack;
    private int power_attack;

    // Variables to identify the units.
    private int unit_id;
    private int army_id;
    private int life;
    private int live_dead;

    // Contructor of the unit, with the parameters unit id, army id, life and skirmish.
    public Unit(int unit_id, int army_id, int life, int live_dead, Skirmish skirmish)
    {
        this.unit_id = unit_id;
        this.army_id = army_id;
        this.life = life;
        this.live_dead = live_dead;
        this.skirmish = skirmish;
    }

    // Method run, specific to specify tha actions that the threads perform.
    @Override
    public void run()
    {
        try
        {
            System.out.println("Unit " + unit_id + " from the army " + army_id + " is on the battle field ready to fight!");
            while(skirmish.remaining_units_army_1() > 0 && skirmish.remaining_units_army_2() > 0)
            {
                if(unit_id < 19)
                {
                    System.out.println("Unit " + (unit_id + 10) + " from the army " + (army_id + 1) + " attacks unit " + unit_id + " from the army " + army_id);
                    Random random = new Random();
                    time_attack = random.nextInt(5000);
                    power_attack = random.nextInt(20);
                    life = life - 50;
                    Thread.sleep(time_attack);
                    if(life <= 0 && live_dead == 1)
                    {
                        skirmish.loss_unit_army1();
                        live_dead = 0;
                    }
                }
                if(unit_id > 19)
                {
                    System.out.println("Unit " + (unit_id - 10) + " from the army " + (army_id - 1) + " attacks unit " + unit_id + " from the army " + army_id);
                    Random random = new Random();
                    time_attack = random.nextInt(5000);
                    power_attack = random.nextInt(20);
                    life = life - 50;
                    Thread.sleep(time_attack);
                    if(life <= 0 && live_dead == 1)
                    {
                        skirmish.loss_unit_army2();
                        live_dead = 0;
                    }
                }
                if(life <= 0)
                {
                    System.out.println("Unit " + unit_id + " from army " + army_id + "life: 0");
                }
                else
                {
                    System.out.println("Unit " + unit_id + " from army " + army_id + " ife: " + life);
                }
                //skirmish.remaining_units();
            }
            if(skirmish.remaining_units_army_1() > 0)
            {
                System.out.println("Army 1 won the skirmish!");
            }
            if(skirmish.remaining_units_army_2() > 0)
            {
                System.out.println("Army 2 won the skirmish!");
            }
        }
        catch(Exception e)
        {
            // In case something goes wrong in the program.
            System.out.println("\nThe skirmish has ended abruptly by thunder and lighting!");
        }
    }
}