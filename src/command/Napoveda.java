package command;

public class Napoveda extends Command {
    @Override
    public String execute() {
        return "1.Některé dveře nejsou jen tak obyčejné... K jejich otevření potřebuješ správný klíč nebo heslo." +
                "2. Ve sklepě je tma, něco by ti mohlo pomoci lépe vidět." +
                "3.Pokud chceš kontaktovat někoho venku, musíš nejprve najít způsob, jak svůj telefon oživit.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
