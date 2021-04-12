package code.landgrey.bean;

public class User {
    private String name;
    private Integer age;
    private Car car;
    private Object secret;

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Object getSecret() {
        return secret;
    }

    public void setSecret(Object secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        if(car != null && secret != null){
            return "name: '" + name + "', age: '" + age + "', car: '" + car.toString() + "', secret: '" + secret.toString() + "'";
        }
        return "name: '" + name + "', age: '" + age + "'";
    }

}
