import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
public class Loto {
    private Set<Integer> voidunumbrid  = new HashSet<>();
    private int mangijaidKokku;
    private int voidufond;
    private static final Random random = new Random();
    private int lotopiletihind;

    public Loto(Set<Integer> voidunumbrid, int mangijaidKokku, int voidufond, int lotopiletihind) {
        this.voidunumbrid = voidunumbrid;
        this.mangijaidKokku = mangijaidKokku;
        this.lotopiletihind = lotopiletihind;
        this.voidufond = mangijaidKokku * lotopiletihind * 80 /100;

    }

    public static int[] manguloosimine() { // valime 5 suvalist numbrit 1-50ni
        int[] voidunumbrid = new int[5];
        for (int i = 0; i < 5; i++) {
            voidunumbrid[i] = random.nextInt(50) + 1;
        }
        return voidunumbrid;
    }

    public static void main(String[] args) {
        System.out.println(manguloosimine());
    }

    // Siia loto mängu loogika
}

 */

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
        return numbrid;
    }

    public Set<Integer> getVoidunumbrid() {
        return voidunumbrid;
    }


}

