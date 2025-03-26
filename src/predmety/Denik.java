package predmety;
/**
 * Předmět reprezentující deník s důležitými informacemi.
 */
public class Denik extends Predmet {
    public Denik() {
        super("denik");
    }

    @Override
    public String pouziti() {
        return """
                Dnes venku panuje krásné počasí, slunce svítí a já se těším z ticha našeho malého domku. \
                
                Ale dnes jsem zažila něco podivného. Z ničeho nic k nám přišli nějací lidé – paní a pán, kteří tvrdili, že jsou sousedé. \
                
                Chtěli se s námi seznámit, ale jejich chování bylo tak zvláštní.\
                
                Jejich oči, plné neklidu, mě celou dobu sledovaly, jakoby měli nějaký tajemný úmysl.\
                
                Zůstali jen chvíli, ale ten pocit, že něco není v pořádku, mě stále pronásleduje. Chtěli, abychom se s nimi lépe seznámili, \
                
                Vím, že asi přeháním, možná je to jen moje přecitlivělost. Těším se ale na naše děti, které brzy přijedou. S manželem už se na ně moc těšíme.\
                
                Snad to byla jen nějaká zbytečná obava. Doufám, že jim nic nehrozí. To je všechno, co si přeji – klidný domov, kam se budou moci vrátit.""";
    }

}
