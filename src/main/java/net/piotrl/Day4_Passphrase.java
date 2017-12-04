package net.piotrl;

import java.util.*;
import java.util.stream.Collectors;

public class Day4_Passphrase {

    public List<String> correctPhrases(String input) {
        String[] lines = input.split("\n");

        return Arrays.stream(lines)
                .filter(line -> {
                    String[] words = line.split(" ");
                    Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
                    return words.length == uniqueWords.size();
                })
                .collect(Collectors.toList());
    }

    public List<String> correctPhrasesWithUniqueLetters(String input) {
        List<String> firstStep = correctPhrases(input);

        return firstStep.stream()
                .filter(line -> {
                    List<String> words = Arrays.asList(line.split(" "));
                    for (int i = 0; i < words.size(); i++) {
                        List<String> letters = Arrays.asList(words.get(i).split(""));
                        for (int j = i + 1; j < words.size(); j++) {
                            boolean isDuplicated = rewordDuplicated(letters, words.get(j));
                            if (isDuplicated) {
                                return false;
                            }
                        }
                    }
                    return true;
                }).collect(Collectors.toList());
    }

    private boolean rewordDuplicated(List<String> letters, String word) {
        List<String> lettersToCompare = new ArrayList<>(Arrays.asList(word.split("")));
        for (String letter : letters) {
            boolean remove = lettersToCompare.remove(letter);
            if (!remove) {
                return false;
            }
        }

        return letters.size() == word.length();
    }
}
