package command;
import svet.Mistnost;
import svet.Svet;
import java.util.Scanner;

public class Pohyb implements Command {
    private Scanner sc = new Scanner(System.in);
    private Svet svet = new Svet();
    Mistnost aktualniMistnost = new Mistnost("detska");

    @Override
    public String execute() {
        System.out.println("Ted jsi v mistnosti: " + aktualniMistnost);
        System.out.println("Muzes jit do: " + svet.moznostPohybu(aktualniMistnost));
        System.out.print("Pujdu do: ");
        String volba = sc.next();
        Mistnost zvolenaMist = new Mistnost(volba);
        if (svet.moznostPohybu(aktualniMistnost).contains(zvolenaMist)) {
            if (volba.equals("tajna") || volba.equals("sklep")) {
                System.out.println("Zamceno, mas pomocny predmet? A/N");
                String odpoved = sc.next();
                switch (odpoved){
                    case "A":

                    case "N":
                        System.out.println("Nedostanes se sem");
                }
            }else{
                aktualniMistnost = zvolenaMist;
            }
        }else{
            System.out.println("Chybicka");
        }
        return "Ted se nachazis v -> " + aktualniMistnost;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
