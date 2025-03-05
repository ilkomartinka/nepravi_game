package command;

import predmety.Predmet;

public class Pouzij implements Command {
    private Predmet predmet;

    public Pouzij(Predmet predmet) {
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
