package command;
import svet.Svet;

public class PrintMapa implements Command{
    private Svet svet = new Svet();
    @Override
    public String execute() {
        if(svet != null){
            svet.printMap();
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
