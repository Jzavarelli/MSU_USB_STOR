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
    final int H_PARAM = 300;
    final int W_PARAM = 600;
    final int POP_LIMIT = 5;

    Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\jlzav\\Documents\\MSU_Internship\\Repo\\MSU_USB_STOR\\TrialWear_Development\\TrialWear_Logo.png");

    JPanel headerP = new JPanel();
    JPanel sysP = new JPanel();
    JPanel buttonP = new JPanel();

    JLabel headerText = new JLabel("ADMINISTRATION UPDATE AREA", SwingConstants.CENTER);
    JLabel descrText = new JLabel("THIS AREA IS FOR UPDATING THE PATIENT IDENTIFIER.", SwingConstants.CENTER);
    JLabel upDescrText = new JLabel("PLEASE, ENTER THE NEW PATIENT IDENTIFIER:", SwingConstants.CENTER);

    JTextField upUserIdentifier = new JTextField("", 10);
    JButton exitButton = new JButton("Exit");
    JButton submitButton = new JButton("Submit");

    JLabel fluffText[] = new JLabel[POP_LIMIT];

    // Customization
    Font titleFont = new Font("Times New Roman", Font.BOLD, 22);
    Font descrFont = new Font("Times New Roman", Font.PLAIN, 15);
    Font buttonFont = new Font("Times New Roman", Font.BOLD, 15);

    Color backColor = new Color(0, 89, 0);
    Color frontColor = new Color(0, 25, 51);
    Color textColor = new Color(255, 255, 255);
    
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
        setLayout(new GridLayout(3, 1, 0, 0));

        Container userCont = this.getContentPane();
        userCont.setLayout(new BorderLayout(10, 10));

        // Panel Builder
        userCont.add(headerP, BorderLayout.NORTH);
        userCont.add(sysP, BorderLayout.CENTER);
        userCont.add(buttonP, BorderLayout.SOUTH);

        // Populator

        for(int i = 0; i < POP_LIMIT; ++i)
        {
            fluffText[i] = new JLabel("");
        }

        // Administration Header
        headerP.add(headerText);
        headerP.setLayout(new GridLayout(1, 1, 0, 10));
        headerText.setFont(titleFont);
        
        headerText.setForeground(textColor);
        headerP.setBackground(backColor);
        
        // Password Retrieval Components
        sysP.add(fluffText[0]);
        sysP.add(descrText);
        sysP.add(upDescrText);
        sysP.add(upUserIdentifier);
        sysP.setLayout(new GridLayout(4, 1, 5, 5));
        descrText.setFont(descrFont);
        upDescrText.setFont(descrFont);
        upUserIdentifier.setFont(descrFont);

        upUserIdentifier.setHorizontalAlignment(JTextField.CENTER);

        // Button Component
        buttonP.add(submitButton);
        buttonP.add(exitButton);
        buttonP.setLayout(new FlowLayout());
        submitButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        submitButton.setForeground(textColor);
        exitButton.setForeground(textColor);
        submitButton.setBackground(backColor);
        exitButton.setBackground(backColor);

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
 