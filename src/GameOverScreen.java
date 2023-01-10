
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameOverScreen{
	private boolean clicked;
	JButton restartButton = new JButton("Continue");
	JLabel title = new JLabel("Game Over!");
	JLabel score = new JLabel();
	
	public GameOverScreen() {
		clicked = false;
		
		//Properties of button
		restartButton.setBounds(500, 400, 200, 50);
		restartButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		restartButton.setVisible(false); //Initially
		restartButton.setFocusable(false);
		restartButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             //Button clicked
	        	 clicked = true;
	          } 
	       });
		
		//Properties of Title
		title.setBounds(0, 50, 1200, 65);
		title.setVisible(false); //Initially
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 65));
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		
		//Properties of Score
		score.setBounds(0, 200, 1200, 50);
		score.setVisible(false); //Initially
		score.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		score.setHorizontalAlignment(SwingConstants.CENTER); 
	}
	
	//return val of clicked
	public boolean checkClicked() {
		return clicked;
	}
	
	
	//Display final score
	public void finalScore(int final_score) {
		score.setText("Final Score: " + final_score);
	}
	
	//display all components
	public void display() {
		restartButton.setVisible(true);
		title.setVisible(true);
		score.setVisible(true);
	}
	
	//hide all components
	public void disappear() {
		restartButton.setVisible(false);
		title.setVisible(false);
		score.setVisible(false);
		clicked = false;
	}
	
	
	//Reuse code for messages during the game
	public void displayMsg(String str) {
		title.setText(str);
		title.setVisible(true);
	}
	
	//reset to "game over" msg
	public void eraseMsg() {
		title.setVisible(false);
		title.setText("Game Over!");
	}
}
