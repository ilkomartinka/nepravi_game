package postavy;

import java.util.HashMap;


public abstract class Postava {
    protected String jmeno;
    protected String popis;
    protected HashMap<String, String> komunikaceMap;

    public Postava(String jmeno, String popis) {
        this.jmeno = jmeno;
        this.popis = popis;
        this.komunikaceMap = new HashMap<>();
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
        return komunikaceMap.getOrDefault(stav, "Tato postava mlčí.");
    }
}
