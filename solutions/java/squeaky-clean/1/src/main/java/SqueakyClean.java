import java.util.HashMap;
import java.util.Map;

class SqueakyClean {
    static Map<Integer,Character> numberToChar = new HashMap<>();

    static void addToMap() {
        numberToChar.put(0,'o');
        numberToChar.put(1,'l');
        numberToChar.put(3,'e');
        numberToChar.put(4,'a');
        numberToChar.put(7,'t');
    }

    static String clean(String identifier) {
        addToMap();
        if (identifier.isEmpty()){
            return "";
        }
        else {
            if (identifier.contains("-")) {
                int index = identifier.indexOf("-");
                char letterToReplace = identifier.charAt(index+1);
                identifier = identifier.replace(letterToReplace, Character.toUpperCase(letterToReplace));
                identifier = identifier.replace("-","");
            }
            for (char ch: identifier.toCharArray()) {
                if (Character.isDigit(ch)) {
                    int characterInt = ch - '0';
                    identifier = identifier.replace(ch,numberToChar.get((Integer)characterInt));
                }
            }
            identifier = identifier.replaceAll("[^a-zA-Z0-9 ]","");
            identifier = identifier.replace(" ","_");
            return identifier;
        }
    }
}
