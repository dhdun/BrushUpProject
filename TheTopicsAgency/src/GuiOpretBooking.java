import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiOpretBooking implements ActionListener
{
	DataAccessBooking dab = new DataAccessBooking();

	private Font font = new Font("Lucida Bright", Font.BOLD, 15);
	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	protected JTextField datoTxt;
	protected JTextField tidFraTxt;
	protected JTextField tidTilTxt;
	protected JTextField foredragsholderTxt;
	protected JTextField locationTxt;
	private JButton gemOplysninger;

	public GuiOpretBooking()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(new Dimension(400, 400));
		frame.setTitle("OPRET BOOKING");
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setLayout(new BorderLayout());

		panel1 = new JPanel(new GridLayout(7,2));
		panel2 = new JPanel(new FlowLayout());

		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);

		//Tilføj label og JTextfields til panel
		JLabel dato = new JLabel("DATO (DD/MM/YYYY): ");
		datoTxt = new JTextField(10);
		panel1.add(dato);
		panel1.add(datoTxt);

		JLabel tidFra = new JLabel("TID (FRA): ");
		tidFraTxt = new JTextField(10);
		panel1.add(tidFra);
		panel1.add(tidFraTxt);

		JLabel tidTil = new JLabel("TID (TIL): ");
		tidTilTxt = new JTextField(10);
		panel1.add(tidTil);
		panel1.add(tidTilTxt);

		JLabel foredragsholder = new JLabel("Foredragsholder: ");
		foredragsholderTxt = new JTextField(10);
		panel1.add(foredragsholder);
		panel1.add(foredragsholderTxt);

		JLabel location = new JLabel("Location: ");
		locationTxt = new JTextField(10);
		panel1.add(location);
		panel1.add(locationTxt);

		//Gem oplysninger knap
		gemOplysninger = new JButton("Gem indtastede oplysninger");
		gemOplysninger.setFont(font);
		gemOplysninger.addActionListener(this);
		panel2.add(gemOplysninger);

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == gemOplysninger)
		{
			try
			{
				Booking nytBooking = new Booking(datoTxt.getText(), tidFraTxt.getText(), tidTilTxt.getText(), foredragsholderTxt.getText(), locationTxt.getText());			
				dab.writeToFile(nytBooking);
				JOptionPane.showMessageDialog(null, "Booking blev oprettet korrekt!");
				frame.dispose(); //lukker dette (og kun dette) vindue i programmet.
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			}
		}

	}
}
