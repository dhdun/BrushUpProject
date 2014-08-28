import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class GuiMain extends JFrame implements ActionListener
{
	private JTabbedPane tabbedPane = new JTabbedPane();
	private Font font = new Font("Lucida Bright", Font.BOLD, 15);
	private JButton bookingOversigt;
	   
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
	    lønTab();
	    
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
	    
	    //Tilføj knap til booking-tab 
	    bookingOversigt = new JButton("VIS BOOKINGOVERSIGT");
	    bookingOversigt.setFont(font);
	    panelBooking.add(bookingOversigt);
	    bookingOversigt.addActionListener(this);
	 }
	 
	 public void lønTab()
	 {
	    JPanel panelBooking = new JPanel();
	    tabbedPane.addTab("Lønberegning", panelBooking);
	    tabbedPane.setFont(font);
	 }

	public void actionPerformed(ActionEvent event) 
	{
		if (event.getSource() == bookingOversigt)
		{
			GuiBooking gb = new GuiBooking();
		}
		
	}
}
