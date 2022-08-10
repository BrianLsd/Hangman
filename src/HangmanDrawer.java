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
        System.out.println(
                "          _______  _        _______  _______  _______  _______   _________ _______             _______  _        _______  _______  _______  _       \n" +
                "|\\     /|(  ____ \\( \\      (  ____ \\(  ___  )(       )(  ____ \\  \\__   __/(  ___  )  |\\     /|(  ___  )( (    /|(  ____ \\(       )(  ___  )( (    /|\n" +
                "| )   ( || (    \\/| (      | (    \\/| (   ) || () () || (    \\/     ) (   | (   ) |  | )   ( || (   ) ||  \\  ( || (    \\/| () () || (   ) ||  \\  ( |\n" +
                "| | _ | || (__    | |      | |      | |   | || || || || (__         | |   | |   | |  | (___) || (___) ||   \\ | || |      | || || || (___) ||   \\ | |\n" +
                "| |( )| ||  __)   | |      | |      | |   | || |(_)| ||  __)        | |   | |   | |  |  ___  ||  ___  || (\\ \\) || | ____ | |(_)| ||  ___  || (\\ \\) |\n" +
                "| || || || (      | |      | |      | |   | || |   | || (           | |   | |   | |  | (   ) || (   ) || | \\   || | \\_  )| |   | || (   ) || | \\   |\n" +
                "| () () || (____/\\| (____/\\| (____/\\| (___) || )   ( || (____/\\     | |   | (___) |  | )   ( || )   ( || )  \\  || (___) || )   ( || )   ( || )  \\  |\n" +
                "(_______)(_______/(_______/(_______/(_______)|/     \\|(_______/     )_(   (_______)  |/     \\||/     \\||/    )_)(_______)|/     \\||/     \\||/    )_)");
    }
}
