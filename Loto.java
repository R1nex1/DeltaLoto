import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Loto {
    private Set<Integer> voidunumbrid; // Выигрышные номера
    private int mangijaidKokku;
    private int voidufond;
    private static final Random random = new Random();
    private int lotopiletihind;

    public Loto(int mangijaidKokku, int lotopiletihind) {
        this.mangijaidKokku = mangijaidKokku;
        this.lotopiletihind = lotopiletihind;
        this.voidufond = mangijaidKokku * lotopiletihind * 80 / 100;
        this.voidunumbrid = genereeriVoidunumbrid();
    }


    private Set<Integer> genereeriVoidunumbrid() {
        Set<Integer> numbrid = new HashSet<>();
        while (numbrid.size() < 5) {
            numbrid.add(random.nextInt(50) + 1);
        }
        System.out.println("Siin on võidunumbrid: " + numbrid);
        return numbrid;
    }

    public Set<Integer> getVoidunumbrid() {
        return voidunumbrid;
    }


}

