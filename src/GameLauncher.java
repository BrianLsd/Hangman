import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameLauncher {
    public static void main(String[] args) {
        HangmanDrawer.drawLogo();
        List<String> easyWords = WordProcessor.wordListGenerator(1);
        List<String> mediumWords = WordProcessor.wordListGenerator(2);
        List<String> hardWords = WordProcessor.wordListGenerator(3);
        String selectedWord;
        String continueGame;

        // continuously playing background music until the program ends
        ExecutorService backGroundMusic = Executors.newCachedThreadPool();
        ExecutorService soundEffects = Executors.newCachedThreadPool();
        backGroundMusic.execute(new AudioPlayer("bgm.wav"));
        backGroundMusic.shutdown();

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
                selectedWord = WordProcessor.GenerateWord(easyWords);
                easyWords.remove(String.valueOf(selectedWord));
            } else if (choice == 2){
                selectedWord = WordProcessor.GenerateWord(mediumWords);
                mediumWords.remove(String.valueOf(selectedWord));
            } else {
                selectedWord = WordProcessor.GenerateWord(hardWords);
                hardWords.remove(String.valueOf(selectedWord));
            }

            int wrongCounter = 0;
            List<Character> guesses = new ArrayList<>();
            while (true){
                HangmanDrawer.drawHangman(wrongCounter);
                if (wrongCounter >= 6){ // when the man has been hung
                    System.out.println("Game Over, You lost...");
                    System.out.printf("The word was: \"%s\"%n", selectedWord);
                    soundEffects.execute(new SoundEffectsPlayer("gameover.wav"));
                    break;
                }
                WordProcessor.printWordState(guesses, selectedWord);
                WordProcessor.printGuessedLetters(guesses);
                if (!WordProcessor.getUserGuess(guesses, selectedWord)){ // wrong guess
                    wrongCounter++;
                    soundEffects.execute(new SoundEffectsPlayer("incorrect.wav"));
                } else { // right guess
                    soundEffects.execute(new SoundEffectsPlayer("correct.wav"));
                }
                if (WordProcessor.checkIfUserWins(guesses, selectedWord)){ // all letters have been guessed
                    System.out.println("Congrats! You win!");
                    soundEffects.execute(new SoundEffectsPlayer("victory.wav"));
                    break;
                }
            }

            // refill the lists after all words have been used
            if (easyWords.size() == 0){
                easyWords = WordProcessor.wordListGenerator(1);
            }
            if (mediumWords.size() == 0){
                mediumWords = WordProcessor.wordListGenerator(2);
            }
            if (hardWords.size() == 0){
                hardWords = WordProcessor.wordListGenerator(3);
            }

            System.out.println();
            System.out.println("Press 1 to play again, or press any other keys to quit");
            input.nextLine();
            continueGame = input.nextLine();
        } while (continueGame.equals("1"));
        soundEffects.shutdown();
    }
}
