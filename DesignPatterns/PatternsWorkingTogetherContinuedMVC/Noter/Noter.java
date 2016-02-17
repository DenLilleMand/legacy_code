package Noter;

public class Noter 
{
/**
 * Det her projekt handler om MVC, og hvordan vi kan s�tte det op med design 
 * patterns - og de f�r det til at lyde som om at selve MVC(et compound pattern) 
 * er en samling af et par design patterns, s� vi m� se hvad de mener med det.
 * 
 * Definionerne p� de 3 ting(p� side 538 kan man se en model over det):
 * 
 * Model:  The model holds all the data,
 * state and application logic. The model is
 * oblivious to the view and controller,
 * allthough it provides an interface to manipulate and retrieve its state and it can
 * send notifications of state changes to observer.
 * 
 * View: Gives you a presentation of the model.
 * The view usually gets the state and data it needs to display directly
 * from the model.
 * 
 *  * Controller: Takes user input and figuires out
 * what it means to the model.
 * 
 * 
 * side 539 - er ogs� interessersant, specielt nederst, hvor der er et s�gt sp�rgsm�l,
 * der g�r p� om  controlleren nogensinde bliver en observer af vores Model,
 * og det giver jo fint mening at man bruger et observer pattern til at give controlleren
 * nyheder om �ndringer i state.
 * 
 * det er vigtigt at man forst�r hvorfor controlleren findes, det er for at holde models
 * ansvar til 1 ting, istedet for at den b�de skal st� for logikken bag ved interfacet
 * og holde state og diverse andre ting, s� det betyder at controlleren
 * ikke bare smider kald videre - den forarbejder ogs� alt logikken, lidt ligesom vores
 * UtilControl klasse n�r den st�r for at tale med control klasserne for vores gui.
 * 
 * View & Controller implementere det standard Strategy Pattern,
 *'The view and controller implement the classic Strategy Pattern: the
 *view is an object that is configuired with a strategy. The controller
 *provides the strategy. The view is concerned only with the visual aspects of the application, and delegates to the
 *controller for any decisions about
 *the interface behavior. Using the strategy
 *pattern also keeps the view decoupled from the model because it is the controller that is responsible for interacting
 *with the model to carry out user requests. The view knows nothing about how this gets done'.
 *
 *Der er ogs� noget mere om den model p� side 540 om dette.
 *
 *bla noget interessersant om hvordan man kan bruge composite til at
 *opdatere alle componenter i et view samtidigt.
 *f.eks er paint() metoden jo ogs� et composite pattern,
 *men hvorfor laver vi ikke bare alle components composite,
 *og s� bruger man et strategy pattern
 *til at udskifte controller klassen afh�ngig af hvor man er i guien,
 *det er tydeligvis ikke vores ide, det st�r i bogen med lidt andre ord,
 *men det er jo genialt.
 *
 *
 *og at vores model selF bruger observer pattern for at v�re fuldkommen decoupled fra controller/view.
 *
 *tjek side 541(!!!) den er super god til at give overskuelighed.
 *
 *
 *man kan se hele koden : wickedlysmart.com, kan se p� side 546 hvordan den foresl�r det.
 *
 *
 *
 */
}
