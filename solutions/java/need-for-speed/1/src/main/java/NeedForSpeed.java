class NeedForSpeed {
    int distanceDriven = 0;
    int batteryCapacity = 100;
    int batteryDrain;
    int speed;

    NeedForSpeed(int speed, int batteryDrain) {
        this.batteryDrain = batteryDrain;
        this.speed = speed;
    }

    public boolean batteryDrained() {
        return batteryCapacity < batteryDrain;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if (batteryCapacity >= batteryDrain) {
            distanceDriven += speed;
            batteryCapacity -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50,4);
    }
}

class RaceTrack {
    int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int numberOfDrives = distance / car.speed;
        for (int i = 0; i < numberOfDrives ; i++) {
            car.drive();
        }
        return car.distanceDriven == distance;
    }
}
