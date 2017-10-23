
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

//The score board for the players
public class Scoreboard {
	
	//The node that holds the scoreboard
	private VBox scoreboard;
	
	//The labels used to display the scores
	Label header;
	Label playerOne;
	Label playerTwo;
	Label draw;
	
	//int representations of the scores
	int playerOneScore;
	int playerTwoScore;
	int drawScore;
	
	public Scoreboard(){
		//Formatting for the scoreboard
		scoreboard = new VBox(50);
		scoreboard.setAlignment(Pos.CENTER);
		
		header = new Label("Scoreboard:");
		
		playerOneScore = 0;
		playerOne = new Label("Player One's Wins: " + playerOneScore);
		
		playerTwoScore = 0;
		playerTwo = new Label("Player Two's Wins: " + playerTwoScore);
		
		drawScore = 0;
		draw = new Label("Draws: " + drawScore);
		
		scoreboard.getChildren().addAll(header, playerOne, playerTwo, draw);
	}
	
	//Returns the score board
	public VBox getScoreboard(){return scoreboard;}
	
	//Increments player one's score (the cross) and refreshes the label 
	//displaying the score
	public void incrementPlayerOne(){
		playerOneScore++;
		this.refreshPOne();
	}
	
	//Increments player two's score (the circle) and refreshes the label 
	//displaying the score
	public void incrementPlayerTwo(){
		playerTwoScore++;
		this.refreshPTwo();
	}
	
	//Increments the draw score and refreshes the label displaying the 
	//score
	public void incrementDraw(){
		drawScore++;
		this.refreshDraw();
	}
	
	//Updates the scoreboard
	private void refreshPOne(){
		playerOne.setText("Player One's Wins: " + playerOneScore);
	}

	private void refreshPTwo(){
		playerTwo.setText("Player Two's Wins: " + playerTwoScore);
	}
	
	private void refreshDraw(){
		draw.setText("Draws: " + drawScore);
	}

}
