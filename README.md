I'm building a UI with javafx for this little board game application I made. It just has Othello and Connect Four, and you can also add players to keep score. Scores are just recorded in a .txt file and are loaded when the program starts.

The main menu is a Scene with the scoreboard, created from the .txt file, and the buttons. I can add players and they get written to the file and load just fine, the problem happens when I try to reload the players in the .txt file and refresh the scoreboard. I try to refresh the scene but the scoreboard gets printed twice.
