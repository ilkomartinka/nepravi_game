package command;

import postavy.Postava;
import svet.Mistnost;

public class Mluv extends Command {

    @Override
    public String execute() {
        Mistnost mistnost = hrac.getAktualniMistnost();
        if (mistnost != null) {
            Postava postava = mistnost.getPostava();
            if (postava != null) {
                return postava.komunikace(postava.getStav());
            } else {
                return "V této místnosti není nikdo, kdo by s tebou mluvil.";
            }
        }
        return "Nemůžeš mluvit, protože nejsi v místnosti.";
    }
}


