package org.denlillemand.dto;

/**Historien bagved disse imports er at så længe man importere javax.persistence klasserne, så er der stadig JPA, 
 * JPA er den standard some alle ORM's skal implementere, så det betyder at vi kan udskifte vores JPA provider fra hibernate
 * til noget andet uden nogen problemer så længe vi kun bruger javax.persistence pakkerne... lige så snart vi begynder at bruge hibernate
 * specific annotations, så er det ikke længere kompatibelt med de andre frameworks, det skal dog siges at man ikke skal være bange for at
 * bruge Hibernate annotations, det er blot når man står overfor muligheden mellem at vælge, så kan man da lige så godt tage den der 
 * har support for flere providers. */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
/**Hvis man ikke vil have at hibernate gemmer en variable,
 * så skal man bare lave den static eller transient. grunden til 
 * at static f.eks ikke bliver persistet, er at alle klasser har den samme
 * værdi. der er dog en annotation der hedder @Transient , som betyder at vi kan gøre
 * en variable der ikke er transient, trasient iforhold til hvordan hibernate opfatter det. */
@Entity
@Table (name="CAR_DETAILS")
public class Car 
{
		/**Hibernate genererer en genereret int til os,
		 * hvilket nok betyder at vi ikke engang behøver at sætte AI 
		 * på vores table, det her minder mere og mere om at man bare ikke
		 * rør de ting nede i databasen men styrer det hele igennem java koden. */
		/**Hvis man ikke giver generatedValue en strategy, så er auto default,
		 * men hvis man tilføjer en strategy har man et par valg. sequence bruger f.eks et 
		 * sequence objekt, det er noget databasen har i forvejen, som den her bruger åbenbart. 
		 * hvis man bruger den der hedder Table laver den et nyt table og bruger det.
		 * Hvis den er på AUTO så lader man hibernate bestemme hvilken løsning der er det 
		 * bedste for den database vi bruger. */
	
		/**Længere nede bruger vi et tag der hedder embedded, til at lave columns der hører til de fields inde i vores
		 * instans af Address klassen,  men hvad nu hvis vores ID kom fra en klasse ligesom Address, hvis vi nu tager 4 værdier 
		 * der giver os en naturlig nøgle tilsammen, så ville man kunne ligge disse 4 værdier ind i en klasse, have en reference til
		 * instansen her, og giver den et tag der hedder  "@EmbeddedId"  vi prøver dog ikke at implementere det her. hvis 
		 * hibernate finder et objekt med den samme instans og de samme 4 værdier så vil hibernate return det samme som når vi prøver at
		 * lave 2 rows med den samme PK i mysql.*/
		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		
		@Basic( )
		private String name;
		
		/**Collections- og ikke på den måde at 
		 * vi giver hibernate en Collection af Car objektet som den kører 
		 * ned i databasen. I den forstand at Car har flere Address objekter f.eks,
		 * altså et 1-til-mange forhold, så vi skal se hvordan hibernate håndtere dette. */
		@ElementCollection
		/**JoinTable er ikke nødvendigt, det er kun hvis vi
		 * vil configuere det, f.eks navnet eller hvilken column vi gerne vil join med.
		 *  */
		@JoinTable(name="CAR_ADDRESS", joinColumns=@JoinColumn(name="Car_id")
		)
		/** hilo er en standard generator som Hibernate tilbyder(jeg er ikke helt sikker på hvad den genererer endnu :) ))*/
		@GenericGenerator(name = "hilo-gen", strategy = "hilo")
		@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "", type = @Type(type = "long"))
		/** grunden til at vi skiftede til Collection(ArrayList()) - er at vi har brug for noget der support index og 
		 * id.*/
		private Collection<Address> listOfAddresses = new ArrayList();
		
		
//		public Set<Address> getListOfAddresses() {
//			return listOfAddresses;
//		}
		
		public Collection<Address> getListOfAddresses() {
			return listOfAddresses;
		}

		public void setListOfAddresses(Collection<Address> listOfAddresses) {
			this.listOfAddresses = listOfAddresses;
		}

		/**Det er ikke nødvendigt at give den et
		 * embedded annotation, det er mere til at hjælpe os selv.
		 * Det virker til at selvom Car klassen ikke kender til vores
		 * address fields, så når vi laver vores Car table, så laver vi også
		 * alle de embedded columns som hører til address.  */
		@Embedded
		private Address embeddedAddress;
		
		
		
		/**men hvad hvis vi har 2 addresser, så er det jo besværligt
		 * at vi har givet vores column navne inde i vores Address klasse,
		 * fordi columns selvfølgelig skal have forskellige column navne.
		 * vi kan ændre disse column navne ved at override dem. */
		@Embedded
		@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="office_street_name")),
		@AttributeOverride(name="pincode", column=@Column(name="office_pincode")),
		@AttributeOverride(name="state", column=@Column(name="office_state")),
		@AttributeOverride(name="city", column=@Column(name="office_city"))
		})
		private Address officeAddress;

		public Address getOfficeAddress() {
			return officeAddress;
		}

		public void setOfficeAddress(Address officeAddress) {
			this.officeAddress = officeAddress;
		}

		/**util date, ikke sql.  denne Temporal
		 * annotation gør sådan at vi kune gemmer datoen,
		 *  og ikke vores timestamp.  men man kan også
		 *  skrive TemporalType.TIMESTAMP og så gemmer den alt tiden.
		 *  men siden vores type lige nu i databasen er timestamp, så vil den bare
		 *  skrive 00.00.00 ned til databasen mhs. til tid.. men spørgsmålet
		 *  er hvis vi lavede vores table med DATE tagget, om den ville have lavet det til en anden
		 *  type end timeStamp.*/
		@Temporal (TemporalType.DATE)
		private Date joinedDate;
		private String address;
		
		/**@Lob betyder bare at det er et stort objekt
		 * hvilket vil gøre sådan at den ikke bliver påvirket
		 * af vores varchar(255), men kan være meget større..
		 * og spørgsmålet er så hvilke andre typer den påvirker end 
		 * varchar. */
		@Lob
		private String description;
		
		
		
		public Date getJoinedDate() {
			return joinedDate;
		}

		public void setJoinedDate(Date joinedDate) {
			this.joinedDate = joinedDate;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		public Address getEmbeddedAddress() {
			return embeddedAddress;
		}
		
		public void setEmbeddedAddress(Address embeddedAddress) {
			this.embeddedAddress = embeddedAddress;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
}
