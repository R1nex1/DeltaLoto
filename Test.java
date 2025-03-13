import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file = new File("statistika.txt");
        if (file.exists()) {
            file.delete();
        }

        Statistika lotoStats = new Statistika(0, 0, 0, 0, new int[5], 0.0, 0.0, 0.0);

        for (int i = 0; i < 10; i++) {
            lotoStats.genereeriStatistika();
            System.out.println(lotoStats);
        }
    }
}