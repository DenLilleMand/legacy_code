package org.denlillemand.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
/**Jeg ved sku ikke helt, i vores tutorial brugte han
 * @Entity men den er åbenbart deprecated i hibernate 4,
 * så nu prøver vi med den her i stedet for, selvom der nok også er andre
 * muligheder. */
@Entity
@Table(name = "userdetails")
public class UserDetails 
{
	@Id /** Dette er en måde at fortælle hibernate på 
	at dette er vores primarykey */
	@Column (name="User_ID")
	private int userId;
	
	/** dette er ikke nødvendigt, men man vil nok normalt gerne bestemme hvad
	 * de forskellige columns hedder osv, ellers kalder den det bare det samme som variablenavnet. */
	
	/**OBS! man kan også sætte annotationen overpå vores getter() istedet for på vores variable,
	 * og det giver enlig nok et bedre overblik. det der er forskellen på det er at enten tager vi værdieren
	 * fra vores getter, eller også tager den værdien direkte fra vores variable, og man kunne forestille
	 *  sig at variablen er mest standard, men hvis man vil tilføje noget for at gøre variablen klar 
	 *  til databasen kunne man måske lave en ny getter kun til database brug som tilføjer en 
	 *  dato til værdien eller hvad ved jeg,  selvom det faktisk ville bryde vores normalisering med mere
	 *  end 1 værdi i en column :)  */
	
	/** Bare fordi vores database tidligere har lavet columns med disse attributter,
	 * så fordi vi har ændret navnet på column, så har den også oprettet disse columns. man kan nok
	 * også godt sætte dem PK og de andre værdier her, men spørgsmålet er om fordi vores id har @Id tagget,
	 * om den her column automatisk ville lave den pk selvom vi selv bestemmer column name, det tror jeg.*/
	@Column (name="user_name")
	private String userName;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
