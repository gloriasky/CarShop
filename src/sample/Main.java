package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import valadzko.kseniya.facade.Shop;

public class Main extends Application {

    private static Navigation navigation;

    public static Navigation getNavigation()
    {
        return navigation;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        navigation = new Navigation(primaryStage);

        primaryStage.setTitle("My shop system");
        primaryStage.show();

        Main.getNavigation().load("/sample/startingPage/sample.fxml").Show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        Shop.getInstance().exit();
        super.stop();
    }
}
