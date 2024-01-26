import java.util.Arrays;
import java.util.Scanner;

public class TestApp {
	private Test test;

	public TestApp() {
		test = new Test();
	}

	public void addQuestion(Question question) {
		test.addQuestion(question);
	}

	public void startTest() {
		test.startTest();
	}

	public static void main(String[] args) {
		TestApp testApp = new TestApp();

		// Add multiple-choice questions
		String[] options1 = {"Paris", "London", "Berlin", "Madrid"};
		testApp.addQuestion(new MultipleChoiceQuestion("What is the capital of France?", "1", 1, Arrays.asList(options1)));

		String[] options2 = {"Java", "Python", "C++", "Kotlin", "JavaScript"};
		testApp.addQuestion(new MultipleChoiceQuestion("Which language is primarily used for Android development?", "2", 1, Arrays.asList(options2)));
		// Add open questions
		String openQuestionAnswer1 = "Inheritance is a mechanism in Java that allows a class to inherit attributes and methods from another class.";
		testApp.addQuestion(new OpenQuestion("Explain the concept of inheritance in Java.", openQuestionAnswer1, 3));

		String openQuestionAnswer2 = "Here's a Java program to calculate the area of a rectangle:\n" +
				"public class Rectangle {\n" +
				"    int width;\n" +
				"    int height;\n" +
				"\n" +
				"    public Rectangle(int width, int height) {\n" +
				"        this.width = width;\n" +
				"        this.height = height;\n" +
				"    }\n" +
				"\n" +
				"    public int getArea() {\n" +
				"        return width * height;\n" +
				"    }\n" +
				"}";
		testApp.addQuestion(new OpenQuestion("Write a Java program to calculate the area of a rectangle.", openQuestionAnswer2, 3));

		testApp.startTest();
	}
}