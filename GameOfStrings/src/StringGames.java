import java.util.InputMismatchException;
import java.util.Scanner;

public class StringGames {
    public static void main (String [] args) {

        GameOfStrings stringObject = null;
        String inputString = null;
        int menuChoice = 0;
        while (true) {
            System.out.println("\n*************************************\n");
            System.out.println("\tGame of Strings\t");
            String displayMenu = " 1. Find Vowels\n 2. Reverse String\n 3. Check Palindrome\n" +
                    " 4. Find number of words\n 5. Play Pig Latin\n 6. Fortune Teller\n 7. News Feed\n 8. Exit";
            System.out.println(displayMenu);
            System.out.println("\n*************************************\n");

            System.out.println("Enter your choice - ");
            Scanner inputReader = new Scanner(System.in);

            try {
                menuChoice = inputReader.nextInt(); // Accepts only integer
            } catch (InputMismatchException exception) {
                // Ignore exception and prompt user to try again.
                System.out.println("Invalid option! Please try again.");
                continue;
            }

            // inputReader.nextInt() does not accept last newline character, so nextLine() method will
            // skip getting input. Workaround - fire a lonely nextLine() to consume it.
            inputReader.nextLine();

            if (menuChoice == 1 || menuChoice == 2 || menuChoice == 3 || menuChoice == 4 || menuChoice == 5 ) {
                System.out.println("Menu choice " + menuChoice);
                System.out.println("Enter the string:");
                inputString = inputReader.nextLine();
                stringObject = new GameOfStrings(inputString);
            }

            switch (menuChoice) {
                case 1:
                    System.out.println("Find number of vowels in any given input");
                    stringObject.countVowels();
                    break;
                case 2:
                    System.out.println("String input reversal");
                    String str = stringObject.reverseString();
                    System.out.println("Reversed string is " + str);
                    break;
                case 3:
                    System.out.println("Check if any given string is a palindrome");
                    stringObject.checkStringPalindrome();
                    break;
                case 4:
                    System.out.println("Find number of words in any given input");
                    int count = stringObject.countWordsInString();
                    System.out.println("Number of words in input - " + inputString + " is " + count);
                    break;
                case 5:
                    System.out.println("\n******************************************************************************************\n");
                    System.out.println("Play Pig Latin.");
                    System.out.println("Pig Latin - For words that start with a vowel, the string \"way\" is added to the end." +
                            "Example - eat becomes eatway. For words that don't start with vowel, all letters before the" +
                            " vowel are moved to the end and string \"ay\" is added to the end. Example - trash becomes ashtray");
                    System.out.println("\n******************************************************************************************\n");
                    stringObject.convertToPigLatin();
                    break;
                case 6:
                    System.out.println("Fortune Teller");
                    System.out.println("Enter the zodiac sign to get a short description for today's horoscope :");
                    String zodiac = inputReader.nextLine();
                    GameOfStrings zodiacSign = new GameOfStrings(zodiac);
                    try {
                        zodiacSign.printFortuneForZodiac();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("NDTV News reporter - Top headlines for you!");
                    System.out.println("News Reporter - Enter the search term");
                    String searchTerm = inputReader.nextLine();
                    GameOfStrings news = new GameOfStrings(searchTerm);
                    try {
                        news.printRegionalNewsFromNDTV();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    System.out.println("Thank you for using my \"Game of Strings\" program");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please enter between 1-8");
                    break;
            }
            System.out.println("Do you want to continue? (y/n)");
            String continueChoice = inputReader.nextLine();
            if (continueChoice.equalsIgnoreCase("y")) {
                continue;
            } else {
                System.out.println("Thank you for using my \"Game of Strings\" program");
                System.exit(0);
            }
        }
    }
}