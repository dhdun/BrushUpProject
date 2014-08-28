import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GuiMain extends JFrame
{
   private JTabbedPane tabbedPane = new JTabbedPane();
   private Font font = new Font("Lucida Bright", Font.BOLD, 15);
   
   public GuiMain()
   {
      setTitle("The Topics Agency");
      
      setSize(1200,800);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BorderLayout());
      getContentPane().add(topPanel);
      
      topPanel.add(tabbedPane, BorderLayout.CENTER);
      
      Image image = new ImageIcon("logo.png").getImage(); 
      setIconImage(image);
      
      startTab();
      bookingTab();
      //
      //
      
      setVisible(true);
   }
   
   public void startTab()
   {
      //Lav start-tab
      JPanel panelStart = new JPanel();
      tabbedPane.addTab("Startside", panelStart);
      tabbedPane.setFont(font);
      ImageIcon picture = new ImageIcon("logo2.png");
      panelStart.add(new JLabel(picture));      
   }
   
   public void bookingTab()
   {
      JPanel panelBooking = new JPanel();
      tabbedPane.addTab("Booking", panelBooking);
      tabbedPane.setFont(font);
      
      Calendar calendar = new GregorianCalendar();

   }
}