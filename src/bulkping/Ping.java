package bulkping;

import java.io.*; 
import java.net.*; 
import java.util.ArrayList;
  
class Ping 
{ 
  private Boolean sendPingRequest(String ipAddress)
  {
    try{
      InetAddress connection = InetAddress.getByName(ipAddress); 
      System.out.println("Sending Ping Request to " + ipAddress); 
      if (connection.isReachable(1500)) 
      {
        System.out.println("Host is reachable"); 
        return true;
      }
      else
      {
        System.out.println("Host is unavailable"); 
        return false;
      }
    }catch(UnknownHostException e){
      return false;
    }
    catch(IOException e){
      return false;
    }
  }

  public ArrayList<Boolean> sendPingRequests(ArrayList<String> ipAddresses){
    ArrayList<Boolean> pingStatuses = new ArrayList<Boolean>();
    for (String ipAddress : ipAddresses) {
      pingStatuses.add(this.sendPingRequest(ipAddress));
    }
    return pingStatuses;
  } 
}
