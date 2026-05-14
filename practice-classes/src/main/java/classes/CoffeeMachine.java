package classes;

public class CoffeeMachine {
    private String brandName;
    private int waterCups;
    private boolean isPluggedIn;

    public CoffeeMachine(String brandName) {
        this.brandName = brandName;
        this.waterCups = 0;
        this.isPluggedIn = false;
    }

    public void addWater(int cups) {
        waterCups = waterCups + cups;
        System.out.println("Added " + cups + " cups. Total water: " + waterCups);
    }

    public void brew() {
        if (isPluggedIn && waterCups > 0) {
            waterCups--;
            System.out.println(brandName + " is brewing... Enjoy your coffee!");
        } else if (isPluggedIn) {
            System.out.println("Error: Please plug in the " + brandName + " first.");
        } else {
            System.out.println("Error: Out of water! Add more to brew.");
        }
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "brandName='" + brandName + '\'' +
                ", waterCups=" + waterCups +
                ", isPluggedIn=" + isPluggedIn +
                '}';
    }
}
