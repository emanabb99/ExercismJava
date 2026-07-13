import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {
    List<Integer> primeNumbers = new ArrayList<>(List.of(2));

    int nth(int nth) {
        if (nth<=0) {
            throw new IllegalArgumentException();
        }
        int number = 3;
        while (primeNumbers.size() < nth) {
            if (checkPrime(number)) {
                primeNumbers.add(number);
            }
            number += 2;
        }
        return primeNumbers.get(nth-1);
    }

    boolean checkPrime(int number) {
        int limit = (int) Math.sqrt(number);
        for (int prime: primeNumbers) {
            if (prime>limit) {
                break;
            }
            if (number % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
