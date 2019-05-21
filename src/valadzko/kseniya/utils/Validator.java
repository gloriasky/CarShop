package valadzko.kseniya.utils;

import valadzko.kseniya.model.cars.Car;

public class Validator {
    public static Car tryToParse(String model, String strPrice, String strYear, String country){
        try {
            int price = Integer.parseInt(strPrice);
            int year = Integer.parseInt(strYear);
            if (price > 0 && year > 0 && model != null && country != null) {
                return new Car(model, price, year, country);
            } else {
                return null;
            }
        }catch (Exception e){
//            LogManager.getLogger(Validator.class.getName()).error(e.getMessage());
            return null;
        }
    }
}
