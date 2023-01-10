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
	
	//Increase score by 1
	public void addScore() {
		score++;
		setText("SCORE: " + score); //Display new score
	}
	
	//Return value of score
	public int getScore() {
		return score;
	}
	
	//Return true if time for a level up
	public boolean increaseSpeed(){
		if((score%10)==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	//reset score to 0, check and record if score was highest score
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
	
	//return high score
	public int getHighScore() {
		return highestScore;
	}
}
