package command;

public class Konec implements Command {
    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
