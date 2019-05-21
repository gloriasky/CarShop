package valadzko.kseniya.model.cars;

import valadzko.kseniya.api.ICar;

import java.io.Serializable;

public class Car implements Serializable, ICar {
    private Integer id;
    private String model;
    private int price;
    private int yearOfRelease;
    private String country;

    public Car(){

    }


    public Car(String model, int price, int yearOfRelease, String country) {
        this.model = model;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
        this.country = country;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("Car ");
        sBuilder.append(id);
        sBuilder.append(": price = ");
        sBuilder.append(price);
        sBuilder.append(", model = ");
        sBuilder.append(model);
        sBuilder.append(", country = ");
        sBuilder.append(country);
        sBuilder.append(", year of release = ");
        sBuilder.append(yearOfRelease);
        return sBuilder.toString();

    }
}
