package com.stopwatch;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Stopwatch extends JFrame{
	//declare controls
	JButton startButton = new JButton();
	JButton stopButton =new JButton();
	JButton exitButton = new JButton();
	JLabel startLabel = new JLabel();
	JLabel stopLabel = new JLabel();
	JLabel elapsedLabel = new JLabel();
	JTextField startTextField = new JTextField();
	JTextField stopTextField = new JTextField();
	JTextField elapsedTextField = new JTextField();
	
	//declare class level variables
	long startTime;
	long stopTime;
	double elapsedTime;
	
	public Stopwatch() {
		setTitle("Stopwatch Application");
		getContentPane().setLayout(new GridBagLayout());
		//add controls in the frame
		GridBagConstraints gbc = new GridBagConstraints();
		
		startButton.setText("Start Timing");
		gbc.gridx = 0;
		gbc.gridy = 0;
		getContentPane().add(startButton, gbc);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// click of start timing button
				startButtonActionPerformed(e);
			}
		});
		
		stopButton.setText("Stop Time");
		gbc.gridx = 0;
		gbc.gridy = 1;
		getContentPane().add(stopButton, gbc);
		stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopButtonActionPerformed(e);
			}

			
		});
		
		exitButton.setText("Exit");
		gbc.gridx = 0;
		gbc.gridy = 2;
		getContentPane().add(exitButton, gbc);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exitButtonActionPerformed(e);
			}
		});
		startLabel.setText("Start Time");
		gbc.gridx = 1;
		gbc.gridy = 0;
		getContentPane().add(startLabel, gbc);
		
		stopLabel.setText("Stop Time");
		gbc.gridx = 1;
		gbc.gridy = 1;
		getContentPane().add(stopLabel, gbc);
		
		elapsedLabel.setText("Elapsed Time(sec)");
		gbc.gridx = 1;
		gbc.gridy = 2;
		getContentPane().add(elapsedLabel, gbc);
		
		startTextField.setText("");
		startTextField.setColumns(20);
		gbc.gridx = 2;
		gbc.gridy = 0;
		getContentPane().add(startTextField, gbc);
		
		stopTextField.setText("");
		stopTextField.setColumns(20);
		gbc.gridx = 2;
		gbc.gridy = 1;
		getContentPane().add(stopTextField, gbc);
		
		elapsedTextField.setText("");
		elapsedTextField.setColumns(20);
		gbc.gridx = 2;
		gbc.gridy = 2;
		getContentPane().add(elapsedTextField, gbc);
		
		pack();
	}
	private void startButtonActionPerformed(ActionEvent e) {
		// it works when start button is clicked
		startTime = System.currentTimeMillis();
		startTextField.setText(String.valueOf(startTime));
		stopTextField.setText("");
		elapsedTextField.setText("");
	}
	private void stopButtonActionPerformed(ActionEvent e) {
		// it works when stop button is clicked
		stopTime = System.currentTimeMillis();
		stopTextField.setText(String.valueOf(stopTime));
		elapsedTime = (stopTime - startTime)/1000.0;
		elapsedTextField.setText(String.valueOf(elapsedTime));
	}
	private void exitButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stopwatch sw = new Stopwatch();
		sw.setVisible(true);
		sw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
