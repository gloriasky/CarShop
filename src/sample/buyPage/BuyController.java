package sample.buyPage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import sample.BaseController;
import sample.Main;
import valadzko.kseniya.api.ICar;
import valadzko.kseniya.facade.Shop;
import valadzko.kseniya.repositories.CarRepository;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BuyController extends BaseController implements Initializable {
    @FXML
    public Button btnBack;
    public ListView<ICar> cars;
    public Button buyCarBtn;

    private ICar currentCar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBack.setOnAction(event -> Main.getNavigation().GoBack());
        List<ICar> xmlData = CarRepository.getInstance().getAllCars();
        ObservableList<ICar> listOfCars = FXCollections.observableArrayList();

        listOfCars.addAll(xmlData);

        cars.setItems(listOfCars);

        cars.setOnMouseClicked(event -> {
             MultipleSelectionModel<ICar> carsSelectionModel = cars.getSelectionModel();
             carsSelectionModel.selectedItemProperty().addListener(
                     (changed, oldValue, newValue) -> this.currentCar = newValue);
        });

        buyCarBtn.setOnAction(event -> {
             if(this.currentCar != null){
                 Shop.getInstance().buyCar(this.currentCar);
                 Main.getNavigation().GoBack();
             }
         });
    }
}
