package hra;

import command.*;
import postavy.Postava;
import svet.Mistnost;
import svet.Svet;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Hra {
    private final Scanner sc = new Scanner(System.in);
    private final HashMap<String, Command> prikazy = new HashMap<>();
    private final Svet svet = new Svet();
    private final Hrac hrac = new Hrac();
    Mistnost aktualniMistnost = svet.getMapa().get("detska");

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
        for (Command cmd : prikazy.values()) {
            cmd.set(hrac, svet);
        }
        vstupniText();
    }

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

    public void start() {
        initialization();
        boolean exit = false;
        do {
            doIt();
        } while (!exit);
    }

    private void getPrikazy() {
        System.out.print("Prikazy: " + prikazy.keySet());
    }

    private void vstupniText() {
        System.out.println("Vítejte ve hře 'Nepraví'!" +
                "\nStaré venkovské sídlo se tyčilo před vámi, obklopené vysokými stromy." +
                "\nVypadalo pohádkově..." +
                "\nDveře se otevřely. Stáli tam. Babička a děda. Usmívali se.");

        for (Mistnost mistnost : svet.getMapa().values()) {
            if (mistnost.getPostava() != null) {
                System.out.println(mistnost.getPostava().komunikace("uvod") + "\nRychle seznameni -> " + mistnost.getPostava());
            }
        }
        System.out.println("Ted stojis v " + hrac.getAktualniMistnost().getNazev() + ". Atˇ se dari!");
    }
}

