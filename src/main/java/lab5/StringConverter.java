package lab5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringConverter {

    public static LinkedList<String> getUniqueWordsFromFirstSentence(final String sentences) {

        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalArgumentException("null or empty input parameter");
        }

        String sentencesToSplit = sentences.replace(",", "");

        String[] splitSentences = sentencesToSplit.split("\\. ", 2);

        String[] arrayOfFirstSentence = splitSentences[0].split(" ");
        String[] arrayOfOtherWords = splitSentences[1].replace(".", "").split(" ");

        List<String> listOfOtherWords = Arrays.asList(arrayOfOtherWords);

        LinkedList<String> resultListOfWords = new LinkedList<>();

        for (String word : arrayOfFirstSentence) {
            if (!listOfOtherWords.contains(word)) {
                resultListOfWords.add(word);
            }
        }

        return resultListOfWords;
    }
}
