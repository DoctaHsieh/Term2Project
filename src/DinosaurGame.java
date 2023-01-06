public class DinosaurGame{
	public static void main(String[] args) throws InterruptedException {
		
		//Create window in which the game takes place
		LayeredPanels panel = new LayeredPanels();
		panel.loadScene();
		panel.startScreen(); //Start main screen
	}
}
