import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	private List<Question> questions;
	private int totalPoints;
	private int earnedPoints;

	public Test() {
		questions = new ArrayList<>();
		totalPoints = 0;
		earnedPoints = 0;
	}

	public void addQuestion(Question question) {
		questions.add(question);
		totalPoints += question.getPoints();
	}

	public void startTest() {
		Scanner scanner = new Scanner(System.in);

		for (Question question : questions) {
			System.out.println(question.getText());

			if (question instanceof MultipleChoiceQuestion) {
				System.out.println("Enter your answer (1-" + ((MultipleChoiceQuestion) question).getOptions().length + "): ");
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline character
				if (((MultipleChoiceQuestion) question).isCorrect(Integer.toString(choice))) {
					earnedPoints += question.getPoints();
				}
			} else if (question instanceof OpenQuestion) {
				System.out.println("Enter your answer: ");
				String answer = scanner.nextLine();
				if (((OpenQuestion) question).isCorrect(answer)) {
					earnedPoints += question.getPoints();
				}
			}
		}

		double percentage = (double) earnedPoints / totalPoints * 100;
		if (percentage > 55) {
			System.out.println("Your score is: " + percentage + "%. You PASSED!!");
		} else {
			System.out.println("Your score is: " + percentage + "%. You FAILED!!");
		}

		scanner.close();
	}
}