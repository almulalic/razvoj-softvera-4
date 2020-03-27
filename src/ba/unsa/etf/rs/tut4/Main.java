package ba.unsa.etf.rs.tut4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/UI.fxml"));
        primaryStage.setTitle("Tutorijal 3");
        primaryStage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        primaryStage.setMinHeight(120);
        primaryStage.setMinWidth(200);
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);}
}
