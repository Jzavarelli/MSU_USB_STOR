import javax.swing.*;
import java.awt.event.*;

//Admin Class: Functions as the class that will be updated and edited with the clients information. Specific admin functionality is acessed with a base password.
public class USB_ADMIN extends JFrame implements USB_FRAME, ActionListener
{

    // BuildFrame Variables: Used in the main class for our password area.
    JFrame adminFrame = new JFrame("Admin Control Editor");

    public USB_ADMIN()
    {
        buildFrame();
    }

    @Override
    public void buildFrame()
    {

    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {

    }

}
