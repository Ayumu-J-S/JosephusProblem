# Josephus Problem

A Java program that solves the Josephus problem that I created in Data Sctructure course.

The problem scheme is described down below.

---

Josephus was a Jewish historian. He and a group of zealots were trapped by
the Romans. The zealots decided that they would all commit suicide rather
than surrender. Josephus preferred to surrender, but feared that if he
expressed his desire the zealots would murder him first and then kill
themselves.

Now Josephus, being no fool, suggested an orderly method of mass suicide:
All zealots would stand in a circle and every nth person would be killed
(with the circle closing up as each zealot was eliminated) until everyone
was dead. The last person, of course, would be the only one who would have
to do himself or herself in.

So, for example, if there were 5 zealots and n happened to be 3, then the
elimination order of the zealots would be:

3, 1, 5, 2

with position 4 being the last position in the elimination order and thus
the "safe" position for Josephus to occupy. The numbers correspond to the
original positions in the "circle", with 1 marking the first position.

And if, for another example, there were 45 zealots and n is chosen to be 12,
then the elimination order of the zealots would be:

12, 24, 36, 3, 16, 29, 42, 10, 25, 39, 8, 23, 40, 11, 28, <br/>
45, 18, 35, 9, 31, 5, 27, 4, 30, 7, 34, 17, 44, 32, 19, <br/>
6 , 43, 38, 37, 41, 2, 15, 26, 20, 14, 22, 21, 13, 1 <br/>

with position 33 being the last position in the elimination order and thus
the "safe" position for Josephus to occupy.

The program receives its input from the command line, and must have either
two or three command-line parameters:

- First, the number of zealots (must be from from 2 to 50)

- Second, the "elimination gap" (the number n mentioned above, has to be more than 2)

- Third, and optionally, an integer seed value (>0) for the random generator

It then produces a random list of zealot names, which are taken from a list
of fifty 3-character first names, and which always include the name of our
good friend Josehpus (or, as he is better known, "Joe".

The program then first displays the full list of zealots, including Joe,
and next begins the elimination process. It shows the name of each successive
victim, followed by the list of remaining zealots after that victim has been
eliminated.

Once the list has been reduced to a single zealot, it is clear that this
particular zealot's position is the one Joe should be occupying before the
process begins. It may be that he should just stay put, but more likely he
will have to convice someone to exchange places with him. The program will
end by advising him accordingly.

## How to compile

Compile with the following command:

`javac -cp Utils src/Josephus.java src/ZealotCircle.java -d .`

And make a jar file with the following command:

`jar @jar.txt`

The text file "jar.txt" contains the information for making the jar file.

## How to Run the jar file

Run with the following command to see the opening screen:

`JosephusProblem-main % java -jar Josephus.jar`

Sample Run with :

`JosephusProblem-main % java -jar Josephus.jar 10 2`


The instruction for command line parameters are described above in the problem describtion.</br>
Program will crash with unexpected command line parameters.

Java 8 or above is require to run this jar file.
