package bulkping;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class BulkPing {

    static JFrame bulkPingFrame; 

    public static void openFrame() {
        bulkPingFrame.setVisible(true);
    }

    public static void setupFrame() {
        bulkPingFrame = new JFrame("BulkPing");

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

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

        bulkPingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bulkPingFrame.setSize(960,540);
    }

    public static void main(String[] args) throws Exception {
        setupFrame();
        openFrame();
    }
}
