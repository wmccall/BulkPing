package bulkping;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.*;

public class BulkPingGUI implements ActionListener{
  
    JFrame bulkPingFrame;
    ArrayList<JButton> ipButtons;
    JMenuItem openFile;
    JMenuItem openInformation;
    JPanel panel;
    JFileChooser chooser;

    public void openFrame() {
        this.bulkPingFrame.setVisible(true);
    }

    private void setupFrame(ArrayList<String> ipAddresses) {
        this.bulkPingFrame = new JFrame("BulkPing");

        JMenuBar menuBar;
        JMenu menu;

        menuBar = new JMenuBar();

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        openFile = new JMenuItem("Open Config", KeyEvent.VK_O);
        openFile.addActionListener(this);
        menu.add(openFile);

        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(menu);

        openInformation = new JMenuItem("Information", KeyEvent.VK_I);
        openInformation.addActionListener(this);
        menu.add(openInformation);

        bulkPingFrame.setJMenuBar(menuBar);

        this.panel = new JPanel();

        for (String ipAddress : ipAddresses) {
            ipButtons.add(new JButton(ipAddress));
            panel.add(ipButtons.get(ipButtons.size()-1));
        }
        bulkPingFrame.setContentPane(panel);

        bulkPingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bulkPingFrame.setSize(960,540);
    }

    public void updateFrame(ArrayList<String> ipAddresses) {
        JPanel localPanel = new JPanel();

        ipButtons = new ArrayList<JButton>();

        for (String ipAddress : ipAddresses) {
            ipButtons.add(new JButton(ipAddress));
            localPanel.add(ipButtons.get(ipButtons.size()-1));
        }
        bulkPingFrame.remove(this.panel);
        this.panel = localPanel;
        bulkPingFrame.setContentPane(panel);
        bulkPingFrame.revalidate();
    }

    public void actionPerformed(ActionEvent ae) {
        String choice = ae.getActionCommand();
        if (choice.equals("Open Config")) {
            int returnVal = chooser.showOpenDialog(bulkPingFrame);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                Util.logWithTime("Using Config: " + filename, "n");
                BulkPing.ipAddresses = Util.readIPAddressesFile(filename);
            }
        }else if(choice.equals("Information")){
            openInformationScreen();
        }
    }

    private void openInformationScreen() {
        JFrame infoScreen = new JFrame("Information");
        infoScreen.setLayout(new FlowLayout());
        JLabel informationLabel = new JLabel("BulkPing Pinging Utility");
        JLabel copyrightLabel = new JLabel("© 2019 William McCall");
        infoScreen.add(informationLabel);
        infoScreen.add(copyrightLabel);
        infoScreen.setSize(200,100);
        infoScreen.setVisible(true);
    }

    BulkPingGUI (ArrayList<String> ipAddresses) {
        ipButtons = new ArrayList<JButton>();
        chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Text Files", "txt");
        chooser.setFileFilter(filter);
        this.setupFrame(ipAddresses);
        
    }

}
