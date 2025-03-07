import java.io.PrintWriter;
import java.util.Scanner;

public class Mangija {

    // Mangija info siia
    private String nimi;
    private Double kassa;

    public Mangija(String nimi, Double kassa) {
        this.nimi = nimi;
        this.kassa = kassa;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Double getKassa() {
        return kassa;
    }

    public void setKassa(Double kassa) {
        this.kassa = kassa;
    }

    public void salvestaMangija() {
        PrintWriter mangija = new PrintWriter(System.out, true);
    }

    public void laeMangija() {
        Scanner mangija = new Scanner(System.in);
    }

    @Override
    public String toString() {
        return "Mangija{" +
                "nimi='" + nimi + '\'' +
                ", kassa=" + kassa +
                '}';
    }
}