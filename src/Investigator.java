import java.util.Objects;

public class Investigator {

    private String name;
    private String rank;

    public Investigator(String name, String rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public void displayInfo() {
        System.out.println("Investigator: " + name);
        System.out.println("Rank: " + rank);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Investigator other = (Investigator) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}