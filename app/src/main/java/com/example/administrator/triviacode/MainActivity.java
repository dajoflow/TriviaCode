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
    private long score;

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
        int strike = 0;
        int i = 1;
        long startTime = System.nanoTime();
        long endTime;
        long score;

        // Repeate while # of wrong answers is less than 3 and less than 10
        // questions have been completed.
        while ((strike < 3) && (i <= 10)) {
           // display question given on Question ID (qArray[i-1]) and 4
           // possible answers (3 correct 1 wrong).
            system.out.print(qArray[i - 1]); // Display Q ID
            // Later change to display question & answers based on Q ID in Q database
        }

        endTime = System.nanoTime();
        score = endTime - startTime;
        return (score); // Returns score, which is total elapsed time to play the game.
    }
}

public class Main {
    public static void main(String[] args) {
        /*
        Visual Dispaly with 4 options:

        Change Difficulty
        Play
        View High Scores
        Quit

        loop until user selects Quit
            Wait for user input.
            call method
        end loop
         */

        // User selects play
        Game Test1 = new Game();
        Test1.score = Test1.Play();
    }
}

public class DisplayHighScores() {

        }


