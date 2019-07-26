package bulkping;

import java.io.*;
import java.util.ArrayList;
import java.awt.Color;

public class BulkPing {

    static BulkPingGUI bulkPingGUI;
    static ArrayList<String> ipAddresses;
    static ArrayList<Boolean> pingStatuses;

    public static void main(String[] args) throws Exception {
        updateIPAddressesFromFile("../config/IPAddresses.txt");
        bulkPingGUI = new BulkPingGUI(ipAddresses);
        bulkPingGUI.openFrame();

        Ping ping = new Ping();
        while (true){
            pingStatuses = ping.sendPingRequests(ipAddresses);
            int ipAddressNumber = 0;
            for (Boolean pingStatus : pingStatuses) {
                if(pingStatus){
                    bulkPingGUI.ipButtons.get(ipAddressNumber).setBackground(new Color(0x59CD90));
                }
                else{
                    bulkPingGUI.ipButtons.get(ipAddressNumber).setBackground(new Color(0xEE6352));
                }
                ipAddressNumber++;  
            }
            Thread.sleep(10000);
        }
    }

    public static void updateIPAddressesFromFile(String filename){
        ipAddresses = readIPAddressesFile(filename);
    }

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
