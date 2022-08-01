import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        boolean isValid = false;
        int choice = 0;

        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to Hangman!");

        while (!isValid){
            Scanner input = new Scanner(System.in);
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
            }catch (Exception ex){
                System.out.println("Unexpected error, closing program");
                ex.printStackTrace();
                System.exit(1);
            }
        }

        String selectedWord = WordGenerator.wordGenerator(choice);
    }
}
