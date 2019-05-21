package valadzko.kseniya.repositories;

import valadzko.kseniya.api.ICar;
import valadzko.kseniya.api.ICarRepository;
import valadzko.kseniya.utils.XMLHelper;

import java.util.List;

public class CarRepository implements ICarRepository {
    private List<ICar> availableCars;
    private static Integer lastId;
    private static ICarRepository carRepository;

    private CarRepository(){
        this.availableCars = (List<ICar>) XMLHelper.readFromXML();
        lastId = 0;
    }

    public static ICarRepository getInstance(){
        if(carRepository == null){
            carRepository = new CarRepository();
        }
        return carRepository;
    }

    public void addCar(ICar car){
        lastId = this.availableCars.size();
        car.setId(++lastId);
        this.availableCars.add(car);
    }
    public List<ICar> getAllCars(){
        return this.availableCars;
    }
    public void deleteCar(ICar car){
        this.availableCars.remove(car);
    }
    public void save(){
        XMLHelper.writeToXML(this.availableCars);
    }
}
