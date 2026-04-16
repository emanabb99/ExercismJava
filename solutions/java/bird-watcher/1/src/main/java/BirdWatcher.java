
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return new int[] {0,2,5,3,7,8,4};
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length-1]++;
    }

    public boolean hasDayWithoutBirds() {
        boolean hasDayWithoutBirds = false;
        for (int i : birdsPerDay){
            if (i == 0) {
                hasDayWithoutBirds = true;
                break;
            }
        }
        return hasDayWithoutBirds;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;
        if (numberOfDays<birdsPerDay.length) {
            for (int i = 0 ; i < numberOfDays; i++){
                count += birdsPerDay[i];
            }
        }
        else {
            for (int i = 0; i < birdsPerDay.length; i++){
                count += birdsPerDay[i];
            }
        }
        return count;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for (int i : birdsPerDay){
            if (i >= 5) {
                busyDays ++;
            }
        }
        return busyDays;
    }
}
