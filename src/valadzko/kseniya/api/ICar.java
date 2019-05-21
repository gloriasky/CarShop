package valadzko.kseniya.api;

public interface ICar {
    String getModel();
    void setModel(String model);
    int getPrice();
    void setPrice(int price);
    int getYearOfRelease();
    void setYearOfRelease(int yearOfRelease);
    String getCountry();
    void setCountry(String country);
    Integer getId();
    void setId(Integer id);
    String toString();
}
