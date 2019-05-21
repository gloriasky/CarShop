package valadzko.kseniya.api;

import java.util.List;

public interface IShop {
    static IShop getInstance(){
        return null;
    }

    void sellCar(ICar car);

    List<ICar> getAllAvailableCars();

    void buyCar(ICar car);

    void exit();
}
