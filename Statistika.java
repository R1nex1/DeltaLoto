import java.io.PrintWriter;
import java.util.Scanner;

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

    public void manguStatistikaSalvesti () {
        PrintWriter statistika = new PrintWriter(System.out, true);
    }

    public void manguStatistikaLaadija () {
        Scanner statistika = new Scanner(System.in);
    }
}