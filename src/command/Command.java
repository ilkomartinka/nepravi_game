package command;

import hra.Hrac;
import svet.Svet;
/**
 * Reprezentuje příkaz ve hře.
 * Každý příkaz implementuje metodu {@link #execute()}.
 * Tato třída obsahuje referenci na objekt hráče ({@link Hrac}) a svět ({@link Svet}),
 * které mohou být použity při vykonávání příkazu.
 */
public abstract class Command {
    protected Hrac hrac;
    protected Svet svet;
    /**
     * Nastaví objekty hráč a svět pro tento příkaz.
     *
     * @param hrac Hráč, který provádí příkaz.
     * @param svet Herní svět, ve kterém se příkaz vykonává.
     */
   public void set(Hrac hrac, Svet svet) {
       this.hrac = hrac;
       this.svet = svet;
   }
    /**
     * Abstraktní metoda, která vykoná příkaz.
     * Definovat konkrétní chování příkazu.
     * @return výsledek provedení příkazu.
     */
    public abstract String execute();
}
