package command;
/**
 * Třída {@code Konec}, která ukončí hru.
 */
public class Konec extends Command {
    /**
     * Po provedení tohoto příkazu hra vypíše zprávu a ukončí běh programu.
     * @return Vráti prázdný řetězec, ale hra okamžitě skončí díky volání {@link System#exit(int)}.
     */
    @Override
    public String execute() {
        System.out.println("Emil se rozhodl přestat pátrat. Tajemství domu zůstává neodhalené. " +
                "\nKdyž odchází, cítí na zádech chladný pohled... nebo se mu to jen zdá?\n" +
                "\nHra ukončena. Pravda zůstává skrytá.");
        System.exit(0);
        return " ";  // Tento řadek se nikdy neprovede, protože aplikace je okamžitě ukončena
    }
}
