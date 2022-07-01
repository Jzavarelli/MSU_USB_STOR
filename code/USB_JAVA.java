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
        USB_USER userSys = new USB_USER();

        Boolean systemCheck;
        String userPass;
        int looper = 0;

        userSys.buildFrame();

        while(looper < 1)
        {
            systemCheck = userSys.getBoolean();
            System.out.println("");

            if(systemCheck == true)
            {
                UIManager.put("OptionPane.cancelButtonText", "Exit");
                UIManager.put("OptionPane.okButtonText", "Submit");
        
                userPass = JOptionPane.showInputDialog(null, "Enter the patients date of birth.", "Submit Patient Password", QUESTION_MESSAGE);

                if(userPass.equals(USER_COND))
                {
                    userSys.runWebsite(systemCheck);
                    looper = 1;
                }
                else if(userPass.equals(ADMIN_COND))
                {

                }

            }
        }
    }

}