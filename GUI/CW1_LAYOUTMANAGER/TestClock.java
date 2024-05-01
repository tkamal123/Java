package LayoutManagers;



import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestClock extends JFrame{

	SimpleDateFormat timeFormat_hour;
	SimpleDateFormat timeFormat_min;
	SimpleDateFormat timeFormat_sec;
	SimpleDateFormat timeFormat_amOrPm;
	int hourTime;
	int minTime;
	int secTime;
	int amOrPm;
	JLabel hourLabel;
	JLabel minLabel;
	JLabel secondsLabel;
	JLabel ampmLabel;
	JPanel panel;

	TestClock() {


		timeFormat_hour= new SimpleDateFormat("hh");
		timeFormat_min=new SimpleDateFormat("mm");
		timeFormat_sec=new SimpleDateFormat("ss");
		timeFormat_amOrPm=new SimpleDateFormat("a");

		hourLabel= new JLabel();
		hourLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		hourLabel.setForeground(new Color(0x00FF00));
		hourLabel.setBackground(Color.yellow);
		hourLabel.setHorizontalAlignment(JLabel.CENTER);
		hourLabel.setBounds(10, 10, 230, 230);
		hourLabel.setOpaque(true);
		

		minLabel= new JLabel();
		minLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		minLabel.setForeground(new Color(0x00FF00));
		minLabel.setBackground(Color.orange);
		minLabel.setHorizontalAlignment(JLabel.CENTER);
		minLabel.setBounds(240, 10, 230, 230);
		minLabel.setOpaque(true);
		

		secondsLabel= new JLabel();
		secondsLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		secondsLabel.setForeground(new Color(0x00FF00));
		secondsLabel.setBackground(Color.pink);
		secondsLabel.setHorizontalAlignment(JLabel.CENTER);
		secondsLabel.setBounds(470, 10, 230, 230);
		secondsLabel.setOpaque(true);
		

		ampmLabel = new JLabel();
		ampmLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		ampmLabel.setForeground(new Color(0x00FF00));
		ampmLabel.setBackground(Color.white);
		ampmLabel.setVerticalAlignment(JLabel.BOTTOM);
		ampmLabel.setHorizontalAlignment(JLabel.CENTER);
		ampmLabel.setBounds(10, 270, 710, 230);
		ampmLabel.setOpaque(true);

		panel = new JPanel();
		panel.setBackground(Color.green);
		panel.setBounds(10, 10, 710, 250);
		panel.setLayout(null);
		panel.add(hourLabel);
		panel.add(minLabel);
		panel.add(secondsLabel);

		this.setTitle("clock");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(750, 350);
		this.add(panel);
		this.add(ampmLabel);
		this.setVisible(true);

		setTime();

	}

	private void setTime() {
		while(true) {
			Calendar calender = Calendar.getInstance();

			hourTime = calender.get(Calendar.HOUR);
			minTime = calender.get(Calendar.MINUTE);
			secTime = calender.get(Calendar.SECOND);

			hourLabel.setText(String.valueOf(hourTime));
			minLabel.setText(String.valueOf(minTime));
			secondsLabel.setText(String.valueOf(secTime));
			if (calender.get(Calendar.AM_PM) == Calendar.AM)
				ampmLabel.setText("AM");
			else
				ampmLabel.setText("PM");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	}



	public static void main(String[] args) {
		new TestClock();


	}
}

