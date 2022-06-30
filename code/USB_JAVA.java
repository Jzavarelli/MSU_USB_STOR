
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*
* Student-Mentor Research Project
* Program Dev: Jace L. Zavarelli
* Mentor Lead: Dr. Elizabeth Johnson
* 
*
*/

//Main Class: Used for executing the USB application and GUI.
public class USB_JAVA implements ActionListener
{
    // Main Variables: Used for deciding the main parameters of our method.
    final static int H_PARAM = 200;
    final static int W_PARAM = 500;

    final String ADMIN_COND = "admin";
    final String USER_COND = "user";

    String password = "null";
    Font titleFont = new Font("Times New Roman", Font.BOLD, 20);
    Font descrFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font buttonFont = new Font("Times New Roman", Font.BOLD, 15);
    Color backColor = new Color(0, 89, 0);
    Color frontColor = new Color(0, 25, 51);
    Color textColor = new Color(255, 255, 255);

    // initPassFrame Variables: Used in the main class for our password area.
    JFrame passFrame = new JFrame("Enter Identification Password");
    JPanel mainPassPanel = new JPanel();
    JPanel entryPanel = new JPanel();   
    JPanel buttonPanel = new JPanel();

    JLabel descrPass = new JLabel("Enter the patients date of birth.");
    JTextField areaPass = new JTextField();
    JButton submitPass = new JButton("Submit");


    public void initPassFrame()
    {

        //Pass Frame Parameters: Used to define the parameters and appearance of the 
        //following frame. The frame holds the two main used panels.
        passFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        passFrame.setLocationRelativeTo(null);
        passFrame.setSize(W_PARAM, H_PARAM);

        passFrame.add(mainPassPanel);
        mainPassPanel.setBackground(Color.YELLOW);
        mainPassPanel.setLayout(new GridLayout(2, 1, 0, 15));

        mainPassPanel.add(entryPanel, BorderLayout.NORTH);
        entryPanel.setLayout(new FlowLayout());
        entryPanel.setBackground(Color.CYAN);
        entryPanel.add(descrPass);
        entryPanel.add(areaPass);
        
        mainPassPanel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBackground(Color.MAGENTA);
        buttonPanel.add(submitPass);

        descrPass.setBackground(Color.RED);
        areaPass.setBackground(Color.RED);
        submitPass.setBackground(Color.RED);

        descrPass.setFont(titleFont);
        submitPass.setFont(buttonFont);
        areaPass.setFont(descrFont);

        submitPass.setMargin(new Insets(5, 15, 5, 15));
        submitPass.setAlignmentX(Component.BOTTOM_ALIGNMENT);
        areaPass.setPreferredSize(new Dimension(100, 50));
        


        //Activation of interactable objects, which allows them to be used.
        areaPass.addActionListener(this);
        submitPass.addActionListener(this);

        //Activation of the passFrame.
        passFrame.setVisible(true);
        passFrame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        if(submitPass.equals(event.getSource()))
        {
            String tempPass = areaPass.getText();
            setPass(tempPass);
        }
    }

    public void setPass(String inputPass)
    {
        password = inputPass;
    }

    public String getPass()
    {
        return password;
    }

    //Intilizing System: Used in activating the password GUI when the program is executed.
    public static void main(String[] args) 
    {
        USB_JAVA runner = new USB_JAVA();

        int looper = 1;
        String inputPass = "null";

        runner.initPassFrame();
        

        while(looper != 5)
        {

            inputPass = runner.getPass();
            Boolean boolAdmin = inputPass.equals("admin");
            Boolean boolUser = inputPass.equals("user");
            System.out.println("");
            
            if(boolAdmin)
            {
                looper = 5;
                runner.passFrame.setVisible(false);
                runner.passFrame.dispose();

                //USB_ADMIN adminSys = new USB_ADMIN();
                //adminSys.buildFrame();

            }
            else if(boolUser)
            {
                looper = 5;
                runner.passFrame.setVisible(false);
                runner.passFrame.dispose();

                USB_USER userSys = new USB_USER();
                userSys.buildFrame();
            }
            else
            {
                
            }

        }

    }

}