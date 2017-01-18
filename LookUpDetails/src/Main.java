package com.srikkanthgovindaraajan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        boolean quit = false;
        Scanner inputScanner = new Scanner(System.in);

        String ipAddress = null;
        LookUp countryDetails = null;
        printMenu();
        while(!quit) {

            System.out.println("Enter your choice:\n (Press 0 for options)");
            int choice = inputScanner.nextInt();
            inputScanner.nextLine();
            switch(choice) {
                case 0:
                    // Print options menu
                    printMenu();
                    break;
                case 1:
                    // Country lookup from IP address
                    System.out.println("*****************************************");
                    System.out.println("Country lookup from IP Address");
                    System.out.println("*****************************************");
                    System.out.println("Enter the IP address: ");
                    ipAddress = inputScanner.nextLine();
                    countryDetails = new LookUp(ipAddress);
                    countryDetails.lookUpCountryFromIP();
                    break;
                case 2:
                    // whois lookup for IP address
                    System.out.println("**********************************************");
                    System.out.println("WHOIS lookup for IP Address ");
                    System.out.println("**********************************************");
                    System.out.println("Enter the IP address: ");
                    ipAddress = inputScanner.nextLine();
                    countryDetails = new LookUp(ipAddress);
                    countryDetails.whoisLookUp();
                    break;
                case 3:
                    // ZIP code lookup
                    String zipcode = null;
                    System.out.println("**********************************************");
                    System.out.println("ZIP Code lookup");
                    System.out.println("**********************************************");
                    System.out.println("Enter the 5-digit zipcode");
                    zipcode = inputScanner.nextLine();
                    if(validateZipCode(zipcode)) {
                        LookUp zipcodeDetails = new LookUp("0000", zipcode);
                        zipcodeDetails.zipCodeLookUp();
                    }
                    break;
                case 4:
                    // Weather conditions lookup
                    System.out.println("**********************************************");
                    System.out.println("Weather lookup");
                    System.out.println("**********************************************");
                    // Dummy constructor
                    LookUp weatherDetails = new LookUp("0000","0000");
                    weatherDetails.weatherLookUp();
                    break;
                case 5:
                    System.out.println("Thanks for using the application.");
                    quit = true;
                    break;
                default:
                    System.out.println("Enter options between 0-5");
                    break;
            }
        }
    }

    private static void printMenu() {
        String menuString = "Press:" +
                "\n0 - to display options. " +
                "\n1 - Country lookup with IP address" +
                "\n2 - WHOIS lookup with IP address" +
                "\n3 - ZIP Code lookup" +
                "\n4 - Weather lookup " +
                "\n5 - Exit the application";
        System.out.println(menuString);
    }

    private static boolean validateZipCode(String zipcode) {
        // Function to validate zipcode
        String regexPattern = "\\d{5}";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(zipcode);
        if(matcher.matches()) {
           return true;
        } else {
            System.out.println("Invalid zip code, please try again");
            return false;
        }
    }
}
