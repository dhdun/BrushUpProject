import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel; 

public class DataAccessForedragsholder 
{
	public void writeToFile(Foredragsholder fh) throws Exception
	{
		FileWriter fw = new FileWriter("medlemmer.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		pw.println(fh.getNavn() + ", " + 
				fh.getMobilNummer() + ", " + 
				fh.getAdresse() + ", " + 
				fh.getDato() + ", " + 
				fh.getTid() + ", " + 
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


	public void sletMedlem(String mobilNr) throws Exception //(Næsten)copy-paste fra: http://stackoverflow.com/questions/23097163/delete-string-from-text-file-fails-on-deployment-in-tomcat
	{ 
		File inputFil = new File("medlemmer.txt");
		File midlertidigFil = new File("medlemmerTempFil.txt");

		BufferedReader br = new BufferedReader(new FileReader(inputFil));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(midlertidigFil)));

		String fjernRow = mobilNr;
		String line;

		while((line = br.readLine()) != null)
		{
			String trimLine = line.trim(); //trim fjerner alle indledende og afsluttende white-space karakterer
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



