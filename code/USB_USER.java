import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

//User Class: Functions as a child to the main class and will be used to format a users experience with the software. 
public class USB_USER extends JFrame implements USB_FRAME, ActionListener
{
    final int H_PARAM = 750;
    final int W_PARAM = 500;

    // BuildFrame Variables: Used in the main class for our password area
    JPanel titleP = new JPanel();
    JPanel textP = new JPanel();
    JPanel buttonP = new JPanel();
    JPanel formatP = new JPanel();

    JLabel userHeader = new JLabel("CLINICAL TRIAL PATIENT INFORMATION");

    JLabel userTextA = new JLabel("[STAND-IN FACILITY CONTACT-PROVIDER]");
    JLabel userTextB = new JLabel("[STAND-IN FACILITY EMAIL]");
    JLabel userTextC = new JLabel("[STAND-IN FACILITY NAME]");
    JLabel userTextD = new JLabel("[STAND-IN FACILITY LOCATION]");
    JLabel userTextE = new JLabel("[STAND-IN ADDITIONAL INFORMATION]");

    JButton userInCare = new JButton("In-Care");
    JButton userExit = new JButton("Exit");

    //Customization
    Font titleFont = new Font("Times New Roman", Font.BOLD, 20);
    Font descrFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font buttonFont = new Font("Times New Roman", Font.BOLD, 15);
    Color backColor = new Color(0, 89, 0);
    Color frontColor = new Color(0, 25, 51);
    Color textColor = new Color(255, 255, 255);

    //Constructor
    public USB_USER()
    {
        super();
        buildFrame();
    }

    @Override
    public void buildFrame()
    {
        //Customization to the JFrame settup
        setTitle("Client Information Area");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(W_PARAM, H_PARAM);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 25, 25));

        //Core Container Settup
        Container userCont = this.getContentPane();
        userCont.setLayout(new BorderLayout(10, 10));

        //Panel and Container Settup
        userCont.add(titleP, BorderLayout.NORTH);
        userCont.add(formatP, BorderLayout.CENTER);
        userCont.add(buttonP, BorderLayout.SOUTH);

        //Title Components
        titleP.setLayout(new FlowLayout());
        titleP.add(userHeader);
        userHeader.setFont(titleFont);

        //Main Text Components
        formatP.setLayout(new BorderLayout(10, 10));
        formatP.add(textP, BorderLayout.CENTER);

        textP.setLayout(new GridLayout(7, 1, 10, 10));
        textP.add(userTextA);
        textP.add(userTextB);
        textP.add(userTextC);
        textP.add(userTextD);
        textP.add(userTextE);

        //Button Components
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

    public void runWebsite()
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
            runWebsite();
        }
        
    }

}