object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        var number = start
        var steps = 0

        if (number < 1) {
            throw IllegalArgumentException()
        }

        while (number != 1) {
            steps++
            if (number % 2 == 0) {
                number /= 2
            }
            else {
                number = (number * 3) + 1
            }
        }
        return steps
    }
}
