package postavy;

import java.util.HashMap;
/**
 * Abstraktní třída představující postavu ve hře.
 */
public abstract class Postava {
    protected String jmeno;
    protected String popis;
    protected HashMap<String, String> komunikaceMap;   //<stav,text>
    protected String stav; //napad: stav jJako enum
    /**
     * Konstruktor pro vytvoření postavy.
     * @param jmeno Jméno postavy.
     * @param popis Popis postavy.
     */
    public Postava(String jmeno, String popis) {
        this.jmeno = jmeno;
        this.popis = popis;
        this.komunikaceMap = new HashMap<>();
        this.stav = jmeno + "-" + popis;
    }


    /**
     * Přidá možnou komunikaci pro určitý stav.
     * @param stav Stav postavy.
     * @param komunikace Text komunikace.
     */
    public void pridatKomunikaci(String stav, String komunikace) {
        komunikaceMap.put(stav, komunikace);
    }
    /**
     * Vrací odpověď postavy na základě jejího stavu.
     * @param stav Stav postavy.
     * @return Text komunikace.
     */
    public String komunikace(String stav) {
        return komunikaceMap.getOrDefault(stav, "V této místnosti není žádná postava.");
    }

    public void setStav(String stav) {
        this.stav = stav;
    }

    public String getStav() {
        return stav;
    }

    public String getJmeno() {
        return jmeno;
    }

    @Override
    public String toString() {
        return jmeno + ": " + popis;
    }


}
