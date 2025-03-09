import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
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
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("mangijad.txt", true), "UTF-8"))) {
            writer.println(eesNimi + "," + pereNimi + "," + kassa + "," + ostetudPiletid + "," + mangitudMangud);
        } catch (Exception e) {
            System.out.println("Viga, mängija salvestamine ebaõnnestus: " + e.getMessage());
        }
    }

    public void laeMangija(String eesNimi, String pereNimi) {
        try (Scanner scanner = new Scanner(new FileReader("mangijad.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data[0].equals(eesNimi) && data[1].equals(pereNimi)) {
                    this.eesNimi = data[0];
                    this.pereNimi = data[1];
                    this.kassa = Double.parseDouble(data[2]);
                    this.ostetudPiletid = Integer.parseInt(data[3]);
                    this.mangitudMangud = Integer.parseInt(data[4]);
                    System.out.println("Mängija andmed laetud: " + this.toString());
                    return;
                }
            }
            System.out.println("Mängijat ei leitud.");
        } catch (Exception e) {
            System.out.println("Viga, mängija laadimine ebaõnnestus: " + e.getMessage());
        }
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