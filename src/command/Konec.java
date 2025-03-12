package command;

public class Konec extends Command {
    @Override
    public String execute() {
        return "Konec hry";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
