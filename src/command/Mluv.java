package command;

import postavy.Postava;

public class Mluv extends Command {
    private Postava postava;
    private String stav;

    public Mluv(Postava postava, String stav) {
        this.postava = postava;
        this.stav = stav;
    }

    @Override
    public String execute() {
        //bla bla bla
        return postava.komunikace(stav);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
