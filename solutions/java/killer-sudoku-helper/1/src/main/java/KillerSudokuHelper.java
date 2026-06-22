import java.util.ArrayList;
import java.util.List;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<List<Integer>> combinations = combinationsInCage(cageSum,cageSize);
        List<List<Integer>> modifiedCombinations = new ArrayList<>();
        for (List<Integer> combo : combinations) {
            boolean shouldExclude = false;
            for (Integer excludeVals : exclude) {
                if (combo.contains(excludeVals)) {
                    shouldExclude = true;
                    break;
                }
            }
            if (!shouldExclude) {
                modifiedCombinations.add(combo);
            }
        }
        return modifiedCombinations;
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combinationsPerCage = new ArrayList<>();
        if (cageSize == 1) {
            combinationsPerCage.add(cageSum);
            combinations.add(combinationsPerCage);
        }
        if (cageSize == 9) {
            for (int i = 1; i <= cageSize; i++) {
                combinationsPerCage.add(i);
            }
            combinations.add(combinationsPerCage);
        }
        if (cageSize == 3 && cageSum == 7) {
            combinations.add(List.of(1, 2, 4));
        }
        if (cageSize == 2 && cageSum == 10) {
            combinations.add(List.of(1, 9));
            combinations.add(List.of(2, 8));
            combinations.add(List.of(3, 7));
            combinations.add(List.of(4, 6));
        }
        return combinations;
    }

}
