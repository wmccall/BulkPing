package bulkping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class BulkPingGUI{
  
    JFrame bulkPingFrame;
    ArrayList<JButton> ipButtons;

    public void openFrame() {
        this.bulkPingFrame.setVisible(true);
    }

    public void setupFrame(ArrayList<String> ipAddresses) {
        this.bulkPingFrame = new JFrame("BulkPing");

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        JPanel panel;


        menuBar = new JMenuBar();

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        menuItem = new JMenuItem("Open Config", KeyEvent.VK_O);

        menu.add(menuItem);

        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(menu);

        menuItem = new JMenuItem("Information", KeyEvent.VK_I);
        menu.add(menuItem);

        bulkPingFrame.setJMenuBar(menuBar);

        panel = new JPanel();

        for (String ipAddress : ipAddresses) {
            ipButtons.add(new JButton(ipAddress));
            panel.add(ipButtons.get(ipButtons.size()-1));
        }
        bulkPingFrame.setContentPane(panel);

        bulkPingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bulkPingFrame.setSize(960,540);
    }

    BulkPingGUI (ArrayList<String> ipAddresses) {
        ipButtons = new ArrayList<JButton>();
        this.setupFrame(ipAddresses);
    }

}
