package gumballMachineMedBedreDesignRemoteMehtodInvocation;

public class NoterTilRMIRemoteMethodInvocation {
/**
 * Så remote method invocation er en
 * built in API til at finde objekter på en anden
 * heap end ens egen, og så kan man bruge det objekt til at
 * kalde metoder på det og what not.
 * 
 * Det første vi har brug for er en local proxy, og det er et objekt
 * af den type som vi gerne vil have fat i ovre på den anden side af heapen,
 * og der tænker jeg nu, at faktisk skal de jo bare implementere det samme interface for
 * at det er iorden :) . 
 * 
 * Det gør vi for at programmet kan behandle det som et helt normalt objekt, men faktisk
 * sender objektet kaldne videre over nettet til sit tilsvarene remote objekt.
 * 
 * på side 445 er der et nice diagram over det her.
 * 
 * Så vidt jeg forstår, så har vi slet ikke noget med I/O & networking at gøre
 * når vi bruger den indbyggede RMI, den håndtere det hele for os, sådan at vi bare 
 * kan kalde almindelige metoder, hvad den giver os er Client helper(vores locale objekt) og Service Helperen(Remote objektet)
 * Hvad man dog skal være opmærksom på, er at det IKKE er et normalt metode kald, det er stadig
 * I/O, og hvis der er en ting I/O er god til så er det at smide exceptions, så det skulle
 * også helst blive reflekteret i den her kode hvordan det ser ud.
 */
}
