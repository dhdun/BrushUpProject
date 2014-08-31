import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel; 
import javax.swing.table.JTableHeader;

public class GuiBooking implements ActionListener
{
	DataAccessBooking dab = new DataAccessBooking();

	private Font font = new Font("Lucida Bright", Font.BOLD, 15);
	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JTable table;
	private DefaultTableModel model;
	private JButton opretBooking;
	private JButton sletBooking;
	private JButton update;


	public GuiBooking()
	{
		frame = new JFrame("BOOKINGOVERSIGT");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(600,100);
		frame.setLayout(new BorderLayout(2,2));
		frame.setSize(750,800);
		frame.setVisible(true);

		panel1 = new JPanel(new BorderLayout());
		panel2 = new JPanel(new FlowLayout());
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);

		model = new DefaultTableModel();
		table = new JTable(model);

		model.addColumn("DATO (DD/MM/YYYY)");
		model.addColumn("TID (FRA)");
		model.addColumn("TID (TIL)");
		model.addColumn("FOREDRAGSHOLDER");
		model.addColumn("LOCATION");

		try
		{
			dab.loadTable("bookinger.txt", model); //Loader tekstfil indtil JTable
		}
		catch (Exception ex)
		{
		} 

		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.yellow);

		table.setPreferredScrollableViewportSize(new Dimension(500, 500));
		table.setAutoCreateRowSorter(true);
		table.getRowSorter().toggleSortOrder(0);
		table.setColumnSelectionAllowed(false);
		table.setFillsViewportHeight(true);

		panel1.add(header, BorderLayout.NORTH);
		panel1.add(table, BorderLayout.CENTER);

		//Lav knap til Opret Booking
		opretBooking = new JButton("Opret Booking");
		opretBooking.setFont(font);
		opretBooking.addActionListener(this);
		panel2.add(opretBooking);

		//Lav knap til Slet Booking
		sletBooking = new JButton("Slet Booking");
		sletBooking.setFont(font);
		sletBooking.addActionListener(this);
		panel2.add(sletBooking);

		//Lav knap til Update
		update = new JButton("Update");
		update.setFont(font);
		update.addActionListener(this);
		panel2.add(update);

		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == opretBooking)
		{
			new GuiOpretBooking();
		}
		if (event.getSource() == sletBooking)
		{
			new GUISletBooking();
		}
		if (event.getSource() == update)
		{
			try
			{  
				model.setRowCount(0); //Tømmer JTable
				dab.loadTable("Booking.txt", model); //loader tekstfilen ind i det tømte JTable
			}
			catch (Exception ex)
			{
			} 

		}
	}
}
