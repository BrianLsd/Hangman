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

    public static String getUserGuess(Scanner input){
        System.out.println("Enter a single letter to guess: ");
        return input.nextLine();
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
}
