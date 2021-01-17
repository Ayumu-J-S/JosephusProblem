//Josephus.java
//The main class for Josephus problem

/**
    The driver class for the Josephus problem.
    @author Ayumu S.
*/
public class Josephus
{
    public static void main(String [] args)
    {
        if (args.length == 0)
        {
            OpeningScreen openingScreen = new OpeningScreen
            (
                "Ayumu S",
                "Joshepus.java",
                "Solving the Josephus Problem"
            );
            openingScreen.display();
            TextItems textItems = new TextItems
            (
                Josephus.class.getResourceAsStream("Josephus.txt")
            );
            textItems.displayItem("ProgramDescription");
        }
        else
        {

            //Create variables
            int numZealots, eliminationGap, seed;

            //Initialize variables
            numZealots = Integer.parseInt(args[0]);
            eliminationGap = Integer.parseInt(args[1]);

            //Initialize seed
            if (args.length < 3)
            {
                seed = -1;
            }
            else
            {
                seed = Integer.parseInt(args[2]);
            }

            //Create randamized circular linked node of sealots
            ZealotCircle zealots = new ZealotCircle
            (
                numZealots, eliminationGap, seed
            );

            //Show all the zealots
            System.out.println("");
            System.out.println
            (
                "Here is the full \"circle of zealots\","
                + " including our friend Joe:"
            );
            zealots.displayAllZealots();
            System.out.println("");

            //Eliminate the zealots
            zealots.eliminateZealots();

            //Advise Josephus
            zealots.adviseJosephus();
            System.out.println("");

            //Pause before ending the program
            Utils.pause();
        }
    }
}
