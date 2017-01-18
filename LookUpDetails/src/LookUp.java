package com.srikkanthgovindaraajan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by govinsr on 1/3/17.
 */
public class LookUp {
    private String ipAddress;
    private String zipCode;

    // Constructor for IP Address related functions
    public LookUp(String ipAddress, String zipCode) {
        this.ipAddress = ipAddress;
        this.zipCode = zipCode;
    }

    // Constructor for only ipAddress
    public LookUp(String ipAddress) {
        this.ipAddress = ipAddress;
        this.zipCode = "00000";
    }


    public String getIpAddress() {
        return ipAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    // Function to lookup country code from IP
    public void lookUpCountryFromIP() {
        String command = "whois "+ ipAddress;
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:" + command + "\n");
            String patternToBeFound = "Country:\\s+(\\S+)";
            Pattern pattern = Pattern.compile(patternToBeFound);

            String line;
            while((line = stdInput.readLine())!=null) {
                Matcher match = pattern.matcher(line);
                if(match.find()) {
                    String output = match.group();
                    output = output.replaceAll("\\s+"," ");
                    System.out.println(output);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // Function for whois lookup
    public void whoisLookUp() {
        String command = "whois " + ipAddress;
        String line = null;
        try {
            Process process = Runtime.getRuntime().exec(command);

            // Store output of command to std input
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Read output of command from input
            while((line = stdInput.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // Zip code lookup
    public void zipCodeLookUp() throws Exception {
        String line = null;
        String parsedLine = null;
        ArrayList<String> returnedOutput = new ArrayList<String>();

        try {
            String urlString = "http://www.getzips.com/cgi-bin/ziplook.exe?What=1&Zip=" + zipCode + "&Submit=Look+It+Up";
            URL zipcodeLookup = new URL(urlString);
            BufferedReader in = new BufferedReader(new InputStreamReader(zipcodeLookup.openStream()));
            while((line = in.readLine()) != null) {
                String regexPattern = "VALIGN=TOP><P>(<B>)?(\\S+(\\s)?(\\S+)?(\\s+)?(\\S+)?)</TD>";
                Pattern p = Pattern.compile(regexPattern);
                Matcher m = p.matcher(line);
                if(m.find()) {
                    parsedLine = parseHTMLtoText(line);
                    returnedOutput.add(parsedLine);
                }
            }
            System.out.println(returnedOutput.size());
            if (returnedOutput.size() != 8) {
                // A valid zip code gets 8 items in the array list
                System.out.println("Error: Invalid zip code!");
            }
            for(int i=0; i < returnedOutput.size(); i++) {
                if (i == 4) {
                    System.out.println("ZIP Code - " + returnedOutput.get(4));
                } else if(i==5) {
                    System.out.println("City and State - " + returnedOutput.get(5));
                } else if (i==6) {
                    System.out.println("County - " + returnedOutput.get(6));
                } else if(i==7) {
                    System.out.println("Telephone Code - " + returnedOutput.get(7));
                } else {
                    // Do nothing
                }
            }
        } catch ( IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // Private function to parse HTML response
    private String parseHTMLtoText(String line) {
        String parsedLine = null;

        String regexPattern = "VALIGN=TOP><P>(<B>)?(\\S+(\\s)?(\\S+)?(\\s+)?(\\S+)?)</TD>";
        Pattern p = Pattern.compile(regexPattern);
        Matcher m = p.matcher(line);
        if (m.find()) {
            String isNull = m.group(2);
            if(isNull != null) {
                parsedLine = " " + m.group(2) + "\n";
            }
        }
        return parsedLine;
    }

    // Function to run python script that performs weather lookup
    public void weatherLookUp() {
        // Need to implement using Weather API
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("\nEnter your choice:\n");
        System.out.println("1.Geolookup\n2.Almanac\n3.Astronomy" +
                "\n4.Forecast\n5.Alerts\n6.Ten Day forecast" +
                "\n7.Yesterday's weather"
        );
        int choice = inputScanner.nextInt();
        inputScanner.nextLine();

        System.out.println("Enter the state abbreviation for US / Country name: ");
        System.out.println("Example for US enter - MA, OH, CA");
        System.out.println("Example for country - India, Australia, New Zealand");
        String state = inputScanner.nextLine();

        System.out.println("Enter the city name:");
        String city = inputScanner.nextLine();

        state = state.replaceAll(" ","%20");
        city = city.replaceAll(" ","%20");

        String base_command = "python /Users/govinsr/Documents/EclipseWorkspace/weatherlookup/weatherlookup.py ";
        String command = null;
        switch(choice) {
            case 1:
                command = base_command + "geolookup " + state + " " + city;
                exec_python_script(command);
                break;
            case 2:
                command = base_command + "almanac " + state + " " + city;
                exec_python_script(command);
                break;
            case 3:
                command = base_command + "astronomy " + state + " " + city;
                exec_python_script(command);
                break;
            case 4:
                command = base_command + "forecast " + state + " " + city;
                exec_python_script(command);
                break;
            case 5:
                command = base_command + "alerts " + state + " " + city;
                exec_python_script(command);
                break;
            case 6:
                command = base_command + "10day " + state + " " + city;
                exec_python_script(command);
                break;
            case 7:
                command = base_command + "yesterday " + state + " " + city;
                exec_python_script(command);
                break;
            default:
                break;
        }
    }

    private void exec_python_script(String command) {
        Process exec_process = null;
        String s = null;
        try {
            exec_process = Runtime.getRuntime().exec(command);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(exec_process.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(exec_process.getErrorStream()));

        // read the output from the command
        try {
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println("END of output. Python script ended\n");

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            if(stdError.readLine() == null) {
                System.out.println("No errors found!");
            }
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
