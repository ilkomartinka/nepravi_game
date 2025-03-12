package command;
public class PrintMapa extends Command{

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
