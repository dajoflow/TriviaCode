package com.example.administrator.triviacode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

public static final Random gen = new Random();

public class Game
{
    // Instance Variables
    private int qArray[]; // Question ID array.
    public int score;

    /*
    PUBLIC method --- randomSet

    Method used to generate a set of 10 random integers of
    1 to maxRange. The integers in this array will represent
    a series of question IDs from a database of trivia
    questions. maxRange is defined by the size of this
    database.
    }*/
    public int[] randomSet(int maxRange) {
        assert n <= maxRange : "Question count cannot exceed database size.";

        Set<Integer> used = new HashSet<integer>();

        // To instantiate 10 random values, we set i < 10.
        for (int i = 0; i < 10; i++) {

            int newRand;
            do {
                newRand = gen.nextInt(maxRange + 1);
            } while (used.contains(newRand)); // Repeate if Q ID has been used
            this.qArray[i] = newRand; // Assign Q ID to element i in qArray
            used.add(newRand); // Add Q ID to used HashSet
        }
        return qArray;
    }

    public int Play() {
        int[] qArray = this.randomSet(100);
        int Strike = 0;
        int i = 1;

        // Repeate while # of wrong answers is less than 3 and less than 10
        // questions have been completed.
        while ((Strike < 3) && (i <= 10)) {
           // display question given on Question ID (qArray[i-1]) and 4
           // possible answers (3 correct 1 wrong).
            system.out.print(qArray[i - 1]); // Display Q ID
        }

        return (10 - Strike); // Returns a "Score" of a # of questions answered correctly.
    }
}

public class Main {
    public static void main(String[] args) {
        Game Test1 = new Game();
        int Score;

        //------Test Random Array------
        for (int i : Test1.randomSet(100)) {
            System.out.print(i);
        }

        Score = Test1.Play();
        PrintWriter writer = new PrintWriter("High Scores.txt", "UTF-8");
        wr.write(new Integer(Score).toString());
        writer.println("The first line");
        writer.println("The second line");
        writer.close();

    }
}

public class DisplayHighScores() {

        }

