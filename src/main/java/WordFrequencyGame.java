import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    private static final String LINE_BREAK = "\n";
    private static final String REGEX_SPLIT_DELIMITER = "\\s+";

    public String getResult(String sentence) throws CalculateErrorException {
        try {
            List<WordFrequency> wordFrequencyList = this.calculateWordFrequency(sentence);

            wordFrequencyList.sort((w1, w2) -> w2.getCount() - w1.getCount());

            return this.getWordFrequencyResult(wordFrequencyList);
        } catch (Exception exception) {
            throw new CalculateErrorException();
        }
    }

    private String getWordFrequencyResult(List<WordFrequency> wordFrequencyList) {
        StringJoiner joiner = new StringJoiner(LINE_BREAK);
        for (WordFrequency w : wordFrequencyList) {
            String s = w.getWord() + " " + w.getCount();
            joiner.add(s);
        }

        return joiner.toString();
    }

    private List<WordFrequency> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(REGEX_SPLIT_DELIMITER));

        return words.stream()
                .distinct()
                .map(word -> new WordFrequency(word, Collections.frequency(words, word)))
                .sorted(Comparator.comparing(WordFrequency::getCount).reversed())
                .collect(Collectors.toList());
    }
}
