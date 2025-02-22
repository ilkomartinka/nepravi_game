import java.util.Scanner;

public class Pohyb implements Command {

    private String aktualniMistnost;
    private Scanner sc = new Scanner(System.in);


    public Pohyb(String start) {
        this.aktualniMistnost = start;
    }

    public Pohyb() {

    }

    @Override
    public String execute() {
        System.out.println("Ted jsi v mistnosti: " + aktualniMistnost);
        System.out.println("Muzes jit do: " + Svet.svet.get(aktualniMistnost));
        String volba = sc.next();
        if (Svet.svet.containsKey(volba)) {
            Svet.svet.get(volba);
            System.out.println("ted jsi: " + volba);
        } else {
            return "nemuzes tam jit";
        }
        return "neco se pokazilo";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
