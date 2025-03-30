package hra;

import command.*;
import postavy.PraviPrarodice;
import svet.Mistnost;
import svet.Svet;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Třída {@code Hra} představuje hlavní logiku a interakci hry.
 * Řídí inicializaci, vykonávání příkazů a komunikaci s hráčem během hraní.
 */
public class Hra {
    private final Scanner sc = new Scanner(System.in);
    private final HashMap<String, Command> prikazy = new HashMap<>();
    private final Svet svet = new Svet();
    private final Hrac hrac = new Hrac();
    Mistnost aktualniMistnost = svet.getMapa().get("detska");
    /**
     * Inicializuje hru, nastavuje příkazy, postavy a místnosti.
     */
    public void initialization() {
        hrac.setAktualniMistnost(aktualniMistnost);
        prikazy.put("jdi", new Pohyb());
        prikazy.put("mapa", new PrintMapa());
        prikazy.put("vezmi", new Vezmi());
        prikazy.put("hledej", new Prozkoumej());
        prikazy.put("konec", new Konec());
        prikazy.put("pouzij", new Pouzij());
        prikazy.put("napoveda", new Napoveda());
        prikazy.put("mluv", new Mluv());
        for (Command cmd : prikazy.values()) {  // Přiřadí hráče a svět každému příkazu
            cmd.set(hrac, svet);
        }
        vstupniText();
    }
    /**
     * Vykonává příkazy zadané hráčem.
     * Na základě příkazu hráče vykoná příslušnou akci.
     */
    public void doIt() {
        getPrikazy();
        System.out.print("\n> ");
        String odpoved = sc.next();
        if (prikazy.containsKey(odpoved)) {
            System.out.println(prikazy.get(odpoved).execute());
        } else {
            System.out.println("Prikaz nenalezen: " + odpoved);
        }
    }
    /**
     * Spouští hru. Po inicializaci hraje hráč, dokud se nerozhodne hru ukončit.
     */
    public void start() {
        initialization();
        boolean exit = false;
        do {
            doIt();
        } while (!exit);
    }
    /**
     * Seznam dostupných příkazů pro hráče.
     */
    private void getPrikazy() {
        System.out.print("Prikazy: " + prikazy.keySet());
    }
    /**
     * Zobrazuje úvodní text a popis prostředí.
     * Informuje hráče o příběhu, postavách a aktuálním stavu hry.
     */
    private void vstupniText() {
        System.out.println("""
                Vítejte ve hře:\s
                ███╗   ██╗███████╗██████╗ ██████╗  █████╗ ██╗   ██╗██╗
                ████╗  ██║██╔════╝██╔══██╗██╔══██╗██╔══██╗██║   ██║██║
                ██╔██╗ ██║█████╗  ██████╔╝██████╔╝███████║██║   ██║██║
                ██║╚██╗██║██╔══╝  ██╔═══╝ ██╔══██╗██╔══██║╚██╗ ██╔╝██║
                ██║ ╚████║███████╗██║     ██║  ██║██║  ██║ ╚████╔╝ ██║
                ╚═╝  ╚═══╝╚══════╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝  ╚═╝
                                                                      \
                
                Staré venkovské sídlo se tyčilo před vámi, obklopené vysokými stromy.\
                
                Vypadalo pohádkově...\
                
                Dveře se otevřely. Stáli tam. Babička a děda. Usmívali se.
                """);

        for (Mistnost mistnost : svet.getMapa().values()) {
            if (mistnost.getPostava() != null ) {
                if(mistnost.getPostava() instanceof PraviPrarodice){
                    System.out.println(" ");
                }else{
                    System.out.println(mistnost.getPostava().komunikace("uvod") + "\nRychle seznameni -> " + mistnost.getPostava());
                }
            }
        }
        System.out.println("Ted stojiš v mistnosti: " + hrac.getAktualniMistnost().getNazev() + ". Atˇ se daří!");
    }
}