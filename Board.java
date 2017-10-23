
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

public class Board {

	//The board holding the buttons
	private Button[][] board;
	
	//The node visualization of the board
	private StackPane mainPane;
	
	//Creates the board and returns it (This should have been done with a
	//constructor and getter)
	public Board(){
		
		//Constructs the board and root node to hold everything
		board = new Button[3][3];
		mainPane = new StackPane();
		mainPane.setAlignment(Pos.CENTER);
		
		//A black rectangle to be displayed behind the buttons
		Rectangle background = new Rectangle();
		background.setWidth(400);
		background.setHeight(400);
		background.setArcHeight(0);
		background.setArcWidth(0);
		
		//Fills the board with buttons
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = new Button();
			}
		}
		
		//Creates three different columns to hold the buttons for a visual
		//representation of the board
		VBox colOne = new VBox(12.5);
		VBox colTwo = new VBox(12.5);
		VBox colThree = new VBox(12.5);
		
		//Fills the columns with the buttons
		for(int i = 0; i < 3; i++){
			colOne.getChildren().add(board[0][i].showButton());
			colTwo.getChildren().add(board[1][i].showButton());
			colThree.getChildren().add(board[2][i].showButton());
		}
		
		//Centers the columns
		colOne.setAlignment(Pos.CENTER);
		colTwo.setAlignment(Pos.CENTER);
		colThree.setAlignment(Pos.CENTER);
		
		//Puts the columns side by side and centered
		HBox layout = new HBox(12.5);
		layout.getChildren().addAll(colOne, colTwo, colThree);
		layout.setAlignment(Pos.CENTER);
		
		//Adds the background and columns to the root node
		mainPane.getChildren().addAll(background, layout);
	}
	
	//Checks the board to see if anyone has one
	//0 = no one has won and the game continues
	//1 = cross win, 2 = circle win, 3 = draw
	public int checkForWin(){
		
		//The values along the columns, rows, and diagonals
		int colVal = 0;
		int rowVal = 0;
		int mainDiagVal = 0;
		int secondDiagVal = 0;
		
		//Loops through the board
		for(int i = 0; i < 3; i++){
			
			//Resets the column and row values
			colVal = 0;
			rowVal = 0;
			
			//Goes along each column and row and adds the values to colVal 
			//and rowVal, respectively 
			for(int j = 0; j < 3; j++){
				rowVal += board[i][j].getValue();
				colVal += board[j][i].getValue();
				
			}
		
			//If the values along the columns and rows were 3*3 or 3*10
			//then the appropriate winner is returned
			if(colVal == 9 || rowVal == 9){
				//Cross Win = 1
				return 1;
			} else if(colVal == 30 || rowVal == 30){
				//Circle Win = 2
				return 2;
			}
			
			//Goes along the diagonals and adds up the values of the tiles
			mainDiagVal += board[i][i].getValue();
			secondDiagVal += board[2-i][i].getValue();
		}
	
		//Checks if the cross or circle has won, as well as for a draw
		if(mainDiagVal == 9 || secondDiagVal == 9){
			return 1;
		} else if(mainDiagVal == 30 || secondDiagVal == 30){
			return 2;
		} else if(Play.getTurn() == 8){
			return 3;
		}
		
		//If no value was returned after the columns, rows, and diagonals
		//have been checked, as well as a draw has been checked for, then
		//0 is returned and the game continues
		return 0;
	}
	
	public StackPane getBoard()
	{
		return mainPane;
	}
}
