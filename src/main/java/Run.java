
import dao.DAO;
import entity.Driver;
import entity.Osago;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Run extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/SignInWindow.fxml"));
        stage.setTitle("Окно входа");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("icon/insurance-icon.jpg"));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
