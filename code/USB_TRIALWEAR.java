// Imported Packages
import javax.swing.*;

/*
* Student-Mentor Research Project
* Montana State University Research
* Program Dev: Jace L. Zavarelli
* Mentor Lead: Dr. Elizabeth Johnson
*/

// Main Class: Used for executing the USB application
public class USB_TRIALWEAR extends JOptionPane
{
    // Main Variables: Used for deciding the main parameters of our method.
    final static String ADMIN_COND = "admin";

    // Main Method
    public static void main(String[] args) 
    {
        USB_USER userSys = new USB_USER();
        USB_ADMIN adminSys = new USB_ADMIN();

        Boolean systemCheck;
        String userPass;
        int looper = 0;

        userSys.buildFrame();

        // System Loop - Used in Main Method to continually run with Error, until the system exit.
        while(looper < 1)
        {
            systemCheck = userSys.getBoolean();
            System.out.println("");
            //Initalizing Print Statement - TEMP

            // Try Statement - Used in correcting broad errors.
            try
            {
                if(systemCheck == true)
                {
                    UIManager.put("OptionPane.cancelButtonText", "Exit");
                    UIManager.put("OptionPane.okButtonText", "Submit");
            
                    userPass = JOptionPane.showInputDialog(null, "Enter the patient's date of birth.", "Submit Patient Password", QUESTION_MESSAGE);

                    if(userPass.equals("user"))
                    {
                        userSys.runWebsite(systemCheck);
                        looper = 1;
                    }
                    else if(userPass.equals(ADMIN_COND))
                    {

                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Error with Exception: " + e);
            }
        }
    }

}