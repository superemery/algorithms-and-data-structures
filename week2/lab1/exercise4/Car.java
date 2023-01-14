public class Car {
    private String registration;
    private String make;
    private double price;

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayCarDetails() {
        System.out.println("Registration:\t" + registration);
        System.out.println("Make:\t\t" + make);
        System.out.println("Price:\t\t" + price);
    }

    public String getRegistration() {
        return registration;
    }

    public String getMake() {
        return make;
    }

    public double getPrice() {
        return price;
    }
}
