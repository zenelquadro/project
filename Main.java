import java.io.*;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.print("Enter the path to your text file (or 'exit' to quit): ");
                String filePath = scanner.nextLine();
                
                if (filePath.equalsIgnoreCase("exit")) {
                    break;
                }

                TextAnalyzer analyzer = new TextAnalyzer(filePath);
                
                while (true) {
                    displayMenu();
                    int choice = Integer.parseInt(scanner.nextLine());
                    
                    if (choice == 9) {
                        break;
                    }
                    
                    processChoice(analyzer, choice);
                    
                    System.out.print("\nWould you like to analyze something else? (y/n): ");
                    if (scanner.nextLine().toLowerCase().startsWith("n")) {
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\nText Analysis Options:");
        System.out.println("1. Total word count");
        System.out.println("2. Unique word count");
        System.out.println("3. Average word length");
        System.out.println("4. Sentence count");
        System.out.println("5. Most frequent words");
        System.out.println("6. Longest word");
        System.out.println("7. Shortest word");
        System.out.println("8. Word length distribution (Custom)");
        System.out.println("9. Exit");
        System.out.print("Enter your choice (1-9): ");
    }
    
    private static void processChoice(TextAnalyzer analyzer, int choice) {
        switch (choice) {
            case 1:
                System.out.println("Total word count: " + analyzer.getTotalWordCount());
                break;
            case 2:
                System.out.println("Unique word count: " + analyzer.getUniqueWordCount());
                break;
            case 3:
                System.out.printf("Average word length: %.2f\n", analyzer.getAverageWordLength());
                break;
            case 4:
                System.out.println("Sentence count: " + analyzer.getSentenceCount());
                break;
            case 5:
                System.out.print("Enter the number of frequent words to display: ");
                int limit = Integer.parseInt(scanner.nextLine());
                Map<String, Integer> frequentWords = analyzer.getMostFrequentWords(limit);
                System.out.println("Most frequent words:");
                frequentWords.forEach((word, count) -> 
                    System.out.printf("'%s': %d times\n", word, count));
                break;
            case 6:
                System.out.println("Longest word: " + analyzer.getLongestWord());
                break;
            case 7:
                System.out.println("Shortest word: " + analyzer.getShortestWord());
                break;
            case 8:
                Map<Integer, Integer> distribution = analyzer.getWordLengthDistribution();
                System.out.println("Word length distribution:");
                distribution.forEach((length, count) -> 
                    System.out.printf("%d letters: %d words\n", length, count));
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
}