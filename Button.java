
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

//These are the buttons inside of the tic-tac-toe board (admittedly, 
//this class should have been named something else)
public class Button{
	
	//Value indicates which player has taken the button 
	// 0 = no one, 3 = cross, 10 = circle
	int value;
	
	//Button is used to style the tile in the board as well as
	//set the function of clicking the tile
	Rectangle button;
	
	//Pane holds the button and is returned when the board wants to
	//show the button
	StackPane pane;
	
	//Image and view are used to display a cross or a circle on the
	//button
	Image image;
	ImageView view;
	
	public Button(){
		//0 is the initial value for the button (no one owns it)
		value = 0;
		button = new Rectangle();
		pane = new StackPane();
		
		//Formatting of the button
		button.setHeight(125);
		button.setWidth(125);
		button.setFill(Color.WHITE);
		
		/*When the button is clicked, the value is checked to be 0 and 
		Play.getTurn() is called to determine whose turn it is*/
		button.setOnMouseClicked(e -> {
			if(value == 0 && Play.getTurn() % 2 == 0){
				//If the tile can be changed, the value is changed, 
				//the button adopts the appropriate icon, 
				//and Play.checkForWin() and Play.incrementTurn() are run
				this.changeToCross();
				this.value = 3;
				Play.checkForWin();
				Play.incrementTurn();
			}
			else if(value == 0){
				this.changeToCircle();
				this.value = 10;
				Play.checkForWin();
				Play.incrementTurn();
			}
		});
		
		//Adds the button to the pane and centers it
		pane.getChildren().add(button);
		pane.setAlignment(Pos.CENTER);
	}
	
	//Returns the pane holding the button
	public StackPane showButton(){
		return pane;
	}
	
	//Sets the value of image and view to the cross and is displayed
	//over the button in the pane
	public void changeToCross(){
		image = new Image("Cross.PNG");
		view = new ImageView();
		view.setImage(image);
		view.setFitHeight(100);
		view.setFitWidth(100);
		value = 3;
		
		pane.getChildren().add(view);
	}
	
	//Has a similar function as changeToCross() accept does the
	//function with a circle
	public void changeToCircle(){
		image = new Image("Circle.png");
		view = new ImageView();
		view.setImage(image);
		view.setFitHeight(100);
		view.setFitWidth(100);
		value = 10;
		
		pane.getChildren().add(view);
	}
	
	//Returns value, to be used when checking for a win
	public int getValue(){return value;}
}
