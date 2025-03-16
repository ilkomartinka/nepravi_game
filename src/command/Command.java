package command;

import hra.Hrac;
import svet.Svet;

public abstract class Command {
    protected Hrac hrac;
    protected Svet svet;

   public void set(Hrac hrac, Svet svet) {
       this.hrac = hrac;
       this.svet = svet;
   };

    public abstract String execute();
}
