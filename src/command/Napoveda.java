package command;

public class Napoveda extends Command {
    private int index = 0;
    private final String[] napovedy = {
            "1. Ne všechno je na očích. Zkus prozkoumat okolí.",
            "2. Ne každý zápisník obsahuje jen nudné poznámky.",
            "3. K otevření nekterych dveři potřebuješ správný klíč nebo heslo.",
            "4. Ve sklepě je tma, něco by ti mohlo pomoci lépe vidět.",
            "5. Pokud chceš kontaktovat někoho venku, musíš nejprve najít způsob, jak opravit telefon.",

    };

    @Override
    public String execute() {
        if (index < napovedy.length) {
            return napovedy[index++]; // Vrátí aktuální nápovědu a zvýší index
        } else {
            return "Žádné další nápovědy nejsou k dispozici.";
        }
    }
}
