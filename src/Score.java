import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Score extends JLabel{
	private int score;
	public Score() {
		score = 0;
		setText("SCORE: " + score);
		setHorizontalAlignment(SwingConstants.RIGHT); 
		setBounds(825, 0, 350, 50);
		setFont(new Font("Comic Sans MS", Font.BOLD, 30));
	}
	
	public void addScore() {
		score++;
		setText("SCORE: " + score); //Display new score
	}
	
	public int getScore() {
		return score;
	}
	
	public void resetScore() {
		score = 0;
		setText("SCORE: " + score); //Return score to 0
	}
}
