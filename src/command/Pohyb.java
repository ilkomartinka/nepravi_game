package command;
import svet.Mistnost;
import java.util.Scanner;

public class Pohyb extends Command {
    private Scanner sc = new Scanner(System.in);

    public Pohyb() {
    }

    @Override
    public String execute() {
        Mistnost aktualniMistnost = hrac.getAktualniMistnost();
        System.out.println("Ted jsi v mistnosti: " + aktualniMistnost);
        System.out.println("Muzes jit do: " + svet.moznostPohybu(aktualniMistnost));
        System.out.print("Pujdu do: ");
        String volba = sc.next();
        Mistnost zvolenaMist = new Mistnost(volba);
        if (svet.moznostPohybu(aktualniMistnost).contains(zvolenaMist)) {
            if (volba.equals("tajna") || volba.equals("sklep")) {
                System.out.println("Zamceno, mas klic/heslo? (A/N)");
                String odpoved = sc.next();
                switch (odpoved) {
                    case "A":
                        System.out.println("Tak ho pouzij");
                    case "N":
                        System.out.println("Nedostanes se sem");
                }
            }
            hrac.setAktualniMistnost(zvolenaMist);
        } else {
            System.out.println("Chybicka");
        }
        return "Ted se nachazis v -> " + hrac.getAktualniMistnost();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
