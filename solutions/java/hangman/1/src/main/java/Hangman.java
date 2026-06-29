import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Hangman {

    Observable<Output> play(Observable<String> words, Observable<String> letters) {
        String word = "secret";
        Status status;
        final String[] discovered = new String[]{"_", "_", "_", "_", "_", "_"};
        HashSet<String> guess = new HashSet<>();
        HashSet<String> misses = new HashSet<>();
        List<Part> partList = new ArrayList<>();
        Part[] parts = Part.values();

        letters.subscribe(letter -> {
            if (word.contains(letter)) {
                guess.add(letter);
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter.charAt(0)) {
                        discovered[i] = letter;
                    }
                }
            } else {
                misses.add(letter);
                partList.add(parts[partList.size()]);
            }});

            String discoveredString = "";
            for (String ch : discovered) {
                discoveredString = discoveredString.concat(ch);
            }

            if (partList.size()<6 && discoveredString.contains("_")) {
                status = Status.PLAYING;
            }
            else if(partList.size()<=6 && !discoveredString.contains("_")) {
                status = Status.WIN;
            }
            else{
                status = Status.LOSS;
            }
            Observable<Output> output = Observable.just(new Output("secret", discoveredString, guess, misses, partList, status));
            return output;
        }
    }
