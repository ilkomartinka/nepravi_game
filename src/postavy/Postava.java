package postavy;

import java.util.HashMap;

public abstract class Postava {
    protected String jmeno;
    protected String popis;
    protected HashMap<String, String> komunikaceMap;
    protected String stav;

    public Postava(String jmeno, String popis) {
        this.jmeno = jmeno;
        this.popis = popis;
        this.komunikaceMap = new HashMap<>();
        this.stav = jmeno + "-" + popis;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPopis() {
        return popis;
    }

    public void pridatKomunikaci(String stav, String komunikace) {
        komunikaceMap.put(stav, komunikace);
    }

    public String komunikace(String stav) {
        return komunikaceMap.getOrDefault(stav, "...");
    }

    public void setStav(String stav) {
        this.stav = stav;
    }

    public String getStav() {
        return stav;
    }

    @Override
    public String toString() {
        return jmeno + ": " + popis;
    }


}
