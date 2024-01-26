import java.util.List;

public class MultipleChoiceQuestion extends Question {
	private String correctAnswer;
	private String[] options;

	public MultipleChoiceQuestion(String text, String correctAnswer, int points, List<String> options) {
		super(text, points);
		this.correctAnswer = correctAnswer;
		this.options = options.toArray(new String[options.size()]);
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public String[] getOptions() {
		return options;
	}

	@Override
	public boolean isCorrect(Object answer) {
		return correctAnswer.equals(answer);
	}
}