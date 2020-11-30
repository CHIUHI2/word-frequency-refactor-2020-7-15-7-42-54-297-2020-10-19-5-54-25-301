import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

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
        //split the input string with 1 to n pieces of spaces
        String[] arr = sentence.split(REGEX_SPLIT_DELIMITER);

        List<WordFrequency> wordFrequencyList = new ArrayList<>();
        for (String s : arr) {
            WordFrequency wordFrequency = new WordFrequency(s, 1);
            wordFrequencyList.add(wordFrequency);
        }

        //get the map for the next step of sizing the same word
        Map<String, List<WordFrequency>> map = getListMap(wordFrequencyList);

        List<WordFrequency> list = new ArrayList<>();
        for (Map.Entry<String, List<WordFrequency>> entry : map.entrySet()) {
            WordFrequency wordFrequency = new WordFrequency(entry.getKey(), entry.getValue().size());
            list.add(wordFrequency);
        }
        wordFrequencyList = list;

        return wordFrequencyList;
    }


    private Map<String, List<WordFrequency>> getListMap(List<WordFrequency> wordFrequencyList) {
        Map<String, List<WordFrequency>> map = new HashMap<>();
        for (WordFrequency wordFrequency : wordFrequencyList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(wordFrequency.getWord())) {
                ArrayList arr = new ArrayList<>();
                arr.add(wordFrequency);
                map.put(wordFrequency.getWord(), arr);
            } else {
                map.get(wordFrequency.getWord()).add(wordFrequency);
            }
        }

        return map;
    }
}
