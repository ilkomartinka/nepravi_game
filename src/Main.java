import hra.Hra;

public class Main {
    public static void main(String[] args) {
        try{
            Hra c = new Hra();
            c.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
