public class OpenQuestion extends Question {
	private String answer;

	public OpenQuestion(String text, String answer, int points) {
		super(text, points);
		this.answer = answer;
	}

	@Override
	public boolean isCorrect(Object answer) {
		return this.answer.equals(answer);
	}
}