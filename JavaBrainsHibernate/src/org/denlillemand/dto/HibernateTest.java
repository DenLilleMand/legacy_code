package org.denlillemand.dto;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**tip: når man øver hibernate så er det godt at sætte den der hddbl eller hvad den hedder til create i stedet for update,
 * men når applikationen går live er det selvfølgelig oftest 'update' man er interesseret i. */
public class HibernateTest 
{
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	/** 
	 * OBS! hans tutorial fortsætter bare med at redigere UserDetails hele tiden, slette ting osv.
	 * men for hver gang han starter en ny tutorial så laver vi bare et nyt objekt som bare har de 
	 * samme attributter som hans har- kan nok godt finde et par klasser der kun kræver id + name.
	 * 
	 * 
	 * normalt i en rigtig applikation, og 
	 * disse hibernate klasser skulle lige i vores service lag,
	 * så ville man give denne information videre til en 
	 * DAO klasse som tog sig af den her specifikke type.
	 * 
	 *  Noget som jeg ikke lige havde tænkt på er at vi skal være super obs på at kalde vores klasser
	 *  som skal persistes, noget som ikke er et keyword nede i vores database. som f.eks "User"  
	 *  eller det må vi godt men så skal vi skrive name = "User_Details f.eks" . som vi kan se ovre i vores
	 *  User_Details klassen eller blabla vores hedder allerede UserDetails, og jeg gider ikke lige at ændrer
	 *  den til User, så skal jeg configuere alle tingne i vores xml filer igen.*/
	public static void main(String[] args) 
	{
			Car car = new Car();
			car.setAddress("address 1");
			car.setDescription("description 1");
			car.setName("name1");
			car.setJoinedDate(new Date());
			
			Address addr = new Address();
			addr.setStreet("street1");
			addr.setState("state1");
			addr.setPincode("pincode");
			addr.setCity("city1");
			
			Address officeAddr = new Address();
			officeAddr.setStreet("officestreet1");
			officeAddr.setState("office state1");
			officeAddr.setPincode(" office pincode");
			officeAddr.setCity("office city1");
			
			car.getListOfAddresses().add(addr);
			car.getListOfAddresses().add(officeAddr);
			
			car.setEmbeddedAddress(addr);
		
		/** Skal have fat i vores config*/
		    Configuration configuration = new Configuration();
		    //configuration.addClass(UserDetails.class);
		    configuration.configure();
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		    Session session = sessionFactory.openSession();
		    session.beginTransaction();
		    session.save(car);
		    session.getTransaction().commit();
		    session.close(); //vigtigt, ellers fryser den vores database :)
		    
		    /**Prøver at hente objektet ind fra databasen. */
		    car = null;
		    
		    session = sessionFactory.openSession();
		    session.beginTransaction();
		    car = (Car) session.get(Car.class,1); //1 er vores primary key. og det ved den allerede fordi 
		    						//vi har annotated vores id som @Id ovre i vores Car klasse.
		    System.out.println(car.getEmbeddedAddress().getCity());
		    /**Lige nu som det er, så bruger hibernate by-default lazy initialization, det betyder at vi først henter tingne op når
		     * getteren bliver kaldt, og ikke før, Dette tror jeg dog
		     * kun hører til collections, og måske også nogle andre
		     * hvis man specificicere at det er et stort objekt,
		     * Hibernate laver et proxy objekt for os når vi henter et objekt op, dette proxyObject 
		     * står for at hente yderligere informationer hvis vi kalder den getter. Dog hvis vi vil undgå dette kan vi istedet for 
		     * tagget @ElementCollection bruger tagget: @ElementCollection(fetch=FetchType.EAGER) hvilket gør at selvom vi lukker for
		     * vores session før vi kalder  getListOfAddresses() så har den stadig hentet det op. Jeg er dog ikke helt sikker på 
		     * hvornår man har lyst til bare at lade en session kører for at få adgang til resten af dataen og hvornår man bare burde lukke for 
		     * en session, hente nogle ting op - og så senere starte en ny session og hente resten op. 
		     * 
		     * . Dette bliver gjort ligesom vi gjore i Oikos projektet hvor vi kun var interesseret i 5 attributter
		     * der skulle være i vores JTable. */
		    session.close();
		    
	}
}
