import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Svet {
   public static HashMap<Mistnost, ArrayList<String>> svet = new HashMap<>();

    public Svet(){
        nacteniMapy();
    }

    private void nacteniMapy() {
        try (BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] mistnosti = line.split(" ");
                Mistnost mistnost = new Mistnost(mistnosti[0]);
                ArrayList<String> mistnostiVedle = new ArrayList<>(Arrays.asList(mistnosti).subList(1, mistnosti.length));
                svet.put(mistnost,mistnostiVedle);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

















    /*private HashMap<String, ArrayList<String>> svet = new HashMap<>();

    public Svet() throws IOException {
        nacteniMapy();
    }

    private void nacteniMapy() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] mistnosti = line.split(" ");
                ArrayList<String> mistnostiVedle = new ArrayList<>(Arrays.asList(mistnosti).subList(1, mistnosti.length));
                svet.put(mistnosti[0], mistnostiVedle);}
            }
        }*/



    @Override
    public String toString() {
        return "Svet: " + svet;
    }
}


