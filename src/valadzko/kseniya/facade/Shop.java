package valadzko.kseniya.facade;

import valadzko.kseniya.api.IShop;
import valadzko.kseniya.repositories.CarRepository;
import valadzko.kseniya.api.ICar;
import valadzko.kseniya.api.ICarRepository;

import java.util.List;

public class Shop implements IShop {
    private static IShop shop;
    private ICarRepository availableCars;
    private Shop(){
        availableCars = CarRepository.getInstance();
    }
    public static IShop getInstance(){
        if(shop == null){
            shop = new Shop();
        }
        return shop;
    }

    public void sellCar(ICar car){
        availableCars.addCar(car);
    }

    public List<ICar> getAllAvailableCars(){
        return availableCars.getAllCars();
    }

    public void buyCar(ICar car){
        availableCars.deleteCar(car);
    }

    public void exit(){
        availableCars.save();
    }
}
