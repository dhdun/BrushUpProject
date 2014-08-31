public class Booking 
{
	private String navn; 
	private String mobilNummer; 
	private String adresse; 
	private String dato; 
	private String tid; 

	

	public Booking(String navn, String mobilNummer, String adresse, String dato, String tid)
	{
		this.navn = navn;
		this.mobilNummer = mobilNummer;
		this.adresse = adresse;
		this.dato = dato;
		this.tid = tid;
	}

	public String getNavn()
	{
		return navn;
	}   

	public String getMobilNummer()
	{
		return mobilNummer;
	}

	public String getAdresse()
	{
		return adresse;
	}
	
	public String getDato()
	{
		return dato;
	}

	public String getTid()
	{
		return tid;
	}
}

