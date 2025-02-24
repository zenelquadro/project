import java.io.*;
import java.util.*;
import java.nio.file.*;

public class TextAnalyzer {
    private String text;
    private List<String> words;
    private List<String> sentences;

    public TextAnalyzer(String filePath) throws IOException {
        // Read the entire file content
        text = new String(Files.readAllBytes(Paths.get(filePath)));
        processText();
    }

    private void processText() {
        // Split text into words (removing punctuation and converting to lowercase)
        String[] wordsArray = text.toLowerCase().replaceAll("[^a-zA-Z\\s]", " ").split("\\s+");
        words = new ArrayList<>(Arrays.asList(wordsArray));
        words.removeIf(String::isEmpty);

        // Split text into sentences
        String[] sentencesArray = text.split("[.!?]+");
        sentences = new ArrayList<>(Arrays.asList(sentencesArray));
        sentences.removeIf(String::isEmpty);
    }

    // Rest of the methods remain the same
    public int getTotalWordCount() {
        return words.size();
    }

    public int getUniqueWordCount() {
        return new HashSet<>(words).size();
    }

    public double getAverageWordLength() {
        return words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
    }

    public int getSentenceCount() {
        return sentences.size();
    }

    public Map<String, Integer> getMostFrequentWords(int limit) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        return wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limit)
                .collect(HashMap::new, 
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        HashMap::putAll);
    }

    public String getLongestWord() {
        return words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public String getShortestWord() {
        return words.stream()
                .min(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public Map<Integer, Integer> getWordLengthDistribution() {
        Map<Integer, Integer> distribution = new TreeMap<>();
        for (String word : words) {
            int length = word.length();
            distribution.put(length, distribution.getOrDefault(length, 0) + 1);
        }
        return distribution;
    }
}