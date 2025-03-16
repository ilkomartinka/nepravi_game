package command;
public class PrintMapa extends Command{

    @Override
    public String execute() {
        if(svet != null){
           return svet.printMapa();
        }
        return "";
    }
}
