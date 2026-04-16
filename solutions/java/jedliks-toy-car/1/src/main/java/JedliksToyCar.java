public class JedliksToyCar {
    int distanceDriven = 0;
    int batteryPercentage = 100;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distanceDriven + " meters";
    }

    public String batteryDisplay() {
        if (batteryPercentage > 0) {
            return "Battery at " + batteryPercentage + "%";
        }
        else {
            return "Battery empty";
        }
    }

    public void drive() {
        if (batteryPercentage > 0) {
            distanceDriven += 20;
            batteryPercentage --;
        }
    }
}
