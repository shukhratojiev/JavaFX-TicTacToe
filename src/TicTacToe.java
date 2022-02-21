import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class TicTacToe implements ActionListener {

	Random random = new Random();
	
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JButton[] button = new JButton[9];
	JLabel textField = new JLabel();
	boolean winned = false;
	boolean firstPlayer = false;
	JButton reset = new JButton();
	
	
	Color buttonColor = new JLabel().getBackground();
	
	TicTacToe(){
		
		textField.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		textField.setForeground(Color.yellow);
		textField.setBackground(new Color(25,25,0));
		textField.setText("Tic-Tac-Toe");
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setBounds(0,0,500,100);
		textField.setOpaque(true);
		
		reset.setText("Reset");
		reset.setBounds(500,10,80,30);
		reset.setFocusable(false);
		reset.addActionListener(this);
		
		
		title_panel.setBounds(0,0,600,100);
		title_panel.setLayout(new BorderLayout());
		
		button_panel.setBounds(0,100,600,500);
		button_panel.setLayout(new GridLayout(3,3,5,5));
		button_panel.setBackground(Color.white);
		
		for(int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button[i].setFont(new Font("MV Boli", Font.BOLD, 100));
			button[i].setFocusable(false);
			button_panel.add(button[i]);
			button[i].addActionListener(this);
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(50,50,50));;
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		
		textField.add(reset);
		title_panel.add(textField);
		
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		frame.setVisible(true);
	
		firstTurn();
	}
	
	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			
			firstPlayer = true;
			textField.setText("X'turn");
		} else {
			firstPlayer = false;
			textField.setText("O'turn");
		}
	}
	
	public void check() {
		
		if(
				button[0].getText()=="X" &&
				button[1].getText()=="X" &&
				button[2].getText()=="X") {
			xWins(0,1,2);
		}
		if(
				button[3].getText()=="X" &&
				button[4].getText()=="X" &&
				button[5].getText()=="X") {
			xWins(3,4,5);
		}
		if(
				button[6].getText()=="X" &&
				button[7].getText()=="X" &&
				button[8].getText()=="X") {
			xWins(6,7,8);
		}
		if(
				button[0].getText()=="X" &&
				button[3].getText()=="X" &&
				button[6].getText()=="X") {
			xWins(0,3,6);
		}
		if(
				button[1].getText()=="X" &&
				button[4].getText()=="X" &&
				button[7].getText()=="X") {
			xWins(1,4,7);
		}
		if(
				button[2].getText()=="X" &&
				button[5].getText()=="X" &&
				button[8].getText()=="X") {
			xWins(2,5,8);
		}
		if(
				button[0].getText()=="X" &&
				button[4].getText()=="X" &&
				button[8].getText()=="X") {
			xWins(0,4,8);
		}
		if(
				button[2].getText()=="X" &&
				button[4].getText()=="X" &&
				button[6].getText()=="X") {
			xWins(2,4,6);
		}
		
		//-------------------------------------------------------
		if(
				button[0].getText()=="O" &&
				button[1].getText()=="O" &&
				button[2].getText()=="O") {
			oWins(0,1,2);
		}
		if(
				button[3].getText()=="O" &&
				button[4].getText()=="O" &&
				button[5].getText()=="O") {
			oWins(3,4,5);
		}
		if(
				button[6].getText()=="O" &&
				button[7].getText()=="O" &&
				button[8].getText()=="O") {
			oWins(6,7,8);
		}
		if(
				button[0].getText()=="O" &&
				button[3].getText()=="O" &&
				button[6].getText()=="O") {
			oWins(0,3,6);
		}
		if(
				button[1].getText()=="O" &&
				button[4].getText()=="O" &&
				button[7].getText()=="O") {
			oWins(1,4,7);
		}
		if(
				button[2].getText()=="O" &&
				button[5].getText()=="O" &&
				button[8].getText()=="O") {
			oWins(2,5,8);
		}
		if(
				button[0].getText()=="O" &&
				button[4].getText()=="O" &&
				button[8].getText()=="O") {
			oWins(0,4,8);
		}
		if(
				button[2].getText()=="O" &&
				button[4].getText()=="O" &&
				button[6].getText()=="O") {
			oWins(2,4,6);
		}
		
		int counter = 0;
		for(int i=0; i<9; i++) {
		
			if(button[i].getText() != "") {
				counter++;
			}
		}
		
		if(counter==9 && !winned) {
			draw();
		}
	    
		
	}
	
	public void draw() {
		textField.setText("Draw");
	    for(int i=0; i<9; i++) {
	    	button[i].setEnabled(false);
	    }
	}
	
	public void xWins(int a, int b, int c) {
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);
		
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		
		winned = true;
		textField.setText("X is winner");
	}
	
	public void oWins(int a, int b, int c) {
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);
		
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		
		winned = true;
		textField.setText("O is winner");
	}
	
	public void returnColor() {
		for(int i=0; i<9;i++) {
		    button[i].setBackground(new JButton().getBackground());
		}
		
	}
	
	public void secondTurn() {
      
		if(random.nextInt(2)==0) {
			
			firstPlayer = true;
			textField.setText("X'turn");
		} else {
			firstPlayer = false;
			textField.setText("O'turn");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==reset) {
			textField.setText("TicTacToe");
			winned = false;
			for(int i=0; i<9; i++) {
				button[i].setText("");
				button[i].setEnabled(true);
				
			}
			secondTurn();
			returnColor();
		}
		
		for(int i=0; i<9; i++) {
			if(e.getSource()==button[i]) {
				if(button[i].getText().equals("")) {
					if(firstPlayer) {
						firstPlayer = false;
						button[i].setText("X");
						textField.setText("O'turn");
						check();
					} else if(!firstPlayer) {
						firstPlayer = true;
						button[i].setText("O");
						textField.setText("X'turn");
						check();
					}
				
				}
				
			} 
		}
	}
}
