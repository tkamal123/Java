import java.util.ArrayList;

public class Question extends Quiz {

	Quiz q;

	ArrayList<String> questionList = new ArrayList<>();
	ArrayList<String> optionsList = new ArrayList<>();

	String question;
	String Answer;

	public Question(Quiz q) {
		this.q = q;
		fillQuestionList();
		fillOptionList();

	}

	private void fillQuestionList() {

		for (int i = 0; i < 6; i++) {
			questionList.add(q.questionsList.get(i));
		}

	}

	
	private void fillOptionList() {

		for (int i = 1; i < questionList.size() - 1; i++) {
			optionsList.add(questionList.get(i));
		}

	}

	public String getQuestion() {
		question = questionList.get(0);
		return question;

	}

	public String getAnswer() {
		Answer = questionList.get(Integer.parseInt(questionList.get(questionList.size() - 1)));
		return Answer;

	}

	public String getOption(int index) {
		return optionsList.get(index);

	}

}