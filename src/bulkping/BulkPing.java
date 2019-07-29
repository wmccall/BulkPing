package bulkping;

import java.io.*;
import java.util.ArrayList;
import java.awt.Color;

public class BulkPing {

    static BulkPingGUI bulkPingGUI;
    static ArrayList<String> ipAddresses;
    static ArrayList<Boolean> pingStatuses;

    public static void main(String[] args) throws Exception {
        Ping ping = new Ping();
        ArrayList<String> lastIPAddresses = new ArrayList<String>();

        updateIPAddressesFromFile("../config/IPAddresses.txt");
        bulkPingGUI = new BulkPingGUI(ipAddresses);
        bulkPingGUI.openFrame();
        lastIPAddresses.addAll(ipAddresses);

        while(true){
            if (!lastIPAddresses.equals(ipAddresses)){
                System.out.println("Updating IPs");
                bulkPingGUI.updateFrame(ipAddresses);
            }

            pingStatuses = ping.sendPingRequests(ipAddresses);
            int ipAddressNumber = 0;
            for (Boolean pingStatus : pingStatuses) {
                bulkPingGUI.ipButtons.get(ipAddressNumber).setBackground(new Color(pingStatus ? 0x59CD90 : 0xEE6352));
                ipAddressNumber++;  
            }
            Thread.sleep(10000);
        }
    }

    public static void updateIPAddressesFromFile(String filename){
        ipAddresses = Util.readIPAddressesFile(filename);
    }
}
