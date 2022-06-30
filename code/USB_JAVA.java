import javax.swing.*;


/*
* Student-Mentor Research Project
* Program Dev: Jace L. Zavarelli
* Mentor Lead: Dr. Elizabeth Johnson
*/

//Main Class: Used for executing the USB application
public class USB_JAVA extends JOptionPane
{
    // Main Variables: Used for deciding the main parameters of our method.
    final static String ADMIN_COND = "admin";
    final static String USER_COND = "user";


    public static void main(String[] args) 
    {
        Boolean boolAdmin = false;
        Boolean boolUser = false;

        String userPass = "null";

        UIManager.put("OptionPane.cancelButtonText", "Exit");
        UIManager.put("OptionPane.okButtonText", "Submit");

        userPass = JOptionPane.showInputDialog(null, "Enter the pathients date of birth.", "Submit Patient Password", QUESTION_MESSAGE);

        //Boolean Setter for Frame Selection
        if(userPass.equals(ADMIN_COND))
        {
            boolAdmin = true;
        }
        else if(userPass.equals(USER_COND))
        {
            boolUser = true;
        }

        //Buildframe Selector*9
        if(boolAdmin)
        {

            USB_ADMIN adminSys = new USB_ADMIN();
            adminSys.buildFrame();
            boolAdmin = false;

        }
        else if(boolUser)
        {

            USB_USER userSys = new USB_USER();
            userSys.buildFrame();
            boolUser = false;

        }

    }

}