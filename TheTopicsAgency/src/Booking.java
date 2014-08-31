public class Booking 
{
	private String dato; 
	private String tidFra; 
	private String tidTil; 
	private String foredragsholder; 
	private String location; 



	public Booking(String dato, String tidFra, String tidTil, String foredragsholder, String location)
	{
		this.dato = dato;
		this.tidFra = tidFra;
		this.tidTil = tidTil;
		this.foredragsholder = foredragsholder;
		this.location = location;
	}

	public String getDato()
	{
		return dato;
	}   

	public String getTidFra()
	{
		return tidFra;
	}

	public String getTidTil()
	{
		return tidTil;
	}

	public String getForedragsholder()
	{
		return foredragsholder;
	}

	public String getLocation()
	{
		return location;
	}
}

