package sample;

import com.sun.javafx.css.converters.FontConverter;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Main extends Application {

    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8;
    Stage window;

    String paint; /* Used to tell which ChoiceBox selection has been made! */

    int pauseVar = 0; /* Used to tell if a video has been paused or not so the play buttons will function correctly! */
    int Video1 = 0; /* Determines how many times Video1 has been watched! */
    int Video2 = 0; /* Determines how many times Video2 has been watched! */
    int Video3 = 0; /* Determines how many times Video3 has been watched! */
    int Video4 = 0; /* Determines how many times Video4 has been watched! */
    int Video5 = 0; /* Determines how many times Video5 has been watched! */
    int Video6 = 0; /* Determines how many times Video6 has been watched! */
    int dayOfWeek; /* Inputs what day of the week it is! */
    int emailSent = 0; /* Used to tell if an email has already been sent! */

    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4, mediaPlayer5, mediaPlayer6;

    Email sendMail = new Email(); /* Setup for constructor of Email class! */

    DropShadow shadow = new DropShadow();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        window = primaryStage;

        /* Conditions to set file location of video file! */
        Media video1 = new Media("file string for video or URL for video");
        Media video2 = new Media("file string for video or URL for video");
        Media video3 = new Media("file string for video or URL for video");
        Media video4 = new Media("file string for video or URL for video");
        Media video5 = new Media("file string for video or URL for video");
        Media video6 = new Media("file string for video or URL for video");

        /* Set up of mediaPlayers for each video! */
        mediaPlayer1 = new MediaPlayer(video1);
        mediaPlayer2 = new MediaPlayer(video2);
        mediaPlayer3 = new MediaPlayer(video3);
        mediaPlayer4 = new MediaPlayer(video4);
        mediaPlayer5 = new MediaPlayer(video5);
        mediaPlayer6 = new MediaPlayer(video6);

        /* Set up of mediaViews for each video! */
        MediaView mediaView1 = new MediaView(mediaPlayer1);
        MediaView mediaView2 = new MediaView(mediaPlayer2);
        MediaView mediaView3 = new MediaView(mediaPlayer3);
        MediaView mediaView4 = new MediaView(mediaPlayer4);
        MediaView mediaView5 = new MediaView(mediaPlayer5);
        MediaView mediaView6 = new MediaView(mediaPlayer6);

        /* Label for Company information! */
        Label company = new Label("Vern Tech " + "Created 2016");
        company.setStyle("-fx-font: 13 arial; -fx-base: #FFFFFF;");
        company.setTranslateX(320);
        company.setTranslateY(250);

        /* Setup for the drop down menu (ChoiceBox) for all paint issues! */
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Pick a Paint Issue", "Welcome Video", "Paint Issue 1", "Paint Issue 2", "Paint Issue 3", "Paint Issue 4", "Paint Issue 5");
        choiceBox.setTranslateY(-300);
        choiceBox.setTranslateX(250);
        choiceBox.setValue("Pick a Paint Issue");

        choiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                paint = choiceBox.getValue();
                if (paint == "Paint Issue 1") {
                    Video1 = (Video1 + 1);
                    window.setScene(scene2);
                    window.setTitle("Paint Issue 1");
                    mediaView1.setFitHeight(1000);
                    mediaView1.setFitWidth(1300);
                    }
                if (paint == "Paint Issue 2") {
                    Video2 = (Video2 + 1);
                    window.setScene(scene3);
                    window.setTitle("Paint Issue 2");
                    mediaView2.setFitHeight(1000);
                    mediaView2.setFitWidth(1300);
                }
                if (paint == "Paint Issue 3") {
                    Video3 = (Video3 + 1);
                    window.setScene(scene4);
                    window.setTitle("Paint Issue 3");
                    mediaView3.setFitHeight(1000);
                    mediaView3.setFitWidth(1300);
                }
                if (paint == "Paint Issue 4") {
                    Video4 = (Video4 + 1);
                    window.setScene(scene5);
                    window.setTitle("Paint Issue 4");
                    mediaView4.setFitHeight(1000);
                    mediaView4.setFitWidth(1300);
                }
                if (paint == "Paint Issue 5") {
                    Video5 = (Video5 + 1);
                    window.setScene(scene6);
                    window.setTitle("Paint Issue 5");
                    mediaView5.setFitHeight(1000);
                    mediaView5.setFitWidth(1300);
                }
                if (paint == "Welcome Video") {
                    Video6 = (Video6 + 1);
                    window.setScene(scene7);
                    window.setTitle("Welcome Video");
                    mediaView6.setFitHeight(1000);
                    mediaView6.setFitWidth(1300);
                }
            }
        });

        /* Setup for Image Button on Home Screen! */
        ImageView watsonImage = new ImageView(new Image("watson_engineering_logo.png"));

        /* Conditions for Watson Image Button! */
        Button watsonButton = new Button("", watsonImage);
        watsonButton.setTranslateX(-320);
        watsonButton.setTranslateY(-320);
        watsonButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginWindow();
            }
        });

        /* Conditions for Button 1! */
        Button button1 = new Button("Return Home");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer1.stop();
                choiceBox.setValue("Pick a Paint Issue");
                window.setScene(scene1);
                window.setTitle("Watson Paint Line");
            }
        });

        /* Conditions for Button 2! */
        Button button2 = new Button("Return Home");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer2.stop();
                choiceBox.setValue("Pick a Paint Issue");
                window.setScene(scene1);
                window.setTitle("Watson Paint Line");
            }
        });

        /* Conditions for Button 3! */
        Button button3 = new Button("Return Home");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer3.stop();
                choiceBox.setValue("Pick a Paint Issue");
                window.setScene(scene1);
                window.setTitle("Watson Paint Line");
            }
        });

        /* Conditions for Button 4! */
        Button button4 = new Button("Return Home");
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer4.stop();
                choiceBox.setValue("Pick a Paint Issue");
                window.setScene(scene1);
                window.setTitle("Watson Paint Line");
            }
        });

        /* Conditions for Button 5! */
        Button button5 = new Button("Return Home");
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer5.stop();
                choiceBox.setValue("Pick a Paint Issue");
                window.setScene(scene1);
                window.setTitle("Watson Paint Line");
            }
        });

        /* Conditions for Button 6! */
        Button button6 = new Button("Return Home");
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer6.stop();
                choiceBox.setValue("Pick a Paint Issue");
                window.setScene(scene1);
                window.setTitle("Watson Paint Line");
            }
        });

        /* Conditions for Button 7! */
        Button button7 = new Button("Return Home");
        button7.setEffect(shadow);
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene1);
                window.setTitle("Watson Paint Line");
            }
        });

        /* Conditions for Video1 play button! */
        Button play1 = new Button("Play");
        play1.setEffect(shadow);
        play1.setStyle("-fx-font: 14 arial; -fx-base: #009900;");
        play1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pauseVar == 1) {
                    mediaPlayer1.play();
                    pauseVar = 0;
                }
                else {
                    mediaPlayer1.stop();
                    mediaPlayer1.play();
                }
            }
        });

         /* Conditions for Video2 play button! */
        Button play2 = new Button("Play");
        play2.setEffect(shadow);
        play2.setStyle("-fx-font: 14 arial; -fx-base: #009900;");
        play2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pauseVar == 1) {
                    mediaPlayer2.play();
                    pauseVar = 0;
                }
                else {
                    mediaPlayer2.stop();
                    mediaPlayer2.play();
                }}
        });

         /* Conditions for Video3 play button! */
        Button play3 = new Button("Play");
        play3.setEffect(shadow);
        play3.setStyle("-fx-font: 14 arial; -fx-base: #009900;");
        play3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pauseVar == 1) {
                    mediaPlayer3.play();
                    pauseVar = 0;
                }
                else {
                    mediaPlayer3.stop();
                    mediaPlayer3.play();
                }}
        });

         /* Conditions for Video4 play button! */
        Button play4 = new Button("Play");
        play4.setEffect(shadow);
        play4.setStyle("-fx-font: 14 arial; -fx-base: #009900;");
        play4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pauseVar == 1) {
                    mediaPlayer4.play();
                    pauseVar = 0;
                }
                else {
                    mediaPlayer4.stop();
                    mediaPlayer4.play();
                }}
        });

         /* Conditions for Video5 play button! */
        Button play5 = new Button("Play");
        play5.setEffect(shadow);
        play5.setStyle("-fx-font: 14 arial; -fx-base: #009900;");
        play5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pauseVar == 1) {
                    mediaPlayer5.play();
                    pauseVar = 0;
                }
                else {
                    mediaPlayer5.stop();
                    mediaPlayer5.play();
                }}
        });

        /* Conditions for Video6 play button! */
        Button play6 = new Button("Play");
        play6.setEffect(shadow);
        play6.setStyle("fx-font: 14 arial; -fx-base: #009900;");
        play6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pauseVar == 1) {
                    mediaPlayer6.play();
                    pauseVar = 0;
                }
                else {
                    mediaPlayer6.stop();
                    mediaPlayer6.play();
                }}
        });

         /* Conditions for Video1 stop button! */
        Button stop1 = new Button("Stop");
        stop1.setEffect(shadow);
        stop1.setStyle("-fx-font: 14 arial; -fx-base: #FF0000;");
        stop1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer1.stop();
            }
        });

         /* Conditions for Video2 stop button! */
        Button stop2 = new Button("Stop");
        stop2.setEffect(shadow);
        stop2.setStyle("-fx-font: 14 arial; -fx-base: #FF0000;");
        stop2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer2.stop();
            }
        });

         /* Conditions for Video3 stop button! */
        Button stop3 = new Button("Stop");
        stop3.setEffect(shadow);
        stop3.setStyle("-fx-font: 14 arial; -fx-base: #FF0000;");
        stop3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer3.stop();
            }
        });

         /* Conditions for Video4 stop button! */
        Button stop4 = new Button("Stop");
        stop4.setEffect(shadow);
        stop4.setStyle("-fx-font: 14 arial; -fx-base: #FF0000;");
        stop4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer4.stop();
            }
        });

         /* Conditions for Video5 stop button! */
        Button stop5 = new Button("Stop");
        stop5.setEffect(shadow);
        stop5.setStyle("-fx-font: 14 arial; -fx-base: #FF0000;");
        stop5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer5.stop();
            }
        });

        Button stop6 = new Button("Stop");
        stop6.setEffect(shadow);
        stop6.setStyle("-fx-font: 14 arial; -fx-base: #FF0000;");
        stop6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer6.stop();
            }
        });

         /* Conditions for Video1 pause button! */
        Button pause1 = new Button("Pause");
        pause1.setEffect(shadow);
        pause1.setStyle("-fx-font: 14 arial; -fx-base: #0066FF;");
        pause1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer1.pause();
                pauseVar = 1;
            }
        });

         /* Conditions for Video2 pause button! */
        Button pause2 = new Button("Pause");
        pause2.setEffect(shadow);
        pause2.setStyle("-fx-font: 14 arial; -fx-base: #0066FF;");
        pause2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer2.pause();
                pauseVar = 1;
            }
        });

         /* Conditions for Video3 pause button! */
        Button pause3 = new Button("Pause");
        pause3.setEffect(shadow);
        pause3.setStyle("-fx-font: 14 arial; -fx-base: #0066FF;");
        pause3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer3.pause();
                pauseVar = 1;
            }
        });

         /* Conditions for Video4 pause button! */
        Button pause4 = new Button("Pause");
        pause4.setEffect(shadow);
        pause4.setStyle("-fx-font: 14 arial; -fx-base: #0066FF;");
        pause4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer4.pause();
                pauseVar = 1;
            }
        });

         /* Conditions for Video5 pause button! */
        Button pause5 = new Button("Pause");
        pause5.setEffect(shadow);
        pause5.setStyle("-fx-font: 14 arial; -fx-base: #0066FF;");
        pause5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer5.pause();
                pauseVar = 1;
            }
        });

        /* Conditions for Video6 pause button! */
        Button pause6 = new Button("Pause");
        pause6.setEffect(shadow);
        pause6.setStyle("-fx-font: 14 arial; -fx-base: #0066FF;");
        pause6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayer6.pause();
                pauseVar = 1;
            }
        });


        BorderPane borderPane1 = new BorderPane();
        BorderPane borderPane2 = new BorderPane();
        BorderPane borderPane3 = new BorderPane();
        BorderPane borderPane4 = new BorderPane();
        BorderPane borderPane5 = new BorderPane();
        BorderPane borderPane6 = new BorderPane();

        /* Layout1! */
        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(choiceBox, company, watsonButton);

        scene1 = new Scene(layout1, 1300, 1000);

        /* Conditions for borderPane1! */
        VBox vBox1 = new VBox();
        HBox hBox1 = new HBox(8);
        vBox1.getChildren().add(mediaView1);
        hBox1.getChildren().addAll(button1, play1, pause1, stop1);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(10, 10, 10, 10));

        borderPane1.setTop(hBox1);
        borderPane1.setCenter(vBox1);

        scene2 = new Scene(borderPane1, 1300, 1000);

        /* Conditions for borderPane2! */
        VBox vBox2 = new VBox();
        HBox hBox2 = new HBox(8);
        vBox2.getChildren().add(mediaView2);
        hBox2.getChildren().addAll(button2, play2, pause2, stop2);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(10, 10, 10, 10));

        borderPane2.setTop(hBox2);
        borderPane2.setCenter(vBox2);

        scene3 = new Scene(borderPane2, 1300, 1000);

        /* Conditions for borderPane3! */
        VBox vBox3 = new VBox();
        HBox hBox3 = new HBox(8);
        vBox3.getChildren().add(mediaView3);
        hBox3.getChildren().addAll(button3, play3, pause3, stop3);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(10, 10, 10, 10));

        borderPane3.setTop(hBox3);
        borderPane3.setCenter(vBox3);

        scene4 = new Scene(borderPane3, 1300, 1000);

        /* Conditions for borderPane4! */
        VBox vBox4 = new VBox();
        HBox hBox4 = new HBox(8);
        vBox4.getChildren().add(mediaView4);
        hBox4.getChildren().addAll(button4, play4, pause4, stop4);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.setPadding(new Insets(10, 10, 10, 10));

        borderPane4.setTop(hBox4);
        borderPane4.setCenter(vBox4);

        scene5 = new Scene(borderPane4, 1300, 1000);

        /* Conditions for borderPane5! */
        VBox vBox5 = new VBox();
        HBox hBox5 = new HBox(8);
        vBox5.getChildren().add(mediaView5);
        hBox5.getChildren().addAll(button5, play5, pause5, stop5);
        hBox5.setAlignment(Pos.CENTER);
        hBox5.setPadding(new Insets(10, 10, 10, 10));

        borderPane5.setTop(hBox5);
        borderPane5.setCenter(vBox5);

        scene6 = new Scene(borderPane5, 1300, 1000);

        /* Conditions for borderPane6! */
        VBox vBox6 = new VBox();
        HBox hBox6 = new HBox(8);
        vBox6.getChildren().add(mediaView6);
        hBox6.getChildren().addAll(button6, play6, pause6, stop6);
        hBox6.setAlignment(Pos.CENTER);
        hBox6.setPadding(new Insets(10, 10, 10, 10));

        borderPane6.setTop(hBox6);
        borderPane6.setCenter(vBox6);

        scene7 = new Scene(borderPane6, 1300, 1000);





        /* Starting parameters for primaryStage! */
        window.setScene(scene1);
        window.setTitle("Watson Paint Line");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        window.show();




        /* Setup to convert the outputStream from System to a designated file (out.txt) */
        PrintWriter outputStream = new PrintWriter("out.txt");

        /* Conditions to set up a calendar and get the time of the day plus, year, month, and day! */
            Calendar calendar = new GregorianCalendar(Locale.ENGLISH);

        /* Conditions to evaluate the day of the week and Email the logging file (out.txt) on Sunday! */
            dayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK));
            if (dayOfWeek == 1 && emailSent != 1) {
                outputStream.println("Video1 views: " + Video1);
                outputStream.println("Video2 views: " + Video2);
                outputStream.println("Video3 views: " + Video3);
                outputStream.println("Video4 views: " + Video4);
                outputStream.println("Video5 views: " + Video5);
                outputStream.println("Welcome Video views: " + Video6);
                outputStream.println("Date: " + calendar.getTime());
                outputStream.close();
                sendMail.SendEmail();
                emailSent = 1;
                Video1 = 0;
                Video2 = 0;
                Video3 = 0;
                Video4 = 0;
                Video5 = 0;
                Video6 = 0;
            }
            if (dayOfWeek == 2 && emailSent == 1) {
                emailSent = 0;
            }

} /* Closing bracket for public void start! */



    private void LoginWindow() {

        Boolean accept = LoginScreen.Login("Log in");

        /* Conditions for Button 7! */
        Button button7 = new Button("Return Home");
        button7.setEffect(shadow);
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene1);
                window.setTitle("Watson Paint Line");
            }
        });

        /* Setup for Labels used in Video Views Screen! */
        Label welcomeVideo = new Label("Welcome video views: " + Video6);
        Label video1views = new Label("Video1 views: " + Video1);
        Label video2views = new Label("Video2 views: " + Video2);
        Label video3views = new Label("Video3 views: " + Video3);
        Label video4views = new Label("Video4 views: " + Video4);
        Label video5views = new Label("Video5 views: " + Video5);

        /* Setup for Labels font style! */
        welcomeVideo.setFont(Font.font("null",FontWeight.BOLD.THIN, 20));
        video1views.setFont(Font.font("null", FontWeight.BOLD.THIN, 20));
        video2views.setFont(Font.font("null", FontWeight.BOLD.THIN, 20));
        video3views.setFont(Font.font("null", FontWeight.BOLD.THIN, 20));
        video4views.setFont(Font.font("null", FontWeight.BOLD.THIN, 20));
        video5views.setFont(Font.font("null", FontWeight.BOLD.THIN, 20));

        BorderPane borderPane7 = new BorderPane();

        /* Conditions for borderPane7! */
        VBox vBox7 = new VBox(8);
        VBox vBox8 = new VBox(8);
        vBox7.setPadding(new Insets(10, 10, 10, 10));
        vBox7.getChildren().addAll(welcomeVideo, video1views, video2views, video3views,
                video4views, video5views);
        vBox8.getChildren().add(button7);
        vBox8.setAlignment(Pos.CENTER);

        borderPane7.setLeft(vBox7);
        borderPane7.setCenter(vBox8);

        scene8 = new Scene(borderPane7, 1300, 1000);

        if (accept)
            window.setScene(scene8);
            window.setTitle("Video Views");
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Watson Paint Line", "        Are you sure you want to close the program?        ");
        if(answer)
            window.close();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
