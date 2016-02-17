package clientAndService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Dette er åbenbart et 'service provider framework pattern' .
 * eller hvertfald et eksempel på det.man kan se mere af det på side 31 i 'Effective java'
 * Jeg synes at koden er til at forstår,
 * bortset fra at jeg ikke helt ved hvad en service indebærer.
 * bogen skriver generalt et meget højt niveau java.
 * 
 * @author DenLilleMand
 *
 */
public interface Service
{
	... // Service-specific methods go here
}

public interface Provider
{
	Service newService();
}


//Noninstantiable class for service registration 
//and access
public class Services
{
	private Services() {} //prevents instantiation

//maps service names to service
	private static final Map<String, Provider> providers = new ConcurrentHashMap<String,Provider>();
	
	public static final String DEFAULT_PROVIDER_NAME = "<def>";

	//Provider registration API
	public static void registerDefaultProvider(Provider p)
	{
		registerProvider(DEFAULT_PROVIDER_NAME,p);
	}

	public static void registerProvider(String name, Provider p) {
		providers.put(name,p);
	}
	
	//Service access API
	public static Service newInstance()
	{
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	
	public static Service newInstance(String name)
	{
		Provider p = providers.get(name);
		if(p == null)
		{
			throw new IllegalArgumentException("No provider registered with name " + name);
			return p.newService();
		}
	}
}