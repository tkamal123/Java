package ButtonsAndListeners;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class FontSize extends JFrame implements ActionListener {

	JLabel fontLabel = new JLabel();
	JLabel fontSizeLabel = new JLabel();
	JButton incrementButton = new JButton();
	JButton decrementButton = new JButton();
	int fontSize = 18;

	FontSize() {

		fontLabel.setText("X");
		fontLabel.setBounds(150, 0, 100, 100);
		fontLabel.setHorizontalAlignment(JLabel.RIGHT);
		fontLabel.setFont(new Font("serif", Font.PLAIN, fontSize));

		fontSizeLabel.setText(String.valueOf(fontSize));
		fontSizeLabel.setBounds(250, 25, 50, 50);
		fontSizeLabel.setFont(new Font("serif", Font.PLAIN, 15));

		incrementButton.setText("increase");
		incrementButton.setBounds(50, 100, 125, 50);
		incrementButton.setBorder(BorderFactory.createEmptyBorder());
		incrementButton.setBackground(Color.lightGray);
		incrementButton.addActionListener(this);

		decrementButton.setText("decrease");
		decrementButton.setBounds(300, 100, 125, 50);
		decrementButton.setBorder(BorderFactory.createEmptyBorder());
		decrementButton.setBackground(Color.lightGray);
		decrementButton.addActionListener(this);

		this.setVisible(true);
		this.setLayout(null);
		this.setSize(500, 225);
		this.add(fontLabel);
		this.add(fontSizeLabel);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(incrementButton);
		this.add(decrementButton);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == incrementButton) {
			fontSize = fontSize + 1;
			fontLabel.setFont(new Font("serif", Font.PLAIN, fontSize));
			fontSizeLabel.setText(String.valueOf(fontSize));
		}

		if (e.getSource() == decrementButton) {
			fontSize = fontSize - 1;
			if (fontSize < 1) {
				fontSize = fontSize + 1;
				System.out.println("Cannot go lower");

			} else {
				fontLabel.setFont(new Font(" serif", Font.PLAIN, fontSize));
				fontSizeLabel.setText(String.valueOf(fontSize));
			}

		}
	}

}