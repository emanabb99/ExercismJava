import java.util.*;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        boolean doesntContainCard = collection.stream()
                .filter(c -> c.equals(card))
                .toList()
                .isEmpty();
        if (doesntContainCard) {
            collection.add(card);
        }

        return doesntContainCard;
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        boolean canTrade = false;
        int numberOfSameCards = 0;
        for (String card : myCollection) {
            for (String otherCard : theirCollection) {
                if (card.equals(otherCard)) {
                    numberOfSameCards++;
                }
            }
        }
        boolean shorterSet = myCollection.size() < theirCollection.size();
        if (shorterSet) {
            if (numberOfSameCards < myCollection.size()) {
                canTrade = true;
            }
        } else {
            if (numberOfSameCards < theirCollection.size()) {
                canTrade = true;
            }
        }
        return canTrade;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> newSet = new HashSet<>();
        Map<String, Integer> newMap = new HashMap<>();
        if (collections.size() == 1) {
            for (Set<String> set : collections) {
                for (String card : set) {
                    newSet.add(card);
                }
            }
            return newSet;
        } else {
            for (Set<String> set : collections) {
                for (String card : set) {
                    if (newMap.containsKey(card)) {
                        newMap.put(card, newMap.get(card) + 1);
                    } else {
                        newMap.put(card, 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : newMap.entrySet()) {
                if (entry.getValue() > 2) {
                    newSet.add(entry.getKey());
                }
            }
        }
        return newSet;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> newSet = new HashSet<>();
        for (Set<String> set : collections) {
            for (String card : set) {
                newSet.add(card);
            }
        }
        return newSet;
    }
}
