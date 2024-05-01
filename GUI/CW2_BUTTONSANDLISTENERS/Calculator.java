package ButtonsAndListeners;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {


	
	JTextField input = new JTextField();
	JPanel panel = new JPanel();
	JLabel outputLabel = new JLabel();
	JButton addButton = new JButton();
	JButton subButton = new JButton();
	JButton multButton = new JButton();
	JButton divButton = new JButton();
	JButton clrButton = new JButton();
	double accumulator = 0;
	String input1;
	double num;

	Calculator() {

		input.setBounds(25, 75, 350, 50);
		input.setFont(new Font(" serif", Font.PLAIN, 20));
		input.setHorizontalAlignment(JLabel.RIGHT);
		input.addActionListener(this);

		outputLabel.setText(String.valueOf("0"));
		outputLabel.setBounds(25, 25, 350, 50);
		outputLabel.setHorizontalAlignment(JLabel.RIGHT);
		outputLabel.setFont(new Font(" serif", Font.PLAIN, 20));

		clrButton.setText("CLR");
		clrButton.setFont(new Font(" serif", Font.PLAIN, 14));
		clrButton.setBorder(BorderFactory.createEmptyBorder());
		clrButton.setBackground(Color.green);
		clrButton.setFocusable(false);
		clrButton.addActionListener(this);

		addButton.setText("+");
		addButton.setFont(new Font(" serif", Font.PLAIN, 20));
		addButton.setBorder(BorderFactory.createEmptyBorder());
		addButton.setBackground(Color.lightGray);
		addButton.setFocusable(false);
	//	addButton.addActionListener(this);

		subButton.setText("-");
		subButton.setFont(new Font(" serif", Font.PLAIN, 20));
		subButton.setBorder(BorderFactory.createEmptyBorder());
		subButton.setBackground(Color.lightGray);
		subButton.setFocusable(false);
		subButton.addActionListener(this);

		multButton.setText("*");
		multButton.setFont(new Font(" serif", Font.PLAIN, 20));
		multButton.setBorder(BorderFactory.createEmptyBorder());
		multButton.setBackground(Color.lightGray);
		multButton.setFocusable(false);
		multButton.addActionListener(this);

		divButton.setText("/");
		divButton.setFont(new Font(" serif", Font.PLAIN, 20));
		divButton.setBorder(BorderFactory.createEmptyBorder());
		divButton.setBackground(Color.lightGray);
		divButton.setFocusable(false);
		divButton.addActionListener(this);

		panel.setBounds(25, 150, 350, 50);
		panel.setLayout(new GridLayout(1, 5, 8, 5));
		panel.setOpaque(true);

		panel.add(clrButton);
		panel.add(addButton);
		panel.add(subButton);
		panel.add(multButton);
		panel.add(divButton);

		this.setSize(425, 275);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.add(panel);
		this.add(input);
		this.add(outputLabel);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clrButton) {
			input.setText("");
			outputLabel.setText("0");
			accumulator = 0;
		} else if (e.getSource() == addButton) {

			try {
				input1 = input.getText();
				num = Double.parseDouble(input1);
				accumulator = accumulator + num;
				outputLabel.setText(String.valueOf(accumulator));
				input.setText("");
			} catch (NumberFormatException e1) {
				input.setText("");
			}
		} else if (e.getSource() == subButton) {

			try {
				input1 = input.getText();
				num = Double.parseDouble(input1);
				accumulator = accumulator - num;
				outputLabel.setText(String.valueOf(accumulator));
				input.setText("");
			} catch (NumberFormatException e1) {
				input.setText("");
			}
		} else if (e.getSource() == multButton) {
			try {
				input1 = input.getText();
				num = Double.parseDouble(input1);
				accumulator = accumulator * num;
				outputLabel.setText(String.valueOf(accumulator));
				input.setText("");
			} catch (NumberFormatException e1) {
				input.setText("");
			}
		} else if (e.getSource() == divButton) {

			try {
				input1 = input.getText();
				num = Double.parseDouble(input1);
				accumulator = accumulator / num;
				outputLabel.setText(String.valueOf(accumulator));
				input.setText("");
			} catch (NumberFormatException e1) {
				input.setText("");
			}
		} else {

		}
	}
}