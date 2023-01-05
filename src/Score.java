import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Score extends JLabel{
	DinoObstacle obstacle = new DinoObstacle();
	ArrayList<Integer> scoreData = new ArrayList<Integer>();
	private int score, highestScore;
	public Score() {
		score = 0;
		highestScore = 0;
		setVisible(false); //initial
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
	public boolean increaseSpeed(){
		if((score%10)==0){
			System.out.print("Lvl Up");
			return true;
		}
		else{
			return false;
		}
	}
	public void resetScore() {
		scoreData.add(score);
		for (int i = 0;  i < scoreData.size(); i++) {
			if(score > highestScore) {
				//Highest Score
				highestScore = score;
			}
		  }
		score = 0; //reset score
		setText("SCORE: " + score); //Return score to 0
	}
	
	public int getHighScore() {
		return highestScore;
	}
}
