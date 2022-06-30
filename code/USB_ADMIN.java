import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//Admin Class: Functions as the class that will be updated and edited with the clients information. Specific admin functionality is acessed with a base password.
public class USB_ADMIN extends JFrame implements USB_FRAME, ActionListener
{
    int H_PARAM = 750;
    int W_PARAM = 500;

    // BuildFrame Variables: Used in the main class for our password area.
    JFrame adminFrame = new JFrame("Admin Control Editor");
    JPanel adminPan = new JPanel();
    GridLayout adminGrid = new GridLayout(3,1);

    JLabel adminHeader = new JLabel("Admin Controls");
    JLabel adminDescr = new JLabel("Admin Text");
    JButton adminSave = new JButton("Save Data");
    JButton adminExit = new JButton("Exit Application");


    public USB_ADMIN()
    {
        buildFrame();
    }

    @Override
    public void buildFrame()
    {

        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(W_PARAM, H_PARAM);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.add(adminPan);
        
        adminPan.setLayout(adminGrid);
        adminPan.add(adminHeader);
        adminPan.add(adminDescr);
        adminPan.add(adminSave);
        adminPan.add(adminExit);

        adminSave.addActionListener(this);
        adminExit.addActionListener(this);

        adminFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        if(event.getSource() == adminExit)
        {
            adminFrame.setVisible(false);
            adminFrame.dispose();
            System.exit(0);
        }
        else if(event.getSource() == adminSave)
        {
            
        }
        
    }

}
