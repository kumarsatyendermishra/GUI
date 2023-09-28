package com.stopwatch;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Savings extends JFrame{
	JLabel depositLabel = new JLabel();
	JLabel interestLabel = new JLabel();
	JLabel monthsLabel = new JLabel();
	JLabel finalLabel = new JLabel();
	
	JTextField depositTextField = new JTextField();
	JTextField interstTextField = new JTextField();
	JTextField monthsTextField = new JTextField();
	JTextField finalTextField = new JTextField();
	
	JButton calculateButton = new JButton();
	JButton exitButton = new JButton();
	
	public Savings() {
		// TODO Auto-generated constructor stub
		setTitle("Savings Account");
		addWindowListener(new WindowAdapter() {
			public void windowClosing() {
				System.exit(0);
			}
		});
		//set the layout
		getContentPane().setLayout(new GridBagLayout());
		//position the controls
		GridBagConstraints gbc = new GridBagConstraints();
		depositLabel.setText("Monthly Deposit");
		gbc.gridx = 0;
		gbc.gridy = 0;
		getContentPane().add(depositLabel, gbc);
		
		interestLabel.setText("Yearly Interest");
		gbc.gridx = 0;
		gbc.gridy = 1;
		getContentPane().add(interestLabel, gbc);
		
		monthsLabel.setText("Number of months ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		getContentPane().add(monthsLabel, gbc);
		
		finalLabel.setText("Final Balance ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		getContentPane().add(finalLabel, gbc);
		
		depositTextField.setText("");
		depositTextField.setColumns(10);
		gbc.gridx = 2;
		gbc.gridy = 0;
		getContentPane().add(depositTextField, gbc);
		
		interstTextField.setText("");
		interstTextField.setColumns(10);
		gbc.gridx = 2;
		gbc.gridy = 1;
		getContentPane().add(interstTextField, gbc);
		
		monthsTextField.setText("");
		monthsTextField.setColumns(10);
		gbc.gridx = 2;
		gbc.gridy = 2;
		getContentPane().add(monthsTextField, gbc);
		
		finalTextField.setText("");
		finalTextField.setColumns(10);
		//finalTextField.setEditable(false);
		finalTextField.setFocusable(false);
		gbc.gridx = 2;
		gbc.gridy = 3;
		getContentPane().add(finalTextField, gbc);
		
		calculateButton.setText("Calculate");
		gbc.gridx = 1;
		gbc.gridy = 4;
		getContentPane().add(calculateButton, gbc);
		calculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculateButtonActionPerformed(e);
			}
		});
		
		exitButton.setText("Exit");
		gbc.gridx = 1;
		gbc.gridy = 5;
		getContentPane().add(exitButton, gbc);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exitButtonActionPerformed(e);
			}
		});
		pack();
		
	}
	private void exitButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(EXIT_ON_CLOSE);
	}
	private void calculateButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double deposit, interest, months, finalBalance;
		double monthlyInterest;
		
		deposit = Double.valueOf(depositTextField.getText());
		interest = Double.valueOf(interstTextField.getText());
		months = Double.valueOf(monthsTextField.getText());
		monthlyInterest = interest/1200;
		finalBalance = deposit * (Math.pow((1+ monthlyInterest), months ) - 1)/monthlyInterest;
		finalTextField.setText(new DecimalFormat("0.00").format(finalBalance));
	}

	public static void main(String[] args) {
		Savings s = new Savings();
		s.setVisible(true);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
