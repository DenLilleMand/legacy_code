package duckSimulatorACompoundPattern;
import observerPatternForDucks.QuackoLogist;
import compositeDuckImplementation.Flock;
import adapter.GooseAdapter;
import decorator.QuackCounter;
import ducks.DuckCall;
import ducks.MallardDuck;
import ducks.RedheadDuck;
import ducks.RubberDuck;
import factoryPatternForDucks.AbstractDuckFactory;
import factoryPatternForDucks.CountingDuckFactory;
import factoryPatternForDucks.DuckFactory;
import gooses.Goose;
import interfaces.Quackable;

/**
 * man kan se skridtne der er taget p� det her projekt overordnet p� side 531 --
 *
 * man kan se hvad der svarer til et klasse diagram p� side 532-532
 * dette klasse diagram burde man faktisk g� tilbage og refererer n�ste gang man skal have
 * implementeret design patterns i et st�rre system - og s� bruge den samme overskuelighed 
 * som bliver vist der.
 * 
 * 
 * @author DenLilleMand
 *
 */
public class DuckSimulator 
{

	public static void main(String[] args) 
	{
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new DuckFactory();
		AbstractDuckFactory counterDuckFactory = new CountingDuckFactory();
		simulator.simulate(counterDuckFactory);
	}

	public void simulate(AbstractDuckFactory factory)
	{
		Quackable mallardDuck = factory.createMallardDuck();
		Quackable redheadDuck = factory.createRedheadDuck();
		Quackable duckCall = factory.createDuckCall();
		Quackable rubberDuck = factory.createRubberDuck();
		/**
		 * Nu bruger vi s� adapter pattern,
		 * til at f� en goose til at passe ind.
		 */
		Quackable gooseWithQuackable = new GooseAdapter(new  Goose());
		
		System.out.println("\nDuck Simulator");
		
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseWithQuackable);
		
		/**
		 * composite + iterator pattern at work :) 
		 * Faktisk kan man se hvordan vi her kun kan tilf�je Ducks til en Flock,
		 * imens man f.eks ikke kan tilf�je en Duck til en Duck(eller pr�ve) ...
		 * det g�r designet mere sikkert, men i f.eks vores Composite pattern project
		 * med leafs og nodes(menu / menuitems) - hvor man kunne kalde alle metoder p� begge
		 * typer og s� ville den bare smide en exception hvis du pr�vede at tilf�je
		 * en menu til en menuItem -det gav et mere gennemskueligt design fordi man ikke
		 * behandlede de 2 anderledes fra hinanden, deres print() metode var f.eks ens,
		 * og nogle af de andre metoder var ogs� ens... men s� havde de lige et par som ikke
		 * gav mening der smed en exception -- s� det er et design sp�rgsm�l som man m� vurdere 
		 * fra gang til gang,
		 * om man vil ligge metoder op i ens interface(husk at interface b�de kan v�re
		 * en abstract klasse eller et decideret interface). 
		 */
		Flock flock = new Flock();
		flock.addQuacker(mallardDuck);
		flock.addQuacker(redheadDuck);
		flock.addQuacker(duckCall);
		flock.addQuacker(rubberDuck);
		flock.addQuacker(gooseWithQuackable);
		
		simulate(flock);
		
		/**
		 * QuackCounter er adapter pattern
		 * og det er super smart at vi bruger en statisk
		 * int til at t�lle, det bliver jo delt
		 * over alle instanser af objektet, det burde
		 * man lidt oftere bruge til noget smart. 
		 * Hvis vi nu havde brugt den anden factory, s� ville det her have givet
		 * en nullpointer hvis den ikke havde v�ret statisk, men det jeg tror ikke her.
		 */
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
		
		
		
		/**
		 * Observer pattern testet:
		 */
		
		QuackoLogist quackoLogist = new QuackoLogist();
		flock.registerObserver(quackoLogist);
		
		flock.quack();
	}
	
	public void simulate(Quackable duck)
	{
		duck.quack();
	}
	
	
}
