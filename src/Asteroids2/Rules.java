package Asteroids2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Rules {
    private static final int SCREEN_WIDTH = 1200;
    private static final int SCREEN_HEIGHT = 800;
	private Stage stage;
    private static final String FONT_NAME = "Arial";
    private static final int FONT_SIZE = 20;
    
    
    public Rules(Stage menuStage) {
        this.stage = new Stage();
        this.stage.setTitle("Rules");
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        
        // create a button to close the rules screen
        Button closeButton = new Button("Menu");
        closeButton.setPrefSize(120, 40); // Set preferred width and height

        
        closeButton.setOnAction(e -> {
            stage.close();
            menuStage.show();
        });
        
        
        

        // create a label to display the rules text
        String rulesText1 = "1. Use the arrow keys to rotate and accelerate your ship!";
        Label rulesLabel = new Label(rulesText1);
        rulesLabel.setStyle("-fx-font-family: '" + FONT_NAME + "'; -fx-font-size: " + FONT_SIZE + "px;");
        rulesLabel.setTextFill(Color.WHITE); // set the text color to white
        
        String rulesText2 = "2. Press spacebar to shoot!";
        Label rulesLabel2 = new Label(rulesText2);
        rulesLabel2.setStyle("-fx-font-family: '" + FONT_NAME + "'; -fx-font-size: " + FONT_SIZE + "px;");
        rulesLabel2.setTextFill(Color.WHITE); // set the text color to white

        
        
        String rulesText3 = "3. Press W to HyperJump!";
        Label rulesLabel3 = new Label(rulesText3);
        rulesLabel3.setStyle("-fx-font-family: '" + FONT_NAME + "'; -fx-font-size: " + FONT_SIZE + "px;");
        rulesLabel3.setTextFill(Color.WHITE); // set the text color to white


        String rulesText4 = "5. Earn points to get the high score!";
        Label rulesLabel4 = new Label(rulesText4);
        rulesLabel4.setStyle("-fx-font-family: '" + FONT_NAME + "'; -fx-font-size: " + FONT_SIZE + "px;");
        rulesLabel4.setTextFill(Color.WHITE); // set the text color to white


        closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;");
        closeButton.setOnMouseEntered(e -> closeButton.setStyle("-fx-background-color: black; -fx-text-fill: white;"));
        closeButton.setOnMouseExited(e -> closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 2px;"));

        
        
        layout.getChildren().addAll(rulesLabel, rulesLabel2, rulesLabel3, rulesLabel4, closeButton);
    	Image image = new Image("file:src/images/asteroids.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        
        
        
        layout.setBackground(new Background(backgroundImage));

        Scene scene = new Scene(layout, SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setScene(scene);
    }

    public void show() {
        if (this.stage != null) {
            this.stage.show();
        } else {
            // Handle the case where the stage variable is null
            System.out.println("Error: stage is null");
        }
    }
}
