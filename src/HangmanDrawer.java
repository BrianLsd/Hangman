public class HangmanDrawer {
    public static void drawHangman(int counter) {
        switch (counter){
            case 0:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=======");
                break;
            case 1:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=======");
                System.out.println("Wrong guess, take another shot");
                break;
            case 2:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=======");
                System.out.println("Wrong guess, take another shot");
                break;
            case 3:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=======");
                System.out.println("Wrong guess, take another shot");
                break;
            case 4:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=======");
                System.out.println("Wrong guess, take another shot");
                break;
            case 5:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/    |");
                System.out.println("     |");
                System.out.println("=======");
                System.out.println("Wrong guess, take another shot");
                break;
            case 6:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/ \\  |");
                System.out.println("     |");
                System.out.println("=======");
                System.out.println("Wrong guess");
                break;
        }
    }
}
