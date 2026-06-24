class CollatzCalculator {

    int computeStepCount(int start){
        if (start<=0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        int steps = 0;
        if (start==1) {
            return 0;
        }
        while (start > 1) {
            if (start%2==0) {
                start /= 2;
                steps++;
            }
            else {
                start *= 3;
                start += 1;
                steps++;
            }
        }
        return steps;
    }

}
