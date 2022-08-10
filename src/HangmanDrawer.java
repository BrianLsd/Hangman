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
                break;
            case 2:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=======");
                break;
            case 3:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=======");
                break;
            case 4:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=======");
                break;
            case 5:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/    |");
                System.out.println("     |");
                System.out.println("=======");
                break;
            case 6:
                System.out.println("-+---+-");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/ \\  |");
                System.out.println("     |");
                System.out.println("=======");
                break;
        }
    }
    public static void drawLogo(){
        System.out.println(" .       __ .____  .       ___    ___   __   __ .____        _______   ___        __  __     .    __    _   ___   __   __     .    __    _\n" +
                " /       |  /      /     .'   \\ .'   `. |    |  /           '   /    .'   `.      |   |     /|    |\\   |  .'   \\  |    |     /|    |\\   | \n" +
                " |       |  |__.   |     |      |     | |\\  /|  |__.            |    |     |      |___|    /  \\   | \\  |  |       |\\  /|    /  \\   | \\  | \n" +
                " |  /\\   /  |      |     |      |     | | \\/ |  |               |    |     |      |   |   /---'\\  |  \\ |  |    _  | \\/ |   /---'\\  |  \\ | \n" +
                " |,'  \\,'   /----/ /---/  `.__,  `.__.' /    /  /----/          /     `.__.'      /   / ,'      \\ |   \\|   `.___| /    / ,'      \\ |   \\| ");
        System.out.println();
    }
}
