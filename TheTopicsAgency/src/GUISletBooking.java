import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUISletBooking implements ActionListener
{
	DataAccessBooking dab = new DataAccessBooking();

	private JFrame frame;
	private JPanel panel;
	private JPanel panel2;
	private JButton slet;
	JLabel foredragsholder;
	JTextField foredragsholderTxt;
	private Font font = new Font("Constantia", Font.ITALIC, 13);

	public GUISletBooking()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(new Dimension(400, 400));
		frame.setTitle("SLET BOOKING");
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setLayout(new BorderLayout()); 

		panel = new JPanel(new FlowLayout());
		panel2 = new JPanel(new FlowLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);

		foredragsholder = new JLabel("Indtast foredragsholder:"); 
		foredragsholderTxt = new JTextField(10);
		panel.add(foredragsholder);
		panel.add(foredragsholderTxt);

		slet = new JButton("Slet booking");
		slet.setFont(font);
		slet.addActionListener(this);
		panel2.add(slet);

		frame.setVisible(true);

	}
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == slet)
		{
			int answer = JOptionPane.showConfirmDialog(null, "Er du sikker på du vil slette Booking: " + foredragsholderTxt.getText());
			if(answer == JOptionPane.YES_OPTION)
			{
				try
				{
					dab.sletMedlem(foredragsholderTxt.getText());
					JOptionPane.showMessageDialog(null, "Booking blev slettet korrekt!");
					frame.dispose();
				}
				catch(Exception ex)
				{
				}
			}
			else if (answer == JOptionPane.NO_OPTION)
			{
				frame.dispose();
			}
		}

	}
}