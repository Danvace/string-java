package lab5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringConverter {
    public static LinkedList<String> getUniqueWordsFromFirstSentence(String sentences) {

        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException("null or empty input parameter");
        }

        sentences = sentences.replace(",", "");

        String[] splitSentences = sentences.split("\\. ", 2);

        String[] listOfFirsSentence = splitSentences[0].split(" ");
        String[] arrayOfOtherWords = splitSentences[1].replace(".", "").split(" ");

        List<String> listOfOtherWords = Arrays.stream(arrayOfOtherWords).toList();

        LinkedList<String> resultListOfWords = new LinkedList<>();

        for (String word : listOfFirsSentence) {
            if (!listOfOtherWords.contains(word)) {
                resultListOfWords.add(word);
            }
        }

        return resultListOfWords;
    }
}
