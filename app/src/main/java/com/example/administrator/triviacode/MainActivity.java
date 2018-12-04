package com.example.administrator.triviacode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;
/*
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
*/
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class HighScore {

        double[] highScores;

        /*
        PUBLIC method --- CheckFileExists

        Method checks to see if a file "HighScoreFile" exists in current
        directory. Then returns this value, true or false.
        */
        public boolean CheckFileExists()
        {
            File tmp = new File("HihScoreList");
            boolean exists = tmp.exists();

            return exists;
        }

        /*
       PUBLIC method --- Initialize

       Method used to initialize array of high scores into highScores
       array. Set 10 values of 0.
       */
        public void Initialize()
        {
            for (int i = 0; i < 10; i++)
                this.highScores[i] = 0;
        }

        /*
        PUBLIC method --- NewHighScore

        Method with compare the NewScore value with those in the
        highScores array. If the NewScore is greater than the
        lowest score in the array then the method will return
        true. Else, false
        */
        public boolean NewHighScore(double NewScore)
        {
            boolean NewHighScore = false;

            if (NewScore > this.highScores[9])
                NewHighScore = true;

            return NewHighScore;
        }

        /*
        PUBLIC method --- WriteNewScore

        Method assumes that NewScore is at least greater than
        hihScores[9], lowest high score. The method will compare
        NewScore with each value in the highScores array and write
        it to the array, shifting accordingly.
        */
        public void WriteNewScore(double NewScore)
        {
            int i = 8;

            while (NewScore > this.highScores[i])
            {
                this.highScores[i+1] = this.highScores[i];
                i--;
            }
            this.highScores[i+1] = NewScore;
        }

        /*
        PUBLIC method --- ReadHighScores

        Method assumes that HighScoreList file exists or Initialize has been
        run. It uses the Scanner function to read through file and record all
        values to the highScores array.
        */
        public void ReadHighScores() throws FileNotFoundException
        {
            //File tmp = new File("HihScoreList");
            FileReader inputFile = new FileReader("HihScoreList.txt");
            Scanner scanner = new Scanner(new File("HighScoreList.txt"));
            int i = 0;
            while(scanner.hasNextDouble())
                this.highScores[i++] = scanner.nextDouble();

        }

        /*
        PUBLIC method --- WriteHighScores

        Method assumes that the HighScoresList file exists and that
        the array to highScores has been altered. The method will
        overwrite file HighScoresList with new list of Double
        value high scores.
        */
        public void WriteHighScores() throws FileNotFoundException
        {
            PrintWriter writer = new PrintWriter("HihScoreList.txt");
            writer.print("");

            for (int i = 0; i < 10; i++)
                writer.println(this.highScores[i] + "\n");

            writer.close();
        }

        /*
        PUBLIC method --- DisplayHighScores

        Method assumes that the highScores array has been initialized and is updated.
        It will go through the highScores array, displaying the top 10 scores.
        */
        public void DisplayHighScore() throws FileNotFoundException
        {
            for (int i = 0; i < 10; i++)
                System.out.print("Number " + i + " - " + this.highScores[i] + "\n");
        }
    }

    public static final Random gen = new Random();

    public class Game {
        // Instance Variables
        private int qArray[]; // Question ID array.
        private double score;

        /*
        PUBLIC method --- randomSet

        Method used to generate a set of 10 random integers of
        1 to maxRange. The integers in this array will represent
        a series of question IDs from a database of trivia
        questions. maxRange is defined by the size of this
        database.
        */
        public int[] randomSet(int maxRange) {

            Set<Integer> used = new HashSet<Integer>();

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

        /*
        PUBLIC method --- Play

        Method used to start game. Method will call setRandom method to instantiate question array.
        Method will then record start time and begin game. Game will loop through qArray until 3
        wrong answers have been submitted or 10 questions answered. At that point, end time will be
        recorded. Score will be calculated based on end time - start time. Score is then returned.
        */
        public double Play() {
            int[] qArray = this.randomSet(100);
            int strike = 0;
            int i = 1;
            double startTime = System.nanoTime();
            double endTime;
            double score;

            // Repeat while # of wrong answers is less than 3 and less than 10
            // questions have been completed.
            while (i <= 10) {
                // display question given on Question ID (qArray[i-1]) and 4
                // possible answers (3 correct 1 wrong).
                System.out.print(qArray[i - 1]); // Display Q ID
                // Later change to display question & answers based on Q ID in Q database
                if (strike >= 3)
                    return 0;
            }

            endTime = System.nanoTime();
            this.score = endTime - startTime;
            return (this.score); // Returns score, which is total elapsed time to play the game.
        }
    }


    public void main(String[] args) throws FileNotFoundException
    {
        /*
        Visual Display with 4 options:

        Change Difficulty
        Play
        View High Scores (List.DisplayHighScores())
        Quit

        loop until user selects Quit
            Wait for user input.
            call method
        end loop
         */

        //Test run
        HighScore List = new HighScore();
        if (!List.CheckFileExists()) // Check that file exists. If not, create it.
            List.Initialize();
        List.ReadHighScores(); // Read & store 10 double values from file to highScores[]

        Game Test1 = new Game();
        Test1.score = Test1.Play();

        if(List.NewHighScore(Test1.score)) // Check if a new high score has been reached.
        {
            List.WriteNewScore(Test1.score);
            List.WriteHighScores();
        }
    }
}
