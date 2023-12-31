package Asteroids2;

import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Menu  {
	
    private Stage stage;
    private VBox menu;
	Asteroids asteroidsGame = new Asteroids();
    private HighScores highScores;
    private String highScoresFilePath;
    private HashMap<String, Integer> scoresList;
    private final ThemeMusic menuMusic = new ThemeMusic();
    
    
    public Menu() {
        highScoresFilePath = "high_scores.txt";
        this.highScores = new HighScores(highScoresFilePath);
        this.scoresList = this.highScores.loadScores();
    }		//start method of our application which creates the main window
    public void start(Stage menuStage) throws Exception {
    	this.menuMusic.playMenuTheme();
    	VBox menu = new VBox(10); // create a VBox container with a spacing of 10 pixels        
    	menu.setPrefSize(Asteroids.PANE_WIDTH, Asteroids.PANE_HEIGHT);
    	
    	
        //create a background image for our menu 
    	Image image = new Image("file:src/images/asteroids.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        
        
        
        menu.setBackground(new Background(backgroundImage));


        Button startButton = new Button("Start Game");
        startButton.setPrefSize(120, 40); // Set preferred width and height
        
        Button rulesButton = new Button("Rules");
        rulesButton.setPrefSize(120, 40); // Set preferred width and height
        
        
        Button highScoreButton = new Button("High Scores");
        highScoreButton.setPrefSize(120, 40); // Set preferred width and height
        
        
        Button exitButton = new Button("Exit Game");
        exitButton.setPrefSize(120, 40); // Set preferred width and height



        
        //style the buttons
        
        startButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        exitButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        highScoreButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        rulesButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        
        startButton.setOnMouseEntered(e -> startButton.setStyle("-fx-background-color: black; -fx-text-fill: white;"));
        startButton.setOnMouseExited(e -> startButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;"));
        
        exitButton.setOnMouseEntered(e -> exitButton.setStyle("-fx-background-color: black; -fx-text-fill: white;"));
        exitButton.setOnMouseExited(e -> exitButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;"));

        highScoreButton.setOnMouseEntered(e -> highScoreButton.setStyle("-fx-background-color: black; -fx-text-fill: white;"));
        highScoreButton.setOnMouseExited(e -> highScoreButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;"));

        rulesButton.setOnMouseEntered(e -> rulesButton.setStyle("-fx-background-color: black; -fx-text-fill: white;"));
        rulesButton.setOnMouseExited(e -> rulesButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;"));

        
        menu.getChildren().addAll(startButton, rulesButton, highScoreButton, exitButton);

        // center the buttons horizontally
        menu.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(menu);
        menuStage.setTitle("Asteroids!");
        menuStage.setScene(scene);
        menuStage.show();
        
        
        
        //This method will create a new pane for the game menu where the game will be played.
        //when the button is clicked we will create an instance of our gameWindow class that is defined in the package
        startButton.setOnAction(e -> {
            try {
                Stage gameStage = new Stage();
                Asteroids asteroidsGame = new Asteroids(); // Create a new instance of the Asteroids class
                asteroidsGame.startGame(menuStage, gameStage, this);
                menuMusic.stopMenuTheme();            
                } catch (Exception ex) {
                ex.printStackTrace();
            }
            menuStage.hide();
        });
        
        //Exit the game
        exitButton.setOnAction(e -> {
            highScores.saveScore(scoresList);
            System.exit(0);
        });

        
        
        //go to highscore screen
        highScoreButton.setOnAction(e -> {
            highScores.display(menuStage, highScores.loadScores());
        });

        
        rulesButton.setOnAction(e -> {
            Rules rulesScreen = new Rules(menuStage);
            rulesScreen.show();
        });        
    }
    
    public Stage getStage() {
        return stage;
    }

    public VBox getMenu() {
        return menu;
    }
}
