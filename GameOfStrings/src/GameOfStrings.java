// Java Program which does many string operations based on input.
// Methods:
/*
    1. Count Vowels
    2. Check Palindrome
    3. Reverse String
    4. Count words
    5. Fortune Teller for a zodiac Sign (reads from URL)
 */
// Java Imports
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;
import java.nio.charset.Charset;

// Class definition
public class GameOfStrings {
    String str;

    //Constructor method
    GameOfStrings(String text) {
        str = text;
    }

    // Method to print the Input String
    public void printString() {
        System.out.println("You entered the string - " + str);
    }

    // Method to count vowels
    public int countVowels() {
        char c;
        int vowelCount = 0;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (isVowel(c)) {
                vowelCount++;
            }
        }
        System.out.println("Found "+ vowelCount + " vowels in the string "+ str);
        return vowelCount;
    }

    // Method to reverse String
    public String reverseString() {
        // New character array with same length as input string
        char [] reversedString = new char[str.length()];
        int i,j;

        // Reverse the string
        for (i = 0, j = str.length() - 1 ; i < str.length() ; i++, j--) {
            reversedString[j] = str.charAt(i);
        }
        String outputString = new String(reversedString);
        return outputString;
    }

    // Method to alter words to Pig Latin.
    /* Pig Latin - For words that start with a vowel, the string "way" is added to the end.
    Example - eat becomes eatway.
    For words that don't start with vowel, all letters before thw vowel are moved to the end
    and string "ay" is added to the end.
    Example - trash becomes ashtray
     */
    public String convertToPigLatin() {
        String forVowel = "way";
        String forConsanant = "ay";
        char [] pigLatinString = new char[str.length()];
        int count = 0;
        String finalString = null;

        // Check if String has vowels as first character, if found add "way"
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && isVowel(str.charAt(0))) {
                System.out.println("Pig Latin format for string "+ str + " is " + str+forVowel);
                finalString = str + forVowel; // Since we converted to pig Latin
            } else if (!isVowel(str.charAt(i))) {
                // Vowel is not the character found so append the character to pigLatinString.
                pigLatinString[i] = str.charAt(i);
                count++; // Increase count to find how many characters before vowel.
            } else {
                String output = str.substring(count,str.length());
                String latinString = new String(pigLatinString);
                System.out.println("Pig Latin format for string "+ str + " is " + output + latinString + forConsanant);
                finalString = output + latinString + forConsanant; // Since we converted to pig Latin
            }
        }
        return finalString;
    }

    // Check if character is vowel
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }

    // Method to check if palindrome
    public boolean checkStringPalindrome() {
        String reversedString = reverseString();
        boolean bool;
        // " == " comparison is for objects. For strings use .equals()
        if (reversedString.equalsIgnoreCase(str)) {
            System.out.println("The input text "+ str + " is a palindrome.");
            bool = true;
        } else {
            System.out.println("The input text "+ str + " is NOT a palindrome.");
            bool = true;
        }
        return bool;
    }

    // Method to count words in a string
    public int countWordsInString() {
        int wordCount = 0;
        System.out.println("Finding if spaces are present in the input - " + str);
        System.out.println("If found, it will be counted as words.");
        if (str != null) {
            // Just one word even if it's a character or symbol
            wordCount = 1;
        }
        for (int i = 0 ; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }
        return wordCount;
    }

    // Method to print zodiac Sign
    public void printZodiacSign() {
        if (isZodiacSign()) {
            System.out.println("Wow! You're " + str);
        }
    }

    // Method to find if input is a proper zodiac sign
    public boolean isZodiacSign() {
        String [] signs = {"aries", "taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius","capricorn", "aquarius","pisces"};
        for (int i = 0; i < signs.length ; i++ ) {
            if (str.equalsIgnoreCase(signs[i])) {
                return true;
            }
        }
        return false;
    }

    // Print fortune for zodia sign
    public void printFortuneForZodiac() throws Exception {
        if (isZodiacSign()) {
            int counter = 0;
            String urlString = "http://my.horoscope.com/astrology/free-daily-horoscope-"+str+".html";
            URL fortune = new URL(urlString);
            BufferedReader in = new BufferedReader(new InputStreamReader(fortune.openStream()));
            String InputLine;
            String patternString = "Today " + str + " Horoscopes";
            Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
            while ((InputLine = in.readLine()) != null) {
                Matcher match = pattern.matcher(InputLine);
                if (match.find()) {
                    // If found we want the next line
                    counter = 1;
                }
                if (counter > 0) {
                    // Get the next line and parse it
                    String nextLine = in.readLine();
                    nextLine = parseHTMLContent(nextLine);
                    System.out.println(nextLine);
                    counter--;
                }
            }
            in.close();
        } else {
            System.out.println(str + " is not a valid zodiac sign");
        }
    }

    // Method to parse HTML Content
    public String parseHTMLContent (String content) {
        // Remove the HTML Tags
        String pattern = "<meta property=\"og:description\" content=\"";
        String parsedContent = null;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        if(m.find()) {
            parsedContent = m.replaceFirst(" ");
        }
        // Now return only a short description till first fullstop "."
        char [] reducedContent = new char[parsedContent.length()];
        for (int i = 0; i < parsedContent.length(); i++ ) {
            if (parsedContent.charAt(i) != '.') {
                reducedContent[i] = parsedContent.charAt(i);
            } else {
                break;
            }
        }
        String outputContent = String.valueOf(reducedContent);
        return outputContent;
    }

    // Parse regional news and send an email
    public void printRegionalNewsFromNDTV () throws Exception {
        String finalContent;
        Pattern patt = Pattern.compile(" ");
        Matcher mat = patt.matcher(str);
        if (mat.find()) {
            str = mat.replaceAll("-");
        }
        String newsURL = "http://www.ndtv.com/topic/" + str;
        URLConnection news = new URL(newsURL).openConnection();
        news.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        news.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(news.getInputStream(),Charset.forName("UTF-8")));
        String InputLine;
        int lineCounter = 0;

        String pattern = "<strong>(.*)</strong>";
        String parsedContent = null;
        patt = Pattern.compile(pattern);

        while ((InputLine = in.readLine()) != null) {
            mat = patt.matcher(InputLine);
            // Parse the content
            if(mat.find()) {
                lineCounter++;
                parsedContent = mat.group();
                finalContent = removeParsers(parsedContent);
                System.out.println(lineCounter + " " + finalContent);
            }
        }
        if (parsedContent == null ) {
            System.out.println("No news results found for search term - " + str);
        }
    }

    public String removeParsers (String input) {
        Pattern patt = Pattern.compile("<strong>");
        Matcher match = patt.matcher(input);
        if (match.find()) {
            input = match.replaceAll(" ");
        }
        patt = Pattern.compile("</strong>");
        match = patt.matcher(input);
        if (match.find()) {
            input = match.replaceAll(" ");
        }
        return input;
    }
}