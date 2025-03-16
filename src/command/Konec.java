package command;

public class Konec extends Command {
    @Override
    public String execute() {
        System.out.println("Emil se rozhodl přestat pátrat. Tajemství domu zůstává neodhalené. " +
                "\nKdyž odchází, cítí na zádech chladný pohled... nebo se mu to jen zdá?\n" +
                "\nHra ukončena. Pravda zůstává skrytá.");
        System.exit(0);
        return " ";
    }
}
