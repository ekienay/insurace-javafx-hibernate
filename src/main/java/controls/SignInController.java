package controls;

import java.io.IOException;

import dao.DAO;
import entity.Agent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.AgentService;

public class SignInController {

    private  final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ObservableList<Agent> agentObservableList = FXCollections.observableArrayList();
    private Agent agentItem;

    @FXML
    private PasswordField AgentPassword;

    @FXML
    private ComboBox<Agent> AgentComboBox;

    @FXML
    private Label status;


    @FXML
    private Button close;

    @FXML
    void signIn(ActionEvent event) throws IOException {
        for (Agent agent : agentObservableList){
            if (String.valueOf(AgentComboBox.getValue().getLogin()).equals(agent.getLogin()) && AgentPassword.getText().trim().equals(agent.getPassword())){
                Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanel.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Panel");
                stage.setScene(new Scene(root));
                stage.getIcons().add(new Image("icon/insurance-icon.jpg"));
                stage.show();
                 close.getScene().getWindow().hide();
            }else {
                status.setText("Wrong login or pass");

            }
        }

    }

    @FXML
    void initialize() {
        DAO<Agent> agentIntegerDAO = new AgentService(factory);
        agentObservableList.addAll(agentIntegerDAO.findByAll());

        AgentComboBox.setItems(agentObservableList);
        AgentComboBox.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
            agentItem = newValue; });


    }
}
