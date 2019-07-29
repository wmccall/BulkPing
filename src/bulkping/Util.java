package bulkping;

import java.util.ArrayList;
import java.io.*;

public class Util {
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
            System.out.println(line);
            readIPAddresses.add(line);
        }           
    }
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            fileName + "'");
        return null;              
    }
    catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + fileName + "'");
        return null;
    }
    try{
        bufferedReader.close(); 
    }
    catch(IOException ex) {
        System.out.println(
            "Error closing reader");
        System.exit(1);
    }

    return readIPAddresses;
  }
}
