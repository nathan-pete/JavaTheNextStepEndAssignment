import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
	private Test test;

	public UserInput() {
		test = new Test();
	}

	public void addQuestion(Question question) {
		test.addQuestion(question);
	}

	public void startTest() {
		test.startTest();
	}

	public static void main(String[] args) {
		UserInput testApp = new UserInput();

		Scanner scanner = new Scanner(System.in);

		// Add multiple-choice questions or open questions
		String addMoreQuestions = "y";
		while (addMoreQuestions.equalsIgnoreCase("y")) {
			System.out.println("Enter question type (mc for multiple-choice, open for open):");
			String questionType = scanner.nextLine();

			if (questionType.equalsIgnoreCase("mc")) {
				System.out.println("Enter question text:");
				String questionText = scanner.nextLine();

				System.out.println("Enter the correct answer (1-based index):");
				int correctAnswerIndex = scanner.nextInt();
				scanner.nextLine(); // Consume newline character

				System.out.println("Enter the number of options:");
				int numOptions = scanner.nextInt();
				scanner.nextLine(); // Consume newline character

				List<String> options = new ArrayList<>();
				for (int i = 0; i < numOptions; i++) {
					System.out.println("Enter option " + (i + 1) + ":");
					options.add(scanner.nextLine());
				}

				testApp.addQuestion(new MultipleChoiceQuestion(questionText, Integer.toString(correctAnswerIndex), 1, options));
			} else if (questionType.equalsIgnoreCase("open")) {
				System.out.println("Enter question text:");
				String questionText = scanner.nextLine();

				System.out.println("Enter the correct answer:");
				String openQuestionAnswer = scanner.nextLine();

				testApp.addQuestion(new OpenQuestion(questionText, openQuestionAnswer, 3));
			} else {
				System.out.println("Invalid question type. Please enter 'mc' for multiple-choice or 'open' for open questions.");
				continue;
			}

			System.out.println("Do you want to add more questions? (y/n)");
			addMoreQuestions = scanner.nextLine();
		}

		testApp.startTest();
	}
}