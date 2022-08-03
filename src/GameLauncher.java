import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        int choice = 0;

        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to Hangman!");

        while (!isValid){
            System.out.println("Please choose a difficulty level: 1-Easy 2-Medium 3-Hard");
            try{
                choice = input.nextInt();
                if (choice <= 3 && choice >= 1){
                    isValid = true;
                } else {
                    System.out.println("Invalid choice, please enter again");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid choice, please enter an integer");
                input.nextLine();
            }catch (Exception ex){
                System.out.println("Unexpected error, closing program");
                ex.printStackTrace();
                System.exit(1);
            }
        }

        String selectedWord = WordProcessor.wordsFetch(choice);

        int wrongCounter = 0;
        List<Character> guesses = new ArrayList<>();
        while (true){
            HangmanDrawer.drawHangman(wrongCounter);
            if (wrongCounter >= 6){
                System.out.println("Game Over!");
                System.out.printf("The word was: \"%s\"%n", selectedWord);
                break;
            }

        }
    }
}
