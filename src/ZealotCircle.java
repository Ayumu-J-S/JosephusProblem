//ZealotCircle.java
//Class for making Circled linked node that also contains methods for it

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
    A class for creating a "circle of zealots" in which every nth zealot
    is eliminated until only one remains (and survives), and advising a
    particular member of that circle (Josepus, or "Joe") which position
    he should occupy to avoid elimination.
    @author Ayumu S.
*/
public class ZealotCircle
{

    //Create intant variables
    private int numberOfZealots, eliminationGap;
    private Node head = new Node();

    //Create and initilize Zealots
    private final String[] ZEALOT_NAMES =
    {
        "Ace", "Ada", "Ali", "Amy", "Ann", "Art", "Ava", "Bea", "Ben", "Bob",
        "Boz", "Cal", "Cam", "Dag", "Dan", "Deb", "Don", "Dot", "Eva", "Eve",
        "Fay", "Gil", "Guy", "Hal", "Ian", "Jan", "Jim", "Joe", "Kay", "Ken",
        "Kim", "Liz", "Mac", "Nan", "Ora", "Pam", "Red", "Rex", "Rik", "Rip",
        "Rob", "Rod", "Ron", "Roy", "Sam", "Tim", "Tom", "Uma", "Val", "Wes"
    };

    public ZealotCircle(int numberOfZealots, int eliminationGap, int seed)
    {
        //Set the eliminationGap
        this.eliminationGap = eliminationGap;

        //Set number of Zealots
        this.numberOfZealots = numberOfZealots;

        //Create Array of the names
        ArrayList<String> ZealotSwap
            = new ArrayList<>(Arrays.asList((ZEALOT_NAMES)));

        //Randimize the oreder of names
        if (seed >= 0)
        {
            Collections.shuffle(ZealotSwap, new Random(seed));
        }
        else
        {
            Collections.shuffle(ZealotSwap);
        }

        //Create a new Array with radamized name
        ArrayList<String> ZealotRandom = new ArrayList<>();

        //Take some elements from ZealotSwap and store them in ZealotRandom
        for (int i = 0; i < numberOfZealots; i++)
        {
            ZealotRandom.add(ZealotSwap.get(i));
        }

        //If the array doesn't have Joe, delete the last element and
        //put Joe in the last place
        if (!ZealotRandom.contains("Joe"))
        {
            ZealotRandom.remove(numberOfZealots - 1);
            ZealotRandom.add("Joe");
        }

        //Randamize ZealotRandom
        if (seed >= 0)
        {
            Collections.shuffle(ZealotRandom, new Random(seed));
        }
        else
        {
            Collections.shuffle(ZealotRandom);
        }

        //Create circular linked node of Zealots
        //Put the first zealot in the first position of liked nodes
        head.name = ZealotRandom.get(0);

        //Create and initilize the varible
        Node a = null;

        //Link one Zealot each time
        for (int i = 1; i < numberOfZealots; i++)
        {
            if (i == 1)
            {
                a = new Node();
                a.name = ZealotRandom.get(i);
                head.next = a;
            }
            else
            {
                a.next = new Node();

                a = a.next;
                a.name = ZealotRandom.get(i);
            }
        }

        //Link the last node to the first node
        a.next = head;

    }//end of constructor

    /**
        Display the names of all current zealots in their current order,
        15 per line.
    */
    public void displayAllZealots()
    {
        //Set head node as current node
        Node currentNode = head;

        //Display 15 nodes for each line
        for (int i = 0; i < numberOfZealots / 15; i++)
        {
            for (int j = i; j < i + 15; j++)
            {
                System.out.print(currentNode.name + " ");
                currentNode = currentNode.next;
            }
            System.out.println("");
        }

        //Display nodes that are left over
        for (int i = 0; i < numberOfZealots % 15; i++)
        {
            System.out.print(currentNode.name + " ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

    /**
        Eliminate all but the last zealot, which is thus the one in the
        position that Josepus (Joe) should be occupying when the process
        starts, and advise Josephus accordingly. If there is only one zealot
        in the circle to begin with, it must (of course) be Joe. The name of
        each victim is reported after each elimination, and a list of all
        remaining zealots after that elimination is displayed, followed by
        a pause.
    */
    public void eliminateZealots()
    {
        //Create variables needed to implement this method
        Node currentNode = head, prev = null;
        int numIterate = numberOfZealots - 1;

        //Display how many the eliminationGap is
        System.out.println
        (
            "The elimination gap is " + eliminationGap
            + " and now we start the elimination:"
        );
        System.out.println("");

        //Eliminate one element each time
        for (int j = 0; j < numIterate; j++)
        {
            if (j == 0)
            {
                for (int i = 0; i < eliminationGap - 1; i++)
                {
                    prev = currentNode;
                    currentNode = currentNode.next;
                }
            }
            else
            {
                for (int i = 0; i < eliminationGap; i++)
                {
                    prev = currentNode;
                    currentNode = currentNode.next;
                }
            }

            //Inform the user which element is removed
            System.out.println
            (
                "The current victim is " + prev.next.name
                + " and here are the remaining zealots:"
            );

            //Eliminate the element
            if (prev.next == head)
            {
                prev.next = head.next;
                head = currentNode.next;
            }
            else
            {
                prev.next = currentNode.next;
            }

            //Reduce the numberOfZealots by 1
            numberOfZealots--;

            //Display the remaining Zealots
            displayAllZealots();

            //Puase
            Utils.pause();
        }
    }

    /**
        Advise Josephus (Joe) with whom to switch, or to stay where he is,
        as the case may be.
    */
    public void adviseJosephus()
    {
        //Display if Joe have to switch of stay put
        if (head.name.equals("Joe"))
        {
            System.out.println("Tell our ol' buddy Joe to stay put.");
        }
        else
        {
            System.out.println
            (
                "Tell Joe he'd better exchange"
                + " positions with " + head.name + "."
            );
        }
    }

    /**
        A simple Node class containing String data for a name.
    */
    private class Node
    {

        private String name;
        private Node next;

        public Node()
        {
            name = null;
            next = null;
        }

    }
}
