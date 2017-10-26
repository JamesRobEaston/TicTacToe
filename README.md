# TicTacToe
Link to the javadoc for this project: https://jamesrobeaston.github.io/TicTacToe/
This was a simple project to learn javafx. The project is a GUI based game of Tic-Tac-Toe.

The most basic element in this project is Button.java (admittedly, this should have been named something else). A Button is one space that
the user can interact with. The Button is initially blank, but can be clicked to change it to an X or an O. However, if a Button is not 
blank, then clicking the on it will have no effect.

Board.java is the first major component of this project. A Board holds a 3x3 array of Buttons that represents the state of the game 
at any moment. The Board also has the ability to check the 3x3 array to see if anyone has won the game and can return a StackPane that
is a visualization of the board.

Scoreboard.java is the second major component of this project. The Scoreboard simply stores the amount of games either player has won in
a session. Scoreboard.java can also return a VBox that is a visualizaiton of the scoreboard.

Play.java is the main class in this project. Play holds the board and the scoreboard, organizes them in a root node, and displays the
current game state. Play also takes the appropriate actions at the end of the game (such as indicating the end result and changing the 
scoreboard).
