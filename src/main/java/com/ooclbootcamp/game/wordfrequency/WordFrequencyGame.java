package com.ooclbootcamp.game.wordfrequency;

import com.ooclbootcamp.game.wordfrequency.exception.CalculateErrorException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    private static final String LINE_BREAK = "\n";
    private static final String REGEX_SPLIT_DELIMITER = "\\s+";

    public String getResult(String sentence) throws CalculateErrorException {
        try {
            return this.getWordFrequencyResult(this.getSortedWordFrequency(this.getWords(sentence)));
        } catch (Exception exception) {
            throw new CalculateErrorException();
        }
    }

    private String getWordFrequencyResult(List<WordFrequency> wordFrequencyList) {
        return wordFrequencyList.stream()
                .map(this::getWordFrequencyResultLine)
                .collect(Collectors.joining(LINE_BREAK));
    }

    private String getWordFrequencyResultLine(WordFrequency wordFrequency) {
        return String.format("%s %d", wordFrequency.getWord(), wordFrequency.getCount());
    }

    public List<WordFrequency> getSortedWordFrequency(List<String> words) {
        return words.stream()
                .distinct()
                .map(word -> new WordFrequency(word, Collections.frequency(words, word)))
                .sorted(Comparator.comparing(WordFrequency::getCount).reversed())
                .collect(Collectors.toList());
    }

    private List<String> getWords(String sentence) {
        return  Arrays.asList(sentence.split(REGEX_SPLIT_DELIMITER));
    }
}
