import java.util.HashMap;
import java.util.Map;

class IsogramChecker {
    Map<String, Integer> letters = new HashMap<>();

    boolean isIsogram(String phrase) {
        if (phrase.isEmpty()) {
            return true;
        } else {
            addLetters(phrase);
        }
        for (Map.Entry<String, Integer> entry : letters.entrySet()) {
            if (entry.getValue() > 1) {
                return false;
            }
        }
        return true;
    }

    void addLetters(String phrase) {
        for (char c : phrase.toCharArray()) {
            String ch = String.valueOf(c).toLowerCase();
            if (!ch.equals("-") && (!ch.equals(" "))) {
                letters.put(ch, letters.getOrDefault(ch, 0) + 1);
            }
        }
    }

}
