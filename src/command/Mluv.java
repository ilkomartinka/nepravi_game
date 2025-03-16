package command;

import postavy.Postava;
import svet.Mistnost;

public class Mluv extends Command {
    private String stav;
    @Override
    public String execute() {
        //bla bla bla
        Mistnost mistnost = hrac.getAktualniMistnost();
       // return postava.komunikace(stav);
        return "postavy zatim nechteji komunikovat :D";
    }

}
