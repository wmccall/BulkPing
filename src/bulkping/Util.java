package bulkping;

import java.util.ArrayList;
import java.io.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Util {
  private static SimpleDateFormat logDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";


  public static ArrayList<String> readIPAddressesFile(String fileName) {
    // Modified from here: https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
    ArrayList<String> readIPAddresses = new ArrayList<String>();

    String line = null;
    FileReader fileReader;
    BufferedReader bufferedReader;

    try {
        fileReader = new FileReader(fileName);

        bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            Util.logWithTime("Read IP: " + line, "n");
            readIPAddresses.add(line);
        }           
    }
    catch(FileNotFoundException ex) {
        Util.logWithTime(
            "Unable to open file '" + 
            fileName + "'", "warn");
        return new ArrayList<String>();              
    }
    catch(IOException ex) {
        Util.logWithTime(
            "Error reading file '" 
            + fileName + "'", "warn");
        return new ArrayList<String>();
    }
    try{
        bufferedReader.close(); 
    }
    catch(IOException ex) {
        Util.logWithTime(
            "Error closing reader", "warn");
        System.exit(1);
    }

    return readIPAddresses;
  }

  public static void logWithTime(String message, String status){
    String color;
    switch (status) {
      case "gp":
        color = ANSI_GREEN;
        break;
      case "bp":
        color = ANSI_RED;
        break;
        case "warn":
        color = ANSI_YELLOW;
        break;
      default: 
        color = ANSI_RESET;
        break;
    }
    Date date = new Date();   
    System.out.print("[" + logDateFormat.format(date) + "]: ");
    System.out.println(color + message + ANSI_RESET); 
  }
}
