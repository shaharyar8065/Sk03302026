package classes;

public class Thermostat {
    private String room;
    private String mode;
    private int temperature;

    public Thermostat(String room) {
        this.room = room;
        this.temperature = 70; // Standard room temp
        this.mode = "Off";
    }

    public void setTemperature(int newTemp) {
        if (newTemp >= 50 && newTemp <= 90) {
            this.temperature = newTemp;
            System.out.println(room + " temperature set to " + temperature + "°F.");
        } else {
            System.out.println("Error: Temperature must be between 50 and 90.");
        }
    }

    public void changeMode(String newMode) {
        if (newMode.equals("Heating") || newMode.equals("Cooling") || newMode.equals("Off")) {
            this.mode = newMode;
            System.out.println(room + " is now in " + mode + " mode.");
        } else {
            System.out.println("Invalid mode! Use: Heating, Cooling, or Off.");
        }
    }

    @Override
    public String toString() {
        return "Thermostat{" +
                "room='" + room + '\'' +
                ", mode='" + mode + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
