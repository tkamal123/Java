package LayoutManagers;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class TestProgress extends JFrame {
	JLabel[] progressLabels;
	JLabel progressValueLabel;
	int progressValue;
	JPanel progressPanel;
	public TestProgress() {
		this.setTitle("Progress Meter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(150, 300);
		this.setLayout(new BorderLayout());

		progressPanel = new JPanel();
		progressPanel.setLayout(new GridLayout(11, 1));
		progressLabels = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			progressLabels[i] = new JLabel("");
			progressLabels[i].setBackground(Color.RED);
			progressLabels[i].setOpaque(true);
			progressPanel.add(progressLabels[i]);
		}

		progressValueLabel = new JLabel("0%", SwingConstants.CENTER);
		progressPanel.add(progressValueLabel);
		this.add(progressPanel, BorderLayout.CENTER);

		
		this.setVisible(true);
	}

	public void incrementProgress() {
		if (progressValue < 100) {
			progressLabels[progressValue / 10].setBackground(Color.GREEN);
			progressValue += 10;
			progressValueLabel.setText(progressValue + "%");
		}
	}

	public static void main(String[] args) {
		TestProgress TestProgress = new TestProgress();
		Scanner scanner = new Scanner(System.in);
		while (TestProgress.progressValue < 100) {
			System.out.print("Press enter to simulate 10% progress: ");
			scanner.nextLine();
			TestProgress.incrementProgress();
		}
	}
}
