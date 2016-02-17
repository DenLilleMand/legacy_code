package measuringAnAlgorithmsEfficiency;

public class RunOgNoter 
{
	/**
	 * tl;dr;
	 * Det virker til at deres generalle budskab er at m�ngden af tid en algoritme er om
	 * at udregne noget, er sammenlagt hvor mange simple matematik operationer der skal til for 
	 * at regne noget ud.
	 * 
	 * Og det virker til at det vigtigste er at vi skelner imellem hvor lang tid en algoritme tager,
	 * i forhold til hvor meget plads den optager p� den m�de at assigne variabler kun har noget
	 * med plads at g�re, det har intet at g�re med hvor lang tid en algoritme er om det,
	 * det som har noget at g�re med om en algoritme er hurtig er hvordan den bruger sine
	 * basic operations, om den bruger +/-  division/gange  - og vigtigst, hvor mange gange,
	 * den beh�ver at bruge disse f�r vi har et resultat.   p� side 91 kan man se i figur 4-2 
	 * at der er et table over hvor mange gange algoritmen bruger en basic operation.
	 * 
	 * 'The process of measuring the complexity of algorithms is called the analysis of algorithms. We
will concentrate on the time complexity of algorithms, because it is usually more important than the
space complexity. You should realize that an inverse relationship often exists between an algorithm�s
time complexity and its space complexity. If you revise an algorithm to save execution time, you usually
will need more space. If you reduce an algorithm�s space requirement, it likely will require more time to
execute. Sometimes, however, you will be able to save both time and space.'

'Typically, we are interested in large problems; a small problem is likely to take little time,
even if the algorithm is inefficient.' 

large problem = f.eks en collection, hvor size = 500. s� 500 er en funktion af algoritmen, 
p� den m�de at tiden/plads det tager at udf�rer denne algoritme skal ganges med funktionen.
	 * 
	 * Noter:
	 * 
	 * Det handler selvf�lgelig om at identificere 
	 * hvad man skal bruge sin algoritme til, 
	 * hvad der er vigtigt for en, om den er stabil, hurtig, performance-light osv.�
	 * 
	 * In general,
however, implementing several ideas before you choose one requires too much work to be practical.
Besides, a program�s execution time depends in part on the particular computer and the programming
language used. It would be much better to measure an algorithm�s efficiency before you
implement it.
	 * 
	 * Note: If an algorithm takes longer to execute than is practical, try to reformulate it to make
it more efficient of time.

Note: What�s best?
Usually the �best� solution to a problem balances various criteria such as time, space, generality,
programming effort, and so on.
	 * 
	 * 
	 */
}
