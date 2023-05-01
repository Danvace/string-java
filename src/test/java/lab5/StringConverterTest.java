package lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StringConverterTest {

    @Test
    void testNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringConverter.getUniqueWordsFromFirstSentence(null);
            StringConverter.getUniqueWordsFromFirstSentence("");
        });
    }

    @Test
    void testCommaDelete() {
        String sentencesWithCommas = "testWord,,,,,,hgvhvfdgfd . ";
        LinkedList<String> result = StringConverter.getUniqueWordsFromFirstSentence(sentencesWithCommas);
        Assertions.assertEquals(1, result.size());
        Assertions.assertFalse(result.contains(","));
    }

    @Test
    void testWithoutWords() {
        String sentencesWithoutWords = " . ";
        LinkedList<String> result = StringConverter.getUniqueWordsFromFirstSentence(sentencesWithoutWords);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testWithSentences() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("study", "at", "Internet", "of", "Things"));
        String sentenceWithWords = "I study at Internet of Things. I have, almost, finished, my first year ";
        LinkedList<String> result = StringConverter.getUniqueWordsFromFirstSentence(sentenceWithWords);

        Assertions.assertEquals(5, result.size());

        for (String word : expected) {
            Assertions.assertTrue(result.contains(word));
        }

    }

    @Test
    void testWithDotSentences() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("study", "at", "Internet", "of"));
        String sentenceWithWords = "I study at Internet of Things. I, almost finish my first year ....Things....";
        LinkedList<String> result = StringConverter.getUniqueWordsFromFirstSentence(sentenceWithWords);
        Assertions.assertEquals(4, result.size());

        for (String word : expected) {
            Assertions.assertTrue(result.contains(word));
        }

    }
}