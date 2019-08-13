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
      Util.logWithTime("Sending Ping Request to " + ipAddress, "n"); 
      if (connection.isReachable(1500)) 
      {
        Util.logWithTime(ipAddress + " is reachable", "gp"); 
        return true;
      }
      else
      {
        Util.logWithTime(ipAddress + " is unreachable", "bp"); 
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
    ArrayList<String> localIPAddresses = new ArrayList<String>();
    localIPAddresses.addAll(ipAddresses);
    ArrayList<Boolean> pingStatuses = new ArrayList<Boolean>();
    for (String ipAddress : ipAddresses) {
      pingStatuses.add(this.sendPingRequest(ipAddress));
    }
    return pingStatuses;
  } 
}
