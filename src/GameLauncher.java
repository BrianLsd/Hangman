import java.util.*;

public class GameLauncher {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to Hangman!");
        String continueGame;

        do {
            Scanner input = new Scanner(System.in);
            boolean isValid = false;
            int choice = 0;

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

            String selectedWord = WordProcessor.wordsFetch(choice); // generated word from a file

            int wrongCounter = 0;
            List<Character> guesses = new ArrayList<>();
            while (true){
                HangmanDrawer.drawHangman(wrongCounter);
                if (wrongCounter >= 6){
                    System.out.println("Game Over, You lost...");
                    System.out.printf("The word was: \"%s\"%n", selectedWord);
                    break;
                }
                WordProcessor.printWordState(guesses, selectedWord);
                WordProcessor.printGuessedLetters(guesses);
                if (!WordProcessor.getUserGuess(guesses, selectedWord)){
                    wrongCounter++;
                }
                if (WordProcessor.checkIfUserWins(guesses, selectedWord)){
                    System.out.println("Congrats! You win!");
                    break;
                }
            }
            System.out.println();
            System.out.println("Press 1 to play again, or press any other keys to quit");
            input.nextLine();
            continueGame = input.nextLine();
        } while (continueGame.equals("1"));

    }
}
