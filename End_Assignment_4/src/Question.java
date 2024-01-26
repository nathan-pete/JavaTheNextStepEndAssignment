public abstract class Question {
	String text;
	int points;

	public Question(String text, int points) {
		this.text = text;
		this.points = points;
	}

	public String getText() {
		return text;
	}

	public int getPoints() {
		return points;
	}

	public abstract boolean isCorrect(Object answer);
}