import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

enum state {

	LOAD_FILE, DISPLAY_QUESTION, DISPLAY_RESULTS;

}

public class Quiz extends JFrame implements ActionListener {

	/**
	 * 
	 */


	Question qn;

   state guiState = state.LOAD_FILE;

	Scanner scan;

	File file;

	ArrayList<JButton> buttonsList = new ArrayList<>();
	ArrayList<String> questionsList = new ArrayList<>(4);

	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu();
	JMenuItem m1 = new JMenuItem();
	JMenuItem m2 = new JMenuItem();

	JFileChooser fileChooser = new JFileChooser();

	JButton nextButton;

	JPanel actionPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel buttonPanel = new JPanel();

	JLabel actionLabel = new JLabel();
	JLabel questionLabel = new JLabel();
	JLabel markLabel = new JLabel();

	String answer;

	int numberOfQuestions;
	int previousQuestionIndex;
	int mark = 0;
	int attempts = 0;

	Quiz() {

		menuBar.add(menu);

		m1.setText("Open");
		m2.setText("Exit");

		m1.addActionListener(this);
		m2.addActionListener(this);

		menu.setText("File");
		menu.add(m1);
		menu.add(m2);

		markLabel.setHorizontalAlignment(JLabel.CENTER);
		markLabel.setBounds(400, 0, 86, 50);

		actionLabel.setHorizontalAlignment(JLabel.CENTER);
		actionLabel.setBounds(0, 0, 500, 50);

		questionLabel.setHorizontalAlignment(JLabel.CENTER);
		questionLabel.setBounds(0, 0, 500, 50);

		topPanel.setLayout(null);
		topPanel.add(markLabel);
		topPanel.add(actionLabel);

		bottomPanel.setLayout(null);
		bottomPanel.add(questionLabel);

		actionPanel.setLayout(new GridLayout(2, 1, 0, 0));
		actionPanel.setBounds(0, 0, 500, 100);
		actionPanel.setBackground(Color.blue);
		actionPanel.setOpaque(true);

		actionPanel.add(topPanel);
		actionPanel.add(bottomPanel);

		buttonPanel.setBounds(0, 100, 500, 450);
		buttonPanel.setLayout(new GridLayout(5, 1, 0, 0));
		buttonPanel.setBackground(Color.red);
		buttonPanel.setOpaque(true);

		for (int i = 0; i < 5; i++) {

			buttonsList.add(new JButton());
			setupButton(buttonsList.get(i), "");
			buttonPanel.add(buttonsList.get(i));
		}
		nextButton = buttonsList.get(buttonsList.size() - 1);

		this.setJMenuBar(menuBar);
		this.add(actionPanel);
		this.add(buttonPanel);
		this.getContentPane().setBackground(Color.black);

		stateChecker();

	}

	private void stateChecker() {
		switch (guiState) {

		case LOAD_FILE:

			m1.setEnabled(true);
			m2.setEnabled(true);
			actionLabel.setText("Open a Quiz");
			mark = 0;
			attempts = 0;
			break;

		case DISPLAY_QUESTION:

			qn = new Question(this);
			actionLabel.setText("");
			markLabel.setText("");
			m1.setEnabled(false);
			m2.setEnabled(false);

			nextButton.setText("Next");
			nextButton.setEnabled(false);
			setOptionButtonsState(true);

			questionLabel.setText(qn.getQuestion());
			answer = qn.getAnswer();

			for (int i = 0; i < qn.optionsList.size(); i++) {
				buttonsList.get(i).setText(qn.getOption(i));
			}

			attempts++;

			if (attempts != numberOfQuestions + 1) {
				try {

					questionsList.subList(0, 6).clear();
				} catch (Exception e) {

					System.out.println(" error found!");
				}
			}

			break;

		case DISPLAY_RESULTS:

			m1.setEnabled(true);
			m2.setEnabled(true);
			setOptionButtonsState(false);

			actionLabel.setText("The end. Final Score : ");
			markLabel.setText(String.valueOf(mark) + "/" + String.valueOf(numberOfQuestions));
			questionLabel.setText("");

			mark = 0;
			attempts = 0;

			for (int i = 0; i < buttonsList.size(); i++) {
				buttonsList.get(i).setText("");
			}

			break;
		default:

			m1.setEnabled(true);
			m2.setEnabled(true);

			break;

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == m1) {
			fileChooser.setCurrentDirectory(new File("."));
			fileChooser.showOpenDialog(null);

			file = new File(fileChooser.getSelectedFile().getPath());
			try {
				scan = new Scanner(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			while (scan.hasNextLine()) {
				questionsList.add(scan.nextLine());
			}

			numberOfQuestions = questionsList.size() / 6;

			guiState = state.DISPLAY_QUESTION;

			stateChecker();

		} else if (e.getSource() == m2) {
			System.exit(0);

		} else if (e.getSource() == nextButton) {

			if (attempts == numberOfQuestions) {
				guiState = state.DISPLAY_RESULTS;

			}

			buttonsList.get(previousQuestionIndex).setBackground(Color.LIGHT_GRAY);

			stateChecker();

		} else {

			for (int i = 0; i < buttonsList.size(); i++) {
				if (e.getSource() == buttonsList.get(i)) {

					if (qn.optionsList.get(i) == answer) {

						previousQuestionIndex = i;
						buttonsList.get(i).setBackground(Color.green);
						actionLabel.setText("Correct!");
						mark++;
						markLabel.setText("1/1");
						nextButton.setEnabled(true);
						setOptionButtonsState(false);

					} else {

						previousQuestionIndex = i;
						buttonsList.get(i).setBackground(Color.red);
						actionLabel.setText("Wrong!");
						markLabel.setText("0/1");
						nextButton.setEnabled(true);
						setOptionButtonsState(false);

					}
					break;
				}
			}
		}
	}

	// method for setting up buttons
	private void setupButton(JButton button, String text) {

		button.setText(text);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBorder(BorderFactory.createEtchedBorder());
		button.addActionListener(this);
		button.setFocusable(false);
		button.setEnabled(false);

	}

	private void setOptionButtonsState(boolean bool) {

		for (int i = 0; i < qn.optionsList.size(); i++) {
			buttonsList.get(i).setEnabled(bool);

		}

	}

}