import java.io.PrintWriter;
import java.util.Scanner;

public class Mangija {

    // Mangija info siia
    private String eesNimi;
    private String pereNimi;
    private Double kassa;
    private int ostetudPiletid;
    private int mangitudMangud;

    public Mangija(String eesNimi, String pereNimi, Double kassa, int ostetudPiletid, int mangitudMangud) {
        this.eesNimi = eesNimi;
        this.pereNimi = pereNimi;
        this.kassa = kassa;
        this.ostetudPiletid = ostetudPiletid;
        this.mangitudMangud = mangitudMangud;
    }

    public String getEesNimi() {
        return eesNimi;
    }

    public void setEesNimi(String nimi) {
        this.eesNimi = eesNimi;
    }

    public String getPereNimi() {
        return pereNimi;
    }

    public void setPereNimi(String pereNimi) {
        this.pereNimi = pereNimi;
    }

    public Double getKassa() {
        return kassa;
    }

    public void setKassa(Double kassa) {
        this.kassa = kassa;
    }

    public int getOstetudPiletid() {
        return ostetudPiletid;
    }

    public void setOstetudPiletid(int ostetudPiletid) {
        this.ostetudPiletid = ostetudPiletid;
    }

    public int getMangitudMangud() {
        return mangitudMangud;
    }

    public void setMangitudMangud(int mangitudMangud) {
        this.mangitudMangud = mangitudMangud;
    }

    public void salvestaMangija() {
        PrintWriter mangija = new PrintWriter(System.out, true);
    }

    public void laeMangija() {
        Scanner mangija = new Scanner(System.in);
    }

    public void mangjaInfo() {
        System.out.println(getEesNimi() + " hetkeseis: " + getKassa() + "€");
    }

    @Override
    public String toString() {
        return "Mangija{" +
                "nimi='" + eesNimi + '\'' +
                ", kassa=" + kassa +
                '}';
    }
}