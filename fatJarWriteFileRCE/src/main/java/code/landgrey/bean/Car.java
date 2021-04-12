package code.landgrey.bean;


public class Car{
    private String brand;
    private long price;

    public Car(){

    }

    public Car(String brand){
        this.brand = brand;
    }

    public Car(String brand, long price){
        this.brand = brand;
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " [brand: '" + brand + "', price: '" + price + "'] ";
    }
}