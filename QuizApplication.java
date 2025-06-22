import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String question;
    private List<String> options;
    private int answer; // index of the correct option

    public Question(String question, List<String> options, int answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int userAnswer) {
        return userAnswer == answer;
    }
}

public class QuizApplication {
    private List<Question> questions;
    private Scanner scanner;

    public QuizApplication() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadQuestions();
    }

    private void loadQuestions() {
        List<String> options1 = List.of("Java", "C++", "Python", "Ruby");
        questions.add(new Question("Which programming language is known as the 'Mother of all languages'?", options1, 0));

        List<String> options2 = List.of("Apple", "Banana", "Orange", "Mango");
        questions.add(new Question("Which fruit is known as the 'King of Fruits'?", options2, 3));

        List<String> options3 = List.of("4", "6", "8", "10");
        questions.add(new Question("How many continents are there on Earth?", options3, 2));

        // Add more questions as needed
    }

    public void startQuiz() {
        int score = 0;

        System.out.println("Welcome to the Quiz! Please answer the following questions:");
        for (Question question : questions) {
            System.out.println("\n" + question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Your answer (1-" + options.size() + "): ");
            int userAnswer = scanner.nextInt() - 1; // adjust for 0-based index

            if (question.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + options.get(question.answer));
            }
        }

        System.out.println("\nYour score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        QuizApplication quizApp = new QuizApplication();
        quizApp.startQuiz();
    }
}

