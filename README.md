# BulkPing

Mass Pinging GUI Utility

## Getting Started

1. Download the latest Release jar
2. Place it into the folder of your choice
3. Create a `IPAddresses.txt` file in the same directory as the release jar file
3.1 An example of one can be found [here](https://github.com/wmccall/BulkPing/blob/master/config/IPAddresses.txt)
4. Run the program by executing `java -jar BulkPing.jar`
4.1 Alternatively create a `run.batch` or `run.sh` file containing the command to simplify the process

## Usage

* The program will immediately start to ping the addresses in a rolling manner from the `IPAddresses.txt` file
   * To change which file it is reading the IPs to ping, select File -> Open Config from the menu bar, and then select the file to use
   * When the config changes, it will take a pinging cycle to update on the screen, so hold tight.
   * Alternatively - permanently change what IPs it will ping by updating the `IPAddresses.txt` file with the preferred IP addresses
* If the program was launched from the command line, there is a readout of the IPs when they were pinged and if they were available
* If an IP is not yet pinged it will be a default white color
* If an IP is unreachable, it will be a red-orange color
* If an IP is reachable, it will be a green color
