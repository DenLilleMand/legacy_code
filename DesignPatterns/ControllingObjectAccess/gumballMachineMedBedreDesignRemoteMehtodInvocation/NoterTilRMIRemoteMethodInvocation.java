package gumballMachineMedBedreDesignRemoteMehtodInvocation;

public class NoterTilRMIRemoteMethodInvocation {
/**
 * S� remote method invocation er en
 * built in API til at finde objekter p� en anden
 * heap end ens egen, og s� kan man bruge det objekt til at
 * kalde metoder p� det og what not.
 * 
 * Det f�rste vi har brug for er en local proxy, og det er et objekt
 * af den type som vi gerne vil have fat i ovre p� den anden side af heapen,
 * og der t�nker jeg nu, at faktisk skal de jo bare implementere det samme interface for
 * at det er iorden :) . 
 * 
 * Det g�r vi for at programmet kan behandle det som et helt normalt objekt, men faktisk
 * sender objektet kaldne videre over nettet til sit tilsvarene remote objekt.
 * 
 * p� side 445 er der et nice diagram over det her.
 * 
 * S� vidt jeg forst�r, s� har vi slet ikke noget med I/O & networking at g�re
 * n�r vi bruger den indbyggede RMI, den h�ndtere det hele for os, s�dan at vi bare 
 * kan kalde almindelige metoder, hvad den giver os er Client helper(vores locale objekt) og Service Helperen(Remote objektet)
 * Hvad man dog skal v�re opm�rksom p�, er at det IKKE er et normalt metode kald, det er stadig
 * I/O, og hvis der er en ting I/O er god til s� er det at smide exceptions, s� det skulle
 * ogs� helst blive reflekteret i den her kode hvordan det ser ud.
 */
}
