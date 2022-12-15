package gamegame;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener{
	
	JLabel playerChoiceLabel = new JLabel();
	JLabel computerChoiceLabel = new JLabel();
	JPanel playerPanel = new JPanel();
	JPanel computerPanel = new JPanel();
	JPanel playerScorePanel = new JPanel();
	JPanel computerScorePanel = new JPanel();
	JLabel computerScore = new JLabel();
	JLabel playerScore = new JLabel();
	JLabel resultPlayer = new JLabel();
	JLabel resultCom = new JLabel();
	
	int playerScoreValue = 0 , computerScoreValue = 0;
	
	public void setup() {
		JButton rock, paper , scissors;
		
		playerPanel.setBounds(45, 20, 290, 240);
		playerPanel.setBackground(new Color(0x090a12));
		playerPanel.add(playerChoiceLabel);
		playerPanel.add(playerScorePanel);
		playerPanel.add(resultPlayer);
		playerPanel.setLayout(null);
		computerPanel.setBounds(345, 20, 290, 240);
		computerPanel.setBackground(new Color(0x090a12));
		computerPanel.add(computerChoiceLabel);
		computerPanel.add(computerScorePanel);
		computerPanel.add(resultCom);
		computerPanel.setLayout(null);
		
		computerScorePanel.setBounds(0, 0, 60, 55);
		computerScorePanel.setBackground(new Color(0x202947));
		computerScorePanel.add(computerScore);
		computerScorePanel.setLayout(null);
		playerScorePanel.setBounds(0, 0 , 60, 55);
		playerScorePanel.setBackground(new Color(0x202947));
		playerScorePanel.add(playerScore);
		playerScorePanel.setLayout(null);
		
		//rock
		rock = new JButton();
		rock.setBounds(30, 280, 200, 60);
		rock.setText("Rock");
		rock.setFocusable(false);
		rock.setBackground(new Color(0x5d84e8));
		rock.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		rock.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		rock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playerChoiceLabel.setText("Rock");
				playerChoiceLabel.setBounds(60, 30, 200, 200);
				playerChoiceLabel.setFont(new Font("Redemtion", Font.BOLD, 70));
				playerChoiceLabel.setForeground(new Color(0xcc9283));
				computerMove();
			}
			
		});
		
		//paper
		paper = new JButton();
		paper.setBounds(240, 280, 200, 60);
		paper.setText("Paper");
		paper.setFocusable(false);
		paper.setBackground(new Color(0x5d84e8));
		paper.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		paper.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		paper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playerChoiceLabel.setText("Paper");
				playerChoiceLabel.setBounds(40, -20, 300, 300);
				playerChoiceLabel.setFont(new Font("Redemtion", Font.BOLD, 70));
				playerChoiceLabel.setForeground(new Color(0xcc9283));
				computerMove();
			}
			
		});
		
		//scissors
		scissors = new JButton();
		scissors.setBounds(450, 280, 200, 60);
		scissors.setText("Scissors");
		scissors.setFocusable(false);
		scissors.setBackground(new Color(0x5d84e8));
		scissors.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		scissors.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		scissors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playerChoiceLabel.setText("Scissors");
				playerChoiceLabel.setBounds(35, -20, 300, 300);
				playerChoiceLabel.setFont(new Font("Redemtion", Font.BOLD, 50));
				playerChoiceLabel.setForeground(new Color(0xcc9283));
				computerMove();
			}
			
		});
		
		
		// ADD COMPONENTS
		add(rock);
		add(paper);
		add(scissors);
		add(playerPanel);
		add(computerPanel);
	}
	
	public void computerMove() {
		String moveList[] = {"Rock", "Paper", "Scissors"};
		String computerMove = moveList[new Random().nextInt(moveList.length)];
		if (computerMove.equals("Rock")) {
			computerChoiceLabel.setText("Rock");
			computerChoiceLabel.setBounds(60, 30, 200, 200);
			computerChoiceLabel.setFont(new Font("Redemtion", Font.BOLD, 70));
			computerChoiceLabel.setForeground(new Color(0xc96190));
		} else if(computerMove.equals("Paper")) {
			computerChoiceLabel.setText("Paper");
			computerChoiceLabel.setBounds(40, -20, 300, 300);
			computerChoiceLabel.setFont(new Font("Redemtion", Font.BOLD, 70));
			computerChoiceLabel.setForeground(new Color(0xc96190));
		} else if(computerMove.equals("Scissors")) {
			computerChoiceLabel.setText("Scissors");
			computerChoiceLabel.setBounds(35, -20, 300, 300);
			computerChoiceLabel.setFont(new Font("Redemtion", Font.BOLD, 50));
			computerChoiceLabel.setForeground(new Color(0xc96190));
		}
		
		playerScore.setText(String.valueOf(playerScoreValue));
		playerScore.setBounds(17,0,60, 50);
		playerScore.setForeground(new Color(0xcfa940));
		playerScore.setFont(new Font("Lucida Mono", Font.BOLD, 50));
		
		computerScore.setText(String.valueOf(computerScoreValue));
		computerScore.setBounds(17,0,60, 50);
		computerScore.setForeground(new Color(0xe32b2b));
		computerScore.setFont(new Font("Lucida Mono", Font.BOLD, 50));
		
		if(playerScoreValue<0 || playerScoreValue>=10) {
			playerScore.setBounds(1, 0 , 60, 50);
		} else if (computerScoreValue<0 || computerScoreValue>=10) {
			computerScore.setBounds(1, 0 , 60, 50);
		}
		
		if(playerChoiceLabel.getText().equals(computerChoiceLabel.getText())) {
			resultPlayer.setText("Draw!");
			resultPlayer.setBounds(125, -20, 100, 100);
			resultPlayer.setFont(new Font("Lucida Mono", Font.BOLD, 20));
			resultPlayer.setForeground(new Color(0xcfa940));
			resultCom.setText("Draw!");
			resultCom.setBounds(125, -20, 100, 100);
			resultCom.setFont(new Font("Lucida Mono", Font.BOLD, 20));
			resultCom.setForeground(new Color(0xe32b2b));
		} else if (playerChoiceLabel.getText().equals("Rock")) {
			if (computerChoiceLabel.getText().equals("Scissors")) {
				playerScoreValue++;
				resultPlayer.setText("Win!");
				resultPlayer.setBounds(128, -20, 100, 100);
				resultPlayer.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultPlayer.setForeground(new Color(0xcfa940));
				resultCom.setText("Lose!");
				resultCom.setBounds(125, -20, 100, 100);
				resultCom.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultCom.setForeground(new Color(0xe32b2b));
			} else if (computerChoiceLabel.getText().equals("Paper")) {
				computerScoreValue++;
				resultPlayer.setText("Lose!");
				resultPlayer.setBounds(125, -20, 100, 100);
				resultPlayer.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultPlayer.setForeground(new Color(0xcfa940));
				resultCom.setText("Win!");
				resultCom.setBounds(128, -20, 100, 100);
				resultCom.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultCom.setForeground(new Color(0xe32b2b));

			}
		} else if (playerChoiceLabel.getText().equals("Paper")) {
			if (computerChoiceLabel.getText().equals("Rock")) {
				playerScoreValue++;

				resultPlayer.setText("Win!");
				resultPlayer.setBounds(128, -20, 100, 100);
				resultPlayer.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultPlayer.setForeground(new Color(0xcfa940));
				resultCom.setText("Lose!");
				resultCom.setBounds(125, -20, 100, 100);
				resultCom.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultCom.setForeground(new Color(0xe32b2b));
				
			} else if (computerChoiceLabel.getText().equals("Scissors")) {
				computerScoreValue++;
				resultPlayer.setText("Lose!");
				resultPlayer.setBounds(125, -20, 100, 100);
				resultPlayer.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultPlayer.setForeground(new Color(0xcfa940));
				resultCom.setText("Win!");
				resultCom.setBounds(128, -20, 100, 100);
				resultCom.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultCom.setForeground(new Color(0xe32b2b));
				
			}
		} else if (playerChoiceLabel.getText().equals("Scissors")) {
			if (computerChoiceLabel.getText().equals("Paper")) {
				resultPlayer.setText("Win!");
				resultPlayer.setBounds(128, -20, 100, 100);
				resultPlayer.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultPlayer.setForeground(new Color(0xcfa940));
				resultCom.setText("Lose!");
				resultCom.setBounds(125, -20, 100, 100);
				resultCom.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultCom.setForeground(new Color(0xe32b2b));
				playerScoreValue++;
			} else if (computerChoiceLabel.getText().equals("Rock")) {
				computerScoreValue++;
				resultPlayer.setText("Lose!");
				resultPlayer.setBounds(125, -20, 100, 100);
				resultPlayer.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultPlayer.setForeground(new Color(0xcfa940));
				resultCom.setText("Win!");
				resultCom.setBounds(128, -20, 100, 100);
				resultCom.setFont(new Font("Lucida Mono", Font.BOLD, 20));
				resultCom.setForeground(new Color(0xe32b2b));
				
			}
		}
		
	}
	
	public void scoreMechanics() {
		
		
		
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.setTitle("Rock Paper Scissors Game");
		game.setSize(700,400);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setup();
		game.getContentPane().setBackground(new Color(0x0d121f));
		game.setResizable(false);
		game.setLayout(null);
		game.setVisible(true);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
