// Imported Packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

// User Class: Functions as a child to the main class and will be used to format a users experience with the software. 
public class USB_USER extends JFrame implements USB_FRAME, ActionListener
{
    final int H_PARAM = 275;
    final int W_PARAM = 600;
    final int POP_LIMIT = 5;

    Boolean systemCheck = false;

    Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\jlzav\\Documents\\MSU_Internship\\Repo\\MSU_USB_STOR\\TrialWear_Development\\TrialWear_Logo.png");

    // BuildFrame Variables: Used in the main class for our password area
    JPanel headerP = new JPanel();
    JPanel textP = new JPanel();
    JPanel buttonP = new JPanel();
    JPanel formatP = new JPanel();

    JLabel userHeader = new JLabel("YOUR PATIENT IS A CLINICAL", SwingConstants.CENTER);
    JLabel userHeader2 = new JLabel("TRIAL PARTICIPANT", SwingConstants.CENTER);
    JLabel userTextA = new JLabel("THEY HAVE RECEIVED DRUGS THAT MAY INTERACT WITH STANDARD", SwingConstants.CENTER);
    JLabel userTextA2 = new JLabel("", SwingConstants.CENTER);
    JLabel userTextB = new JLabel("SAFETY-RELATED INFORMATION.", SwingConstants.CENTER);
    JLabel fluffText[] = new JLabel[POP_LIMIT];

    JButton userInCare = new JButton("In-Care");
    JButton userExit = new JButton("Exit");

    // Customization
    Font titleFont = new Font("Times New Roman", Font.BOLD, 22);
    Font descrFont = new Font("Times New Roman", Font.PLAIN, 15);
    Font buttonFont = new Font("Times New Roman", Font.BOLD, 15);

    Color backColor = new Color(0, 89, 0);
    Color frontColor = new Color(0, 25, 51);
    Color textColor = new Color(255, 255, 255);

    // Constructor
    public USB_USER() {}

    @Override
    public void buildFrame()
    {

        // Customization to the JFrame settup
        setTitle("Client Information Area");
        setIconImage(img);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(W_PARAM, H_PARAM);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 0, 25));

        // Core Container Settup
        Container userCont = this.getContentPane();
        userCont.setLayout(new BorderLayout(10, 10));

        // Panel and Container Settup
        userCont.add(headerP, BorderLayout.NORTH);
        userCont.add(formatP, BorderLayout.CENTER);
        userCont.add(buttonP, BorderLayout.SOUTH);

        /* --------------------------------------------------------------------- */



        // Populator - Settup for empty labels in formatting

        for(int i = 0; i < POP_LIMIT; ++i)
        {
            fluffText[i] = new JLabel("");
        }

        userTextA2.setText("<html>THERAPIES.  PLEASE CLICK THE <B>‘IN-CARE’</B> BUTTON TO ACCESS</html>");

        /* --------------------------------------------------------------------- */

        // Header Components
        headerP.setLayout(new GridLayout(4, 1));
        userHeader.setFont(titleFont);
        userHeader2.setFont(titleFont);

        headerP.setBackground(backColor);
        userHeader.setForeground(textColor);
        userHeader2.setForeground(textColor);

        headerP.add(fluffText[0]);
        headerP.add(userHeader);
        headerP.add(userHeader2);
        headerP.add(fluffText[1]);

        /* --------------------------------------------------------------------- */

        // Text Components
        formatP.setLayout(new BorderLayout(1, 1));
        formatP.add(textP, BorderLayout.CENTER);

        textP.setLayout(new GridLayout(5, 1, 1, 5));
        userTextA.setFont(descrFont);
        userTextA2.setFont(descrFont);
        userTextB.setFont(descrFont);

        textP.add(fluffText[2]);
        textP.add(userTextA);
        textP.add(userTextA2);
        textP.add(userTextB);
        textP.add(fluffText[3]);

        // Button Components
        buttonP.setLayout(new FlowLayout());
        userInCare.setFont(buttonFont);
        userExit.setFont(buttonFont);

        userInCare.setForeground(textColor);
        userExit.setForeground(textColor);
        userInCare.setBackground(backColor);
        userExit.setBackground(backColor);

        buttonP.add(userInCare);
        buttonP.add(userExit);

        //Button Listeners
        userInCare.addActionListener(this);
        userExit.addActionListener(this);

        setVisible(true);
        setResizable(false);
    }

    public void runWebsite(Boolean checkVari)
    {

        if(checkVari == true)
        {
            try
            { 
                //Launches website twice when executed, due to multiple listeners with the object ****
                Desktop.getDesktop().browse(new URI("https://trialwearsafety.com/"));
                System.exit(0);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }   
    }

    public Boolean getBoolean()
    {
        return systemCheck;
    }

    @Override
    public void actionPerformed(ActionEvent eve) 
    {
        if(eve.getSource() == userExit)
        {
            this.setVisible(false);
            this.dispose();
            System.exit(0);
        }

        if(eve.getSource() == userInCare)
        {
            systemCheck = true;
        }
        
    }

}