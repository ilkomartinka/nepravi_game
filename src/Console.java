import command.Command;
import command.Pohyb;
import command.PrintMapa;
import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private Scanner sc = new Scanner(System.in);
    private HashMap<String, Command> prikazy = new HashMap<>();
    private boolean exit = false;

    public void inicialization() {
        prikazy.put("pohyb", new Pohyb());
        prikazy.put("mapa", new PrintMapa());
    }

    public void doIt() {
        getPrikazy();
        System.out.print("\n> ");
        String odpoved = sc.next();
        if (prikazy.containsKey(odpoved)) {
            System.out.println(prikazy.get(odpoved).execute());
        } else {
            System.out.println("Prikaz nenajden: " + odpoved);
        }
    }

    public void start() {
        inicialization();
        do {
            doIt();
        } while (!exit);
    }

    private void getPrikazy() {
        System.out.print("Prikazy: " + prikazy.keySet());
    }
}
