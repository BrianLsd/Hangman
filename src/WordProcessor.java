import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class WordProcessor {
    public static String wordsFetch(int choice){
        List<String> wordList = new ArrayList<>();
        Random ran = new Random();

        if (choice == 1){
            try(Scanner input = new Scanner(Paths.get("EasyWords.txt"))){
                while (input.hasNext()){
                    wordList.add(input.next());
                }
            } catch (IOException | NoSuchElementException | IllegalStateException e){
                e.printStackTrace();
                System.out.println("Unexpected error, closing program");
                System.exit(1);
            }
        } else if (choice == 2){
            try(Scanner input = new Scanner(Paths.get("MediumWords.txt"))){
                while (input.hasNext()){
                    wordList.add(input.next());
                }
            } catch (IOException | NoSuchElementException | IllegalStateException e){
                e.printStackTrace();
                System.out.println("Unexpected error, closing program");
                System.exit(1);
            }
        } else {
            try(Scanner input = new Scanner(Paths.get("HardWords.txt"))){
                while (input.hasNext()){
                    wordList.add(input.next());
                }
            } catch (IOException | NoSuchElementException | IllegalStateException e){
                e.printStackTrace();
                System.out.println("Unexpected error, closing program");
                System.exit(1);
            }
        }

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
