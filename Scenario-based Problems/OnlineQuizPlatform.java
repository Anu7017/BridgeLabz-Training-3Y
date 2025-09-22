import java.util.*;

class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

class QuizProcessor {

    private String[] correctAnswers;

    // Constructor
    public QuizProcessor(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    // Method to calculate score
    public int calculateScore(String[] userAnswers) throws InvalidQuizSubmissionException {
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException("Answer count does not match the number of questions!");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    // Method to assign grade
    public String getGrade(int score, int totalQuestions) {
        double percentage = (score * 100.0) / totalQuestions;

        if (percentage >= 90) return "A";
        else if (percentage >= 75) return "B";
        else if (percentage >= 50) return "C";
        else return "D";
    }
}

public class OnlineQuizPlatform {
    public static void main(String[] args) {
        // Correct answers
        String[] correctAnswers = {"A", "B", "C", "D", "A"};

        // List of user submissions
        List<String[]> userSubmissions = new ArrayList<>();
        userSubmissions.add(new String[]{"A", "B", "C", "D", "A"}); // all correct
        userSubmissions.add(new String[]{"A", "C", "C", "B", "A"}); // some correct
        userSubmissions.add(new String[]{"B", "B", "B", "B", "B"}); // mostly wrong
        userSubmissions.add(new String[]{"A", "B", "C"});           // invalid (length mismatch)

        // Store scores
        List<Integer> scores = new ArrayList<>();

        QuizProcessor processor = new QuizProcessor(correctAnswers);

        // Process each user submission
        for (int i = 0; i < userSubmissions.size(); i++) {
            try {
                int score = processor.calculateScore(userSubmissions.get(i));
                scores.add(score);

                String grade = processor.getGrade(score, correctAnswers.length);
                System.out.println("User " + (i + 1) + " -> Score: " + score + "/" + correctAnswers.length + " | Grade: " + grade);

            } catch (InvalidQuizSubmissionException e) {
                System.out.println("User " + (i + 1) + " -> Error: " + e.getMessage());
            }
        }

        // Show all scores stored
        System.out.println("\nAll User Scores: " + scores);
    }
}
