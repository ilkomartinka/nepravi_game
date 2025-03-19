package command;

public class Napoveda extends Command {
    private int index = 0;
    private final String[] napovedy = {
            "1. Ne všechno je na očích. Zkus prozkoumat okolí.",
            "2. Ne každý zápisník obsahuje jen nudné poznámky.",
            "3. K otevření nekterych dveři potřebuješ správný klíč nebo heslo.",
            "4. Ve sklepě je tma, něco by ti mohlo pomoci lépe vidět.",
            "5. Pokud chceš kontaktovat někoho venku, musíš nejprve najít způsob, jak opravit telefon.",
            "6. Prarodiče se občas přeřeknou... poslouchej je pozorně.",
            "7. Zámek může jít obejít i jinak než klíčem… co třeba kód?",
            "8. Když se nemůžeš dostat dál, vrať se zpátky. Možná ti něco uniklo."
    };

    @Override
    public String execute() {
        if (index < napovedy.length) {
            return napovedy[index++];
        } else {
            return "Žádné další nápovědy nejsou k dispozici.";
        }
    }
}
