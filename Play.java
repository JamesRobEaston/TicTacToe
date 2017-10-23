
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Play extends Application{

	//turn = whatever turn the game is on
	private static int turn;
	
	//board = the main board
	private static Board board;
	
	//The root node used in the Scene
	private static BorderPane rootNode;
	
	//The score board
	private static Scoreboard scoreboard;
	
	public static void main(String[] args){
		//Constructs the board and score board
		board = new Board();
		scoreboard = new Scoreboard();
		launch(args);
	}
	
	@Override
	public void start(Stage stage){
		//turn's initial value is 0
		turn = 0;
		stage.setTitle("Tic Tac Toe");
		
		//Constructs the root node and puts in the board and score board
		rootNode = new BorderPane();
		rootNode.setCenter(board.getBoard());
		rootNode.setLeft(scoreboard.getScoreboard());
		
		
		//resetBox is meant to hold playAgain, a button used to reset the 
		//board
		VBox resetBox = new VBox();
		resetBox.setAlignment(Pos.CENTER);
		
		Button playAgain = new Button("Reset");
		
		//I'm sure there's a better way to format but I don't know what 
		//it is
		Label format = new Label("");
		
		//Resets the board and turn
		playAgain.setOnAction(e -> {
			rootNode.setCenter(board.getBoard());
			turn = 0;
		});
		
		resetBox.getChildren().addAll(format, playAgain);
		rootNode.setTop(resetBox);
		
		
		//Constructs the main Scene using rootNode
		Scene scene = new Scene(rootNode, 700, 600);
		
		stage.setScene(scene);
		stage.show();
	}
	
	//Returns turn
	public static int getTurn(){
		return turn;
	}
	
	//Increments turn
	public static void incrementTurn(){
		turn++;
	}
	
	//checkForWin uses Board's checkForWin() and manipulates the result
	//into the appropriate visual
	public static void checkForWin(){
		//No one can win before turn = 3
		if(turn > 3){
			int win = board.checkForWin();
			if(win == 1){
				crossWin();
			} else if(win == 2){
				circleWin();
			} else if(win == 3){
				draw();
			}
		}
	}
	
	//If player one has won (the cross) then a P1 is displayed and the 
	//score board changes appropriately
	private static void crossWin(){
		Image image = new Image("POne.PNG");
		ImageView view = new ImageView(image);
		view.setFitHeight(400);
		view.setFitWidth(400);
		rootNode.setCenter(view);
		scoreboard.incrementPlayerOne();
	}
	
	//Similar to cross win, except for player two (the circle)
	private static void circleWin(){
		Image image = new Image("PTwo.PNG");
		ImageView view = new ImageView(image);
		view.setFitHeight(400);
		view.setFitWidth(400);
		rootNode.setCenter(view);
		scoreboard.incrementPlayerTwo();
	}
	
	//Similar to cross win, except used in the case of a draw
	private static void draw(){
		Image image = new Image("Draw.PNG");
		ImageView view = new ImageView(image);
		view.setFitHeight(400);
		view.setFitWidth(400);
		rootNode.setCenter(view);
		scoreboard.incrementDraw();
	}
}
