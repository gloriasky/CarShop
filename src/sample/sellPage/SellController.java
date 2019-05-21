package sample.sellPage;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.BaseController;
import sample.Main;
import valadzko.kseniya.api.IShop;
import valadzko.kseniya.facade.Shop;
import valadzko.kseniya.model.cars.Car;
import valadzko.kseniya.utils.Validator;
import java.net.URL;
import java.util.ResourceBundle;

public class SellController extends BaseController implements Initializable {

    public Button btnBack;
    public Button submitBtn;
    public TextField modelField;
    public TextField dateOfReleaseField;
    public TextField countryField;
    public TextField priceField;
    public Label wrong;
    public Label dateOfReleaseLbl;
    public Label priceLbl;
    private IShop shop = Shop.getInstance();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnBack.setOnAction(event -> Main.getNavigation().GoBack());

        submitBtn.setOnAction(event -> {
            String model = modelField.getText();
            String price = priceField.getText();
            String country = countryField.getText();
            String year = dateOfReleaseField.getText();

            Car car = Validator.tryToParse(model,price,year,country);
            if(car!=null) {
                shop.sellCar(car);
                Main.getNavigation().GoBack();
            }
            else{
                wrong.setText("Вы что-то ввели неправильно! Перепроверьте результаты!");
            }
        });

        dateOfReleaseField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    dateOfReleaseField.setStyle("-fx-background-color: red;");
                    dateOfReleaseLbl.setText("Введены нечисловые символы");
                }
                else{
                    dateOfReleaseField.setStyle("");
                    dateOfReleaseLbl.setText("");
                }
            }
        });
        priceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    priceField.setStyle("-fx-background-color: red;");
                    dateOfReleaseLbl.setText("Введены нечисловые символы");
                }
                else{
                    priceField.setStyle("");
                    dateOfReleaseLbl.setText("");
                }
            }
        });
    }
}
