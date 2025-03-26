package command;
/**
 * Třída {@code PrintMapa} představuje příkaz, který vypíše aktuální mapu světa.
 */
public class PrintMapa extends Command{
    /**
     * Provádí zobrazení mapy světa.
     * Pokud je nastaven objekt {@code Svet}, vrátí textový výpis mapy.
     * @throws IllegalStateException pokud objekt Svet není nastaven.
     */
    @Override
    public String execute() {
        if(svet != null){
           return svet.printMapa();
        }else{
            throw new IllegalStateException("Svet není nastaven. Mapa nemůže být zobrazená.");
        }
    }
}
