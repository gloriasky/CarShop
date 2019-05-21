package sample.startingPage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.BaseController;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class SampleController extends BaseController implements Initializable {
    @FXML
    public Button buyCarBtn;
    @FXML
    public Button sellCarBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        buyCarBtn.setOnAction(event -> Main.getNavigation().load("/sample/buyPage/buy.fxml").Show());

        sellCarBtn.setOnAction(event -> Main.getNavigation().load("/sample/sellPage/sell.fxml").Show());


    }
}
