import java.util.*;

public class GameLauncher {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to Hangman!");
        List<String> easyWords = WordProcessor.wordsFetch(1);
        List<String> mediumWords = WordProcessor.wordsFetch(2);
        List<String> hardWords = WordProcessor.wordsFetch(3);
        String selectedWord;
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

            // remove a word from the lists after a random word has been generated
            // so random words won't repeat until the end
            if (choice == 1){
                selectedWord = WordProcessor.wordGenerator(easyWords);
                easyWords.remove(String.valueOf(selectedWord));
            } else if (choice == 2){
                selectedWord = WordProcessor.wordGenerator(mediumWords);
                mediumWords.remove(String.valueOf(selectedWord));
            } else {
                selectedWord = WordProcessor.wordGenerator(hardWords);
                hardWords.remove(String.valueOf(selectedWord));
            }

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

            // refill the lists after all words have been used
            if (easyWords.size() == 0){
                easyWords = WordProcessor.wordsFetch(1);
            }
            if (mediumWords.size() == 0){
                mediumWords = WordProcessor.wordsFetch(2);
            }
            if (hardWords.size() == 0){
                hardWords = WordProcessor.wordsFetch(3);
            }

            System.out.println();
            System.out.println("Press 1 to play again, or press any other keys to quit");
            input.nextLine();
            continueGame = input.nextLine();
        } while (continueGame.equals("1"));
    }
}
