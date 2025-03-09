import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.FileReader;
import java.io.File;

public class Statistika {
    // Statistika loogika siia
    private int mangudeArv;
    private int piletiteArv;
    private int voiduPiletiteArv;
    private int jackpotideArv;
    private int[] erinevadVoitudeArv;
    private double valjaMakstudVoidud;
    private double piletuMuugiTulu;
    private double kasum;

    public Statistika(int mangudeArv, int piletiteArv, int voiduPiletiteArv, int jackpotideArv, int[] erinevadVoitudeArv, double valjaMakstudVoidud, double piletuMuugiTulu, double kasum) {
        this.mangudeArv = mangudeArv;
        this.piletiteArv = piletiteArv;
        this.voiduPiletiteArv = voiduPiletiteArv;
        this.jackpotideArv = jackpotideArv;
        this.erinevadVoitudeArv = erinevadVoitudeArv;
        this.valjaMakstudVoidud = valjaMakstudVoidud;
        this.piletuMuugiTulu = piletuMuugiTulu;
        this.kasum = kasum;
    }

    public int getMangudeArv() {
        return mangudeArv;
    }

    public void setMangudeArv(int mangudeArv) {
        this.mangudeArv = mangudeArv;
    }

    public int getPiletiteArv() {
        return piletiteArv;
    }

    public void setPiletiteArv(int piletiteArv) {
        this.piletiteArv = piletiteArv;
    }

    public int getVoiduPiletiteArv() {
        return voiduPiletiteArv;
    }

    public void setVoiduPiletiteArv(int voiduPiletiteArv) {
        this.voiduPiletiteArv = voiduPiletiteArv;
    }

    public int getJackpotideArv() {
        return jackpotideArv;
    }

    public void setJackpotideArv(int jackpotideArv) {
        this.jackpotideArv = jackpotideArv;
    }

    public int[] getErinevadVoitudeArv() {
        return erinevadVoitudeArv;
    }

    public void setErinevadVoitudeArv(int[] erinevadVoitudeArv) {
        this.erinevadVoitudeArv = erinevadVoitudeArv;
    }

    public double getValjaMakstudVoidud() {
        return valjaMakstudVoidud;
    }

    public void setValjaMakstudVoidud(double valjaMakstudVoidud) {
        this.valjaMakstudVoidud = valjaMakstudVoidud;
    }

    public double getPiletuMuugiTulu() {
        return piletuMuugiTulu;
    }

    public void setPiletuMuugiTulu(double piletuMuugiTulu) {
        this.piletuMuugiTulu = piletuMuugiTulu;
    }

    public double getKasum() {
        return kasum;
    }

    public void setKasum(double kasum) {
        this.kasum = kasum;
    }

    public void manguArvuTostja() {
        mangudeArv++;
    }

    public void raamatupidaja(double summa) {
        // uuendame loto haldurite rahalisi seise
        double  i = getPiletuMuugiTulu() + summa;
        setKasum(kasum + i - getValjaMakstudVoidud());
    }


    public void salvestaStatistika() {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("statistika.txt", false), "UTF-8"))) {
            writer.println(mangudeArv + "," + piletiteArv + "," + voiduPiletiteArv + "," + jackpotideArv + "," + valjaMakstudVoidud + "," + piletuMuugiTulu + "," + kasum);
        } catch (Exception e) {
            System.out.println("Viga, statistika salvestamine ebaõnnestus: " + e.getMessage());
        }
    }

    public void laeStatistika() {
        try (Scanner scanner = new Scanner(new FileReader("statistika.txt"))) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                this.mangudeArv = Integer.parseInt(data[0]);
                this.piletiteArv = Integer.parseInt(data[1]);
                this.voiduPiletiteArv = Integer.parseInt(data[2]);
                this.jackpotideArv = Integer.parseInt(data[3]);
                this.valjaMakstudVoidud = Double.parseDouble(data[4]);
                this.piletuMuugiTulu = Double.parseDouble(data[5]);
                this.kasum = Double.parseDouble(data[6]);
                System.out.println("Statistika andmed laetud.");
            }
        } catch (Exception e) {
            System.out.println("Viga, statistika laadimine ebaõnnestus: " + e.getMessage());
        }
    }
}