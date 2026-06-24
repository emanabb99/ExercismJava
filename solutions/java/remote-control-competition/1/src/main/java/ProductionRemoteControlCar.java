class ProductionRemoteControlCar implements RemoteControlCar,Comparable<ProductionRemoteControlCar>{
    int numberOfVictories = 0;
    int miles = 0;

    public void drive() {
        miles += 10;
    }

    public int getDistanceTravelled() {
        return miles;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        return other.getNumberOfVictories() - this.getNumberOfVictories();
    }

}
