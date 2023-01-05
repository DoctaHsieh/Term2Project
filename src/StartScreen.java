import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartScreen{
	private boolean clicked;
	JLabel title = new JLabel();
	JLabel score = new JLabel("High Score: ");
	JLabel directions = new JLabel("Press the space bar, up arrow, or w key to jump");
	JButton play = new JButton("Play!");
	JButton quit = new JButton("Quit");
	
	public StartScreen() {
		clicked = false;
		//Properties of title
		title.setBounds(300, 50, 600, 100);
		title.setText("Dino Game!");
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Properties of High Score
		score.setBounds(0, 200, 1200, 60);
		score.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		score.setHorizontalAlignment(SwingConstants.CENTER); 
		
		//Properties of directions
		directions.setBounds(0, 250, 1200,60);
		directions.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		directions.setHorizontalAlignment(SwingConstants.CENTER); 
		
		//properties of play button
		play.setBounds(300, 400, 600, 75);
		play.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		play.setFocusable(false);
		play.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             //Button clicked
	        	clicked = true;
	          } 
	       });
		
		//Quit button
		quit.setBounds(500, 525, 200, 50);
		quit.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		quit.setFocusable(false);
		quit.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             //Button clicked
	        	 System.exit(0); //Terminate program
	          } 
	       });
	}
	
	public boolean checkClicked() {
		return clicked;
	}
	
	public void disappear() {
		play.setVisible(false);
		title.setVisible(false);
		directions.setVisible(false);
		score.setVisible(false);
		quit.setVisible(false);
		clicked = false;
	}
	
	public void appear() {
		play.setVisible(true);
		title.setVisible(true);
		directions.setVisible(true);
		score.setVisible(true);
		quit.setVisible(true);
	}
	
	public void displayHighScore(int highScore) {
		score.setText("High Score: " + highScore);
	}
}
