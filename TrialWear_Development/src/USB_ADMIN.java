// Imported Packages
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.*;

// Admin Class: Exists to set the initial password, and is accessed through the initial patient portal and password access.
public class USB_ADMIN extends JFrame implements USB_FRAME, ActionListener
{

    // Variables: Main class variables used for parameters and declarations.
    final int H_PARAM = 275;
    final int W_PARAM = 600;
    final int POP_LIMIT = 5;

    Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\jlzav\\Documents\\MSU_Internship\\Repo\\MSU_USB_STOR\\TrialWear_Development\\TrialWear_Logo.png");

    JPanel headerP = new JPanel();
    JPanel descrP = new JPanel();
    JPanel sysP = new JPanel();
    JPanel buttonP = new JPanel();

    JLabel headerText = new JLabel("Admin Update Area", SwingConstants.CENTER);
    JLabel descrText = new JLabel("This area is for updating the Patient's Information and Identifier", SwingConstants.CENTER);
    JLabel upDescrText = new JLabel("TEMP", SwingConstants.CENTER);

    JTextField upUserIdentifier = new JTextField("", 20);
    JButton exitButton = new JButton("Exit");
    JButton submitButton = new JButton("Submit");

    JLabel fluffText[] = new JLabel[POP_LIMIT];
    
    Path passwordFile = Path.of("C:\\Users\\jlzav\\Documents\\MSU_Internship\\Repo\\MSU_USB_STOR\\TrialWear_Development\\.vscode\\config_settings.txt");


    // Constructor
    public USB_ADMIN() {}

    // buildFrame Method: 
    @Override
    public void buildFrame()
    {
        setTitle("Admin Cofiguration Area");
        setIconImage(img);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(W_PARAM, H_PARAM);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        //
        add(headerP);
        add(descrP);
        add(sysP);
        add(buttonP);

        //
        headerP.add(headerText);
        headerP.setLayout(new FlowLayout());

        //
        descrP.add(descrText);
        descrP.setLayout(new FlowLayout());

        //
        sysP.add(upDescrText);
        sysP.add(upUserIdentifier);
        sysP.setLayout(new FlowLayout());

        //
        buttonP.add(submitButton);
        buttonP.add(exitButton);
        buttonP.setLayout(new FlowLayout());

        //
        exitButton.addActionListener(this);
        submitButton.addActionListener(this);

        setVisible(true);
        setResizable(false);
    }

    public String getFileA(String configStrings)
    {
        return configStrings;
    }

    public String getFileB(String configStrings)
    {
        return configStrings;
    }

    public String getFileC(String configStrings)
    {
        return configStrings;
    }

    // actionPerformed Method:
    @Override
    public void actionPerformed(ActionEvent eve) 
    {
        if(eve.getSource() == exitButton)
        {
            this.setVisible(false);
            this.dispose();
        }

        if(eve.getSource() == submitButton)
        {
            String newPass = upUserIdentifier.getText();
            upUserIdentifier.setText("");
            
            try 
            {
                Files.write(passwordFile, ("Patient Password:\n{" + newPass + "}\n\nSoftware Version:\n4.5").getBytes());
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

}
 