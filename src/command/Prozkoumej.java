package command;

import svet.Mistnost;

public class Prozkoumej implements Command{
    private Mistnost mistnost;

    public Prozkoumej(Mistnost mistnost) {
        this.mistnost = mistnost;
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
