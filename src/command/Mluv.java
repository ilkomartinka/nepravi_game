package command;

import svet.Postava;

public class Mluv implements Command {
    private Postava postava;

    public Mluv(Postava postava) {
        this.postava = postava;
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
