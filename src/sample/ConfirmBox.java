package sample;

/**
 * Created by matthewashley on 12/30/15.
 */

import javafx.scene.effect.DropShadow;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

    static boolean answer;

    /* past in parameters for display method come from the closeProgram method in the Main class! */
    public static boolean display(String title, String message) {

        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2.0f);
        shadow.setOffsetY(2.0f);

        Stage messageWindow = new Stage();

        messageWindow.initModality(Modality.APPLICATION_MODAL);
        messageWindow.setTitle(title);
        messageWindow.setMinWidth(250);
        messageWindow.setMinHeight(100);

        /* Label is the past in parameter message from the closeProgram method in the Main class! */
        Label label = new Label();
        label.setText(message);
        label.setAlignment(Pos.BOTTOM_CENTER);
        label.setStyle("-fx-font: 12 arial; -fx-base: #FFFFFF;");

        /* label1 is the title for the messageWindow. Asking to Confirm Exit! */
        Label label1 = new Label("Confirm Exit?");
        label1.setStyle("-fx-font: 16 arial; -fx-base: #FFFFFF;");

        /* Conditions for the Exit button! */
        Button yesButton = new Button("Exit");
        yesButton.setEffect(shadow);
        yesButton.setOnAction(e -> {
            answer = true;
            messageWindow.close();
        });
        yesButton.setStyle("-fx-font: 14 arial; -fx-base: #b6e7c9;");

        /* Conditions for the Cancel button! */
        Button noButton = new Button("Cancel");
        noButton.setEffect(shadow);
        noButton.setOnAction(e -> {
            answer = false;
            messageWindow.close();
        });
        noButton.setStyle("-fx-font: 12 arial; -fx-base: #C0C0C0;");

        /* Setup for the Bottom of the BorderPane! */
        HBox bottom = new HBox(8);
        bottom.setPadding(new Insets(10, 10, 10, 10));
        bottom.getChildren().addAll(noButton, yesButton);
        bottom.setAlignment(Pos.BOTTOM_RIGHT);
        bottom.setMinHeight(65);

        /* Setup for the Center of the BorderPane! */
        StackPane center = new StackPane();
        center.getChildren().add(label);
        center.setMinHeight(35);

        /* Setup for the Top of the BorderPane! */
        StackPane top = new StackPane();
        top.getChildren().add(label1);
        top.setMinHeight(25);

        /* Setup for the BorderPane and the locations of the different layouts used in the BorderPane! */
        BorderPane layout = new BorderPane();

        layout.setBottom(bottom);
        layout.setCenter(center);
        layout.setTop(top);

        Scene scene = new Scene(layout);
        messageWindow.setScene(scene);
        messageWindow.showAndWait();


    return answer;}





}
