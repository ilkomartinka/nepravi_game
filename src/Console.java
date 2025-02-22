import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private Scanner sc = new Scanner(System.in);
    private HashMap<String, Command> prikazy = new HashMap<>();


    private boolean exit = false;


    public void inicialization() {
        prikazy.put("pohyb", new Pohyb("detska"));
    }

    public void doIt() throws IOException {
        Svet svet = new Svet();
        System.out.println(svet);
        System.out.println("> ");
        String odpoved = sc.nextLine();
        if (prikazy.containsKey(odpoved)) {
            System.out.println("> " + prikazy.get(odpoved).execute());
        }
    }

    public void start() throws IOException {
        inicialization();
        do{
            doIt();
        }while(!exit);

    }

}
