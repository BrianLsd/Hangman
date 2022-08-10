import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class WordProcessor {
    public static List<String> wordListGenerator(int choice){
        WordProcessor wordProcessor = new WordProcessor();

        if (choice == 1){
            return wordProcessor.readFile("EasyWords.txt");
        }
        else if (choice == 2){
            return wordProcessor.readFile("MediumWords.txt");
        }
        else {
            return wordProcessor.readFile("HardWords.txt");
        }
    }

    public List<String> readFile(String file){
        List<String> wordList = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getResourceAsStream(file);
            try(Scanner input = new Scanner(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
                while (input.hasNext()){
                    wordList.add(input.next());
                }
            } catch (NoSuchElementException | IllegalStateException e){
                e.printStackTrace();
                System.out.println("Not able to load the file");
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Unexpected error, program closing...");
            System.exit(1);
        }
        return wordList;
    }

    public static String GenerateWord(List<String> wordList){
        Random ran = new Random();
        return wordList.get(ran.nextInt(wordList.size()));
    }

    public static boolean getUserGuess(List<Character> guesses, String word){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a single letter to guess: ");
        String letterGuess = input.nextLine().toLowerCase();
        if (letterGuess.matches("[a-z]")){
            guesses.add(letterGuess.charAt(0));
            return word.contains(letterGuess); // correct guess
        } else {
            System.out.println("Invalid input, please only guess a single letter");
            return false; // if user's guess is invalid, count it as incorrect
        }
    }

    public static void printGuessedLetters(List<Character> guesses){
        if (guesses.size() != 0){
            System.out.print("You have guessed: ");
            for (char c : guesses){
                System.out.printf("\"%c\" ", c);
            }
            System.out.println();
        }

    }

    public static void printWordState(List<Character> guesses, String word){
        for (char c : word.toCharArray()){
            if (guesses.contains(c)){
                System.out.printf("%c ", c);
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    public static boolean checkIfUserWins(List<Character> guesses, String word){
        int correctCounter = 0;
        for (char c : word.toCharArray()){
            if (guesses.contains(c)){
                correctCounter++;
            }
        }
        return (word.length() == correctCounter);
    }
}
