import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel; 

public class DataAccessBooking 
{
	public void writeToFile(Booking b) throws Exception
	{
		FileWriter fw = new FileWriter("Booking.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		pw.println(b.getDato() + ", " + b.getTidFra() + ", " + b.getTidTil() + ", " + b.getForedragsholder() + ", " + b.getLocation()); 
		pw.close();
	}

	public void loadTable(String textfile, DefaultTableModel model) throws Exception
	{
		BufferedReader bfr = new BufferedReader(new FileReader(textfile)); 
		String line;      

		while((line = bfr.readLine()) != null ) 
		{ 
			model.addRow(line.split(", ")); 
		}
		bfr.close();
	}


	public void sletMedlem(String mobilNr) throws Exception 
	{ 
		File inputFil = new File("Booking.txt");
		File midlertidigFil = new File("BookingFil.txt");

		BufferedReader br = new BufferedReader(new FileReader(inputFil));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(midlertidigFil)));

		String fjernRow = mobilNr;
		String line;

		while((line = br.readLine()) != null)
		{
			String trimLine = line.trim(); 
			if(!trimLine.contains(fjernRow)) 
			{
				pw.println(line); 
			}
		}
		pw.close();
		br.close();

		if(!inputFil.delete()) 
		{
			JOptionPane.showMessageDialog(null, "FEJL");
			return;
		}
		if(!midlertidigFil.renameTo(inputFil))
			JOptionPane.showMessageDialog(null, "FEJL");

	}
}



