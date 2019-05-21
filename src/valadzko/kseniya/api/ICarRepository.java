package valadzko.kseniya.api;

import valadzko.kseniya.repositories.CarRepository;

import java.util.List;

public interface ICarRepository {
    static CarRepository getInstance(){
      return null;
    }

    void addCar(ICar car);
    List<ICar> getAllCars();
    void deleteCar(ICar car);
    void save();
}
