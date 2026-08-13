package ss;

import java.util.*;

public class quizapplication {


    // Quiz Question Class
    static class Question {
        String question;
        String[] options;
        int correctAnswer;

        Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store quiz questions
        Question[] questions = {

            new Question(
                "Which language is used for Android development?",
                new String[]{"1. Java", "2. HTML", "3. CSS", "4. SQL"},
                1
            ),

            new Question(
                "Which keyword is used to create a class in Java?",
                new String[]{"1. function", "2. class", "3. define", "4. create"},
                2
            ),

            new Question(
                "Which of these is not a programming language?",
                new String[]{"1. Python", "2. Java", "3. HTML", "4. C++"},
                3
            ),

            new Question(
                "Which symbol is used for single-line comments in Java?",
                new String[]{"1. /* */", "2. //", "3. #", "4. <!-- -->"},
                2
            ),

            new Question(
                "Which data type is used to store whole numbers in Java?",
                new String[]{"1. double", "2. String", "3. int", "4. boolean"},
                3
            )
        };

        int score = 0;
        int correct = 0;
        int incorrect = 0;

        System.out.println("=================================");
        System.out.println("       QUIZ APPLICATION");
        System.out.println("=================================");
        System.out.println("You have 10 seconds for each question.");
        System.out.println();

        // Ask each question
        for (int i = 0; i < questions.length; i++) {

            Question q = questions[i];

            System.out.println("---------------------------------");
            System.out.println("Question " + (i + 1) + " of " + questions.length);
            System.out.println(q.question);

            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.println("---------------------------------");

            System.out.print("Enter your answer (1-4): ");

            // Start timer
            long startTime = System.currentTimeMillis();

            String input = sc.nextLine();

            // End timer
            long endTime = System.currentTimeMillis();

            long timeTaken = (endTime - startTime) / 1000;

            // Check time
            if (timeTaken > 10) {
                System.out.println("Time's up! Answer not accepted.");
                incorrect++;
            } 
            else {
                try {
                    int answer = Integer.parseInt(input);

                    if (answer == q.correctAnswer) {
                        System.out.println("Correct Answer!");
                        score++;
                        correct++;
                    } 
                    else {
                        System.out.println("Wrong Answer!");
                        System.out.println("Correct answer was: "
                                + q.correctAnswer);
                        incorrect++;
                    }
                } 
                catch (NumberFormatException e) {
                    System.out.println("Invalid answer!");
                    incorrect++;
                }
            }

            System.out.println("Time taken: " + timeTaken + " seconds");
            System.out.println();
        }

        // Final Result
        System.out.println("=================================");
        System.out.println("          QUIZ RESULT");
        System.out.println("=================================");

        System.out.println("Total Questions : " + questions.length);
        System.out.println("Correct Answers : " + correct);
        System.out.println("Incorrect Answers : " + incorrect);
        System.out.println("Final Score      : " + score + "/" + questions.length);

        double percentage =
                ((double) score / questions.length) * 100;

        System.out.println("Percentage       : " + percentage + "%");

        if (percentage >= 80) {
            System.out.println("Excellent Performance!");
        } 
        else if (percentage >= 50) {
            System.out.println("Good Performance!");
        } 
        else {
            System.out.println("Keep Practicing!");
        }

        System.out.println("=================================");

        sc.close();
    }
}