public class ExperimentalRemoteControlCar implements RemoteControlCar{
    int miles = 0;

    public void drive() {
        miles += 20;
    }

    public int getDistanceTravelled() {
        return miles;
    }
}
