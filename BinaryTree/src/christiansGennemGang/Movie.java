package christiansGennemGang;

public class Movie implements Comparable<Movie>{

	private String title;
	private Integer productionYear;
	
	public Movie(String title, int productionYear)
	{
		this.title = title;
		this.productionYear = productionYear;
	}
	
	
	/**
	 * Man kan ogs� bruge de boxed typer som Integer og Double for at f� fat i deres compareTo metode,
	 * Man kunne dog forestille sig at unboxed-fanatikere ville foretr�kke at vi implementere vores egen compareTo metode med den primitive type,
	 * for at undg� s� meget overhead som muligt.
	 */
	@Override
	public int compareTo(Movie o) 
	{
		//return this.getTitle().compareTo(o.getTitle());
		return this.getProductionYear().compareTo(o.getProductionYear());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
}
