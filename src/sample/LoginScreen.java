package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;

/**
 * Created by matthewashley on 1/12/16.
 */
public class LoginScreen {

    static boolean accept;

    public static boolean Login(String title) {

        accept = false;

        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2.0f);
        shadow.setOffsetY(2.0f);

        Stage loginScreen = new Stage();

        /* Setup for the BackgroundImage of the Login Screen */
        BackgroundImage engineering = new BackgroundImage(new Image("mechanical-engineering-scholarships.jpg", 360, 200, false, false),
                BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        loginScreen.initModality(Modality.APPLICATION_MODAL);
        loginScreen.setTitle(title);
        loginScreen.setMinWidth(300);
        loginScreen.setMinHeight(200);

        /* Setup conditions for the GridPane! */
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        /* Conditions for the Username Label! */
        Label nameLabel = new Label("Username");
        nameLabel.setFont(Font.font("null", FontWeight.BOLD.THIN, 35));
        GridPane.setConstraints(nameLabel, 0, 0);

        /* Conditions for Username input field! */
        TextField nameInput = new TextField();
        nameInput.setEffect(shadow);
        GridPane.setConstraints(nameInput, 1, 0);

        /* Conditions for the Password Label! */
        Label passLabel = new Label("Password");
        passLabel.setFont(Font.font("null", FontWeight.BOLD.THIN, 35));
        GridPane.setConstraints(passLabel, 0, 1);

        /* Conditions for Password input field! */
        TextField passInput = new TextField();
        passInput.setEffect(shadow);
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        /* Conditions for logingButton! */
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setEffect(shadow);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (nameInput.getText().equals("username for login screen") && passInput.getText().equals("password for login screen")) {
                    accept = true;
                    loginScreen.close();
                }
            }
        });

        /* Conditions for cancelButton! */
        Button cancelButton = new Button("Cancel");
        GridPane.setConstraints(cancelButton, 1, 3);
        cancelButton.setEffect(shadow);
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                accept =false;
                loginScreen.close();
            }
        });

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, cancelButton);
        grid.setBackground(new Background(engineering));

        Scene scene = new Scene(grid);

        loginScreen.setScene(scene);
        loginScreen.showAndWait();

    return accept;}


}
