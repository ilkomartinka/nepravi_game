package svet;
import java.util.Objects;
public class Mistnost {
    private String name;

    public Mistnost(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mistnost mistnost = (Mistnost) o;
        return Objects.equals(name, mistnost.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
