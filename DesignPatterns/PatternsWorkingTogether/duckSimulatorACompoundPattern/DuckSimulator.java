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
 * man kan se skridtne der er taget på det her projekt overordnet på side 531 --
 *
 * man kan se hvad der svarer til et klasse diagram på side 532-532
 * dette klasse diagram burde man faktisk gå tilbage og refererer næste gang man skal have
 * implementeret design patterns i et større system - og så bruge den samme overskuelighed 
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
		 * Nu bruger vi så adapter pattern,
		 * til at få en goose til at passe ind.
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
		 * Faktisk kan man se hvordan vi her kun kan tilføje Ducks til en Flock,
		 * imens man f.eks ikke kan tilføje en Duck til en Duck(eller prøve) ...
		 * det gør designet mere sikkert, men i f.eks vores Composite pattern project
		 * med leafs og nodes(menu / menuitems) - hvor man kunne kalde alle metoder på begge
		 * typer og så ville den bare smide en exception hvis du prøvede at tilføje
		 * en menu til en menuItem -det gav et mere gennemskueligt design fordi man ikke
		 * behandlede de 2 anderledes fra hinanden, deres print() metode var f.eks ens,
		 * og nogle af de andre metoder var også ens... men så havde de lige et par som ikke
		 * gav mening der smed en exception -- så det er et design spørgsmål som man må vurdere 
		 * fra gang til gang,
		 * om man vil ligge metoder op i ens interface(husk at interface både kan være
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
		 * int til at tælle, det bliver jo delt
		 * over alle instanser af objektet, det burde
		 * man lidt oftere bruge til noget smart. 
		 * Hvis vi nu havde brugt den anden factory, så ville det her have givet
		 * en nullpointer hvis den ikke havde været statisk, men det jeg tror ikke her.
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
