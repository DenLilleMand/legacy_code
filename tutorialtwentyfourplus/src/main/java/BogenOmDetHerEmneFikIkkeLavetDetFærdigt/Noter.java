package BogenOmDetHerEmneFikIkkeLavetDetFærdigt;

public class Noter 
{
	/**
	 * Noter:
	 * Der er nogle ting som hører til alle klasser,
	 * som f.eks security, logging og transactions, eller hvertfald
	 * til flere klasser, der er også andre end disse. 
	 * 
	 * normalt hvis flere klasser har noget så bruger vi enten arv
	 * delegation eller composition. Men at bruge arv
	 * pga. en logging funktion er jo helt hen i vejret, og 
	 * måske er kaldne så komplicerede at selv delegation og 
	 * komposition heller ikke er gavnligt..
	 * 
	 * men der er et alternativ hvor vi ikke behøver at
	 * redigere i den kode vi allerede har skrevet for at
	 * få disse ting indført(og det er dets største fordel,
	 * hvertfald udfra et effective java synspunkt imo).
	 * 
	 * så vidt jeg har forstået indtil videre så kan man gøre
	 * det igennem annotations.
	 * 
	 * Denne annotations job, i dette tilfælde er kaldt et
	 * 'advice'  altså i spring terminologi. 
	 * et 'advice' er den opgave den udfører. advice
	 * tager sig både af 'hvornår' og 'hvad'.
	 * 
	 * Spring aspects can work with five kinds of advice:
 Before—The advice functionality takes place before the advised method is
invoked.
 After—The advice functionality takes place after the advised method completes,
regardless of the outcome.
 After-returning—The advice functionality takes place after the advised method
successfully completes.
 After-throwing—The advice functionality takes place after the advised method
throws an exception.
 Around—The advice wraps the advised method, providing some functionality
before and after the advised method is invoked.


det der hedder 'pointcuts' bestemmer vores 'where'.

'Aspect' er  'pointcuts' og 'advice' og et Aspect, ved
alt hvad den skal bruge for at gå igang.


Det her med introductions virker smart, det virker lidt som en logging
over alle ens klasser, så kan man se hvornår og hvad der sidst er blevet redigeret i en klasse:

INTRODUCTIONS
An introduction allows you to add new methods or attributes to existing classes. For
example, you could create an Auditable advice class that keeps the state of when an
object was last modified. This could be as simple as having one method, setLast-
Modified(Date), and an instance variable to hold this state. The new method and
instance variable can then be introduced to existing classes without having to change
them, giving them new behavior and state.

Much has changed in the AOP framework landscape in the past few years. There
has been some housecleaning among the AOP frameworks, resulting in some frame-
works merging and others going extinct. In 2005, the AspectWerkz project merged
with AspectJ, marking the last significant activity in the AOP world and leaving us with
three dominant AOP frameworks:
 AspectJ (http://eclipse.org/aspectj)
 JBoss AOP (http://www.jboss.org/jbossaop)
 Spring AOP (http://www.springframework.org)
Since this is a Spring book, we’ll focus on Spring AOP. Even so, there’s a lot of synergy
between the Spring and AspectJ projects, and the AOP support in Spring borrows a lot
from the AspectJ project. Spring’s support for AOP comes in four flavors:
 Classic Spring proxy-based AOP
 @AspectJ annotation-driven aspects
 Pure-POJO aspects
 Injected AspectJ aspects (available in all versions of Spring)




Table 4.1Spring leverages AspectJ’s pointcut expression language for defining Spring aspects.
AspectJ designator Description
args() Limits join point matches to the execution of methods whose arguments are
instances of the given types
@args() Limits join point matches to the execution of methods whose arguments are
annotated with the given annotation types
execution() Matches join points that are method executions
this() Limits join point matches to those where the bean reference of the AOP proxy is
of a given type
target() Limits join point matches to those where the target object is of a given type
@target() Limits matching to join points where the class of the executing object has an
annotation of the given type
within() Limits matching to join points within certain types
@within() Limits matching to join points within types that have the given annotation (the
execution of methods declared in types with the given annotation when using
Spring AOP)
@annotation Limits join point matches to those where the subject of the join point has the
given annotation

Attempting to use any of AspectJ’s other designators will result in an IllegalArgument-
Exception being thrown.

As you browse through the supported designators, note that the execution desig-
nator is the only one that actually performs matches. The other designators are used
to limit those matches. This means that execution is the primary designator you’ll use
in every pointcut definition you write. You’ll use the other designators to constrain the
pointcut’s reach.



	 * 
	 * 
	 * 
	 */
}
