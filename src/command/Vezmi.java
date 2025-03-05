package command;
import predmety.Predmet;
public class Vezmi implements Command{
    private Predmet predmet;

    public Vezmi(Predmet predmet) {
        this.predmet = predmet;
    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
