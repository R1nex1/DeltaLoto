import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Statistika implements Laadija, Salvestaja {
    // Statistika loogika siia
    private int mangudeArv;
    private int piletiteArv;
    private int voiduPiletiteArv;
    private int jackpotideArv;
    private int[] erinevadVoitudeArv;
    private double valjaMakstudVoidud;
    private double piletuMuugiTulu;
    private double kasum;

    private static final String FILE_PATH = "statistika.txt";

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
        // iga loosimise puhul vaja genereerida loto võidusumma jaoks mingi arv pileteid
        this.piletiteArv = piletiteArv;
    }

    public int getVoiduPiletiteArv() {
        return voiduPiletiteArv;
    }

    public void setVoiduPiletiteArv(int voiduPiletiteArv) {
        // liida kokku erinevate võitude arvud
        this.voiduPiletiteArv = voiduPiletiteArv;
    }

    public int getJackpotideArv() {
        return jackpotideArv;
    }

    public void setJackpotideArv(int jackpotideArv) {
        // siin näita hoia ainult arvu kui loosi käigus sai keegi 5 õiget numbrit, mängija kaasa arvatud
        this.jackpotideArv = jackpotideArv;
    }

    public int[] getErinevadVoitudeArv() {
        return erinevadVoitudeArv;
    }

    public void setErinevadVoitudeArv(int[] erinevadVoitudeArv) {
        // loosimise ajal math randomiga genereeri erineva arvu pallide puhul võitjate arvud siia
        this.erinevadVoitudeArv = erinevadVoitudeArv;
    }

    public double getValjaMakstudVoidud() {
        return valjaMakstudVoidud;
    }

    public void setValjaMakstudVoidud(double valjaMakstudVoidud) {
        // siia võta võitude järgi summade väljamaksed, arvesta randomiga mingi protsent sisse
        this.valjaMakstudVoidud = valjaMakstudVoidud;
    }

    public double getPiletuMuugiTulu() {
        return piletuMuugiTulu;
    }

    public void setPiletuMuugiTulu(double piletuMuugiTulu) {
        // võta piletite arv ja korruta hinnaga, sea summa siia
        this.piletuMuugiTulu = piletuMuugiTulu;
    }

    public double getKasum() {
        return kasum;
    }

    public void setKasum(double kasum) {
        // arvuta mraamatupidamise funktsioonis kõik vajalik ja sea kasum siia
        this.kasum = kasum;
    }

    public void manguArvuTostja() {
        // kui toimus loosimine tõsta mangu arvu, lihtsalt ajaloo statistika tegemiseks
        mangudeArv++;
    }

    public void raamatupidaja(double summa) {
        // uuendame loto haldurite rahalisi seise
        double  i = getPiletuMuugiTulu() + summa;
        setKasum(kasum + i - getValjaMakstudVoidud());
    }

    private String erinevadVoitudeArvToString() {
        StringBuilder voitudeArvSonedena = new StringBuilder();
        for (int i = 0; i < erinevadVoitudeArv.length; i++) {
            voitudeArvSonedena.append(erinevadVoitudeArv[i]);
            if (i < erinevadVoitudeArv.length - 1) {
                voitudeArvSonedena.append(";");
            }
        }
        return voitudeArvSonedena.toString();
    }

    private int[] parseErinevadVoitudeArv(String data) {
        String[] parts = data.split(";");
        int[] erinevadVoitudeArv = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            erinevadVoitudeArv[i] = Integer.parseInt(parts[i]);
        }
        return erinevadVoitudeArv;
    }

    public void genereeriStatistika2(int piletid) {

        // kaalud
        double kaotajadKaal = 0.448;
        double kaksKaal = 0.448;
        double kolmKaal = 0.103;
        double neliKaal = 0.00029;
        double viisKaal = 0.000001;

        int[] pallid = new int[5]; // massiiv erinevate loosimiste võitude arvude statistika jaoks

        for (int i = 0; i < piletid; i++) {
            double suva = Math.random();
            if (suva < kaotajadKaal) pallid[0]++;
            else if (suva < kaotajadKaal + kaksKaal) pallid[1]++;
            else if (suva < kaotajadKaal + kaksKaal + kolmKaal) pallid[2]++;
            else if (suva < kaotajadKaal + kaksKaal + kolmKaal + neliKaal) pallid[3]++;
            else if (suva < kaotajadKaal + kaksKaal + kolmKaal + neliKaal + viisKaal) pallid[4]++;
        }

        int praegusedVoidupiletid = pallid[1] + pallid[2] + pallid[3] + pallid[4]; // voiduPiletiteArv
        int praegujackpot = pallid[4]; // jackpotideArv
        int valjaMakse = praegusedVoidupiletid * 10; // siia vaaja mingi parem asi teha

        System.out.println("piletiteArv=" + praegusedPiletid +
                ", voiduPiletiteArv=" + praegusedVoidupiletid +
                ", jackpotideArv=" + praegujackpot +
                ", erinevadVoitudeArv=" + Arrays.toString(pallid) +
                ", valjaMakstudVoidud=" + valjaMakse);
    }

    public void genereeriStatistika() {
        setMangudeArv((int) (Math.random() * 15) + 1); // mängude arv, min 1 mäng toimunud
        setPiletiteArv((int) (Math.random() * (3500 - 2000 + 1) + 2000) * getMangudeArv()); // piletite arv
        setPiletuMuugiTulu(getPiletiteArv() * 5.0);

        // kaalud
        double kaotajadKaal = 0.448;
        double kaksKaal = 0.448;
        double kolmKaal = 0.103;
        double neliKaal = 0.00029;
        double viisKaal = 0.000001;

        int[] pallid = new int[5]; // massiiv erinevate loosimiste võitude arvude statistika jaoks

        for (int i = 0; i < getPiletiteArv(); i++) {
            double suva = Math.random();
            if (suva < kaotajadKaal) pallid[0]++;
            else if (suva < kaotajadKaal + kaksKaal) pallid[1]++;
            else if (suva < kaotajadKaal + kaksKaal + kolmKaal) pallid[2]++;
            else if (suva < kaotajadKaal + kaksKaal + kolmKaal + neliKaal) pallid[3]++;
            else if (suva < kaotajadKaal + kaksKaal + kolmKaal + neliKaal + viisKaal) pallid[4]++;
        }

        setVoiduPiletiteArv(pallid[1] + pallid[2] + pallid[3] + pallid[4]); // voiduPiletiteArv
        setJackpotideArv(pallid[4]); // jackpotideArv
        setValjaMakstudVoidud(10 * getVoiduPiletiteArv()); // siia vaaja mingi parem asi teha

        setKasum(getPiletuMuugiTulu() - getValjaMakstudVoidud());

        setErinevadVoitudeArv(pallid);
    }

    @Override
    public void laadija(Scanner laadimine) {
        try (Scanner lae = new Scanner(new File(FILE_PATH))) {
            if (lae.hasNextLine()) {
                String rida = lae.nextLine();
                String[] massiiv = rida.split(",");
                this.mangudeArv = Integer.parseInt(massiiv[0]);
                this.piletiteArv = Integer.parseInt(massiiv[1]);
                this.voiduPiletiteArv = Integer.parseInt(massiiv[2]);
                this.jackpotideArv = Integer.parseInt(massiiv[3]);
                this.erinevadVoitudeArv = parseErinevadVoitudeArv(massiiv[4]);
                this.valjaMakstudVoidud = Double.parseDouble(massiiv[5]);
                this.piletuMuugiTulu = Double.parseDouble(massiiv[6]);
                this.kasum = Double.parseDouble(massiiv[7]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Statistika fail puudub, genereerime uue statistika.");
            genereeriStatistika();
        } catch (Exception e) {
            System.out.println("Viga statistika laadimisel: " + e.getMessage());
        }
    }

    @Override
    public void salvesta(PrintWriter salvestus) {
        try (PrintWriter salvesta = new PrintWriter(new File(FILE_PATH))) {
            salvesta.println(mangudeArv + "," + piletiteArv + "," + voiduPiletiteArv + "," + jackpotideArv + ","
                    + erinevadVoitudeArvToString() + "," + valjaMakstudVoidud + "," + piletuMuugiTulu + "," + kasum);
        } catch (FileNotFoundException e) {
            System.out.println("Viga statistika faili salvestamisel.");
        }
    }

    @Override
    public String toString() {
        return "Statistika{" +
                "mangudeArv=" + mangudeArv +
                ", piletiteArv=" + piletiteArv +
                ", voiduPiletiteArv=" + voiduPiletiteArv +
                ", jackpotideArv=" + jackpotideArv +
                ", erinevadVoitudeArv=" + Arrays.toString(erinevadVoitudeArv) +
                ", valjaMakstudVoidud=" + valjaMakstudVoidud +
                ", piletuMuugiTulu=" + piletuMuugiTulu +
                ", kasum=" + kasum +
                '}';
    }
}