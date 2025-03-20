package command;

import postavy.NepraviPrarodice;
import postavy.Postava;
import postavy.Segra;
import svet.Mistnost;

public class Mluv extends Command {

    @Override
    public String execute() {
        Mistnost mistnost = hrac.getAktualniMistnost();
        if (mistnost != null) {
            Postava postava = mistnost.getPostava();
            if (postava instanceof NepraviPrarodice) {
                return ((NepraviPrarodice) postava).ziskatNahodnouRepliku();
            } else if (postava instanceof Segra) {
                Segra segra = (Segra) postava;
                String odpoved = segra.komunikace(segra.getStav());
                segra.nastavNovyStav();
                return odpoved;
            } else if(hrac.getAktualniMistnost().getNazev().equals("sklep")){
                mistnost.getPostava().toString();
                mistnost.getPostava().komunikace(postava.getStav());
            }else {
                return "V této místnosti není nikdo, kdo by s tebou mluvil.";
            }
        }
        return "Nemůžeš mluvit";
    }
}
