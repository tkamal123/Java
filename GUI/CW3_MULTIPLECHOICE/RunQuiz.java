import javax.swing.JFrame;

public class RunQuiz extends Quiz {

	public static void main(String[] args) {

		Quiz frame = new Quiz();

		frame.setLayout(null);
		frame.setSize(500, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}