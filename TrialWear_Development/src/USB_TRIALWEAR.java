// Imported Packages
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    // Main Method
    public static void main(String[] args) throws IOException
    {
        USB_USER userSys = new USB_USER();
        USB_ADMIN adminSys = new USB_ADMIN();

        Path passwordFile = Path.of("C:\\Users\\jlzav\\Documents\\MSU_Internship\\Repo\\MSU_USB_STOR\\TrialWear_Development\\.vscode\\config_settings.txt");

        Boolean systemCheck;
        String userIdentifier;
        String delString = ("[{}]+");
        //Delimiters (Dividing Characters) will need to be brakets in all configuration files.
        int loopControl = 0;
        int delLimit = 4; 
        //Delimiter Limit will need to be equal to the number of delimiters in our password file.

        String patientPass = Files.readString(passwordFile);
        String delArray[] = patientPass.split(delString, delLimit);

        userSys.buildFrame();
    
        // System Loop - Used in Main Method to continually run with Error, until the system exit.
        while(loopControl < 1)
        {
            systemCheck = userSys.getBoolean();
            //Initalizing Print Statement - TEMP
            System.out.println("");
            
            // Try Statement - Used in correcting broad errors.
            try
            {
                if(systemCheck == true)
                {
            
                    UIManager.put("OptionPane.cancelButtonText", "Exit");
                    UIManager.put("OptionPane.okButtonText", "Submit");
                    
                    userIdentifier = JOptionPane.showInputDialog(null, "Enter the patient's date of birth.", "Submit Patient Identifier", JOptionPane.QUESTION_MESSAGE);

                        if(userIdentifier.equals(delArray[1]))
                        {
                            userSys.runWebsite(systemCheck);
                            loopControl = 1;
                        }
                        else if(userIdentifier.equals("admin"))
                        {
                            userSys.dispose();
                            adminSys.buildFrame();

                            loopControl = 1;
                        }
                        else if(!userIdentifier.equals(delArray[1]))
                        {
                            JOptionPane.showMessageDialog(null, "Incorrect Patient Identifier", "IDENTIFIER ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                }
            }
            catch(NullPointerException e)
            {
                loopControl = 1;
                System.exit(0);
                System.out.println("Exit System: " + e);
            }
        }
    }

}