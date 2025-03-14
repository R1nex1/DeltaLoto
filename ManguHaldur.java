public class ManguHaldur {

    // valib piletite arvu

    // numbrite valimise funktsioon

    // suvaliste numbrite valimise funktsioon kui mängija ise ei vali


    public static void main(String[] args) {
        int[] voidunumbrid = Loto.manguloosimine();
        System.out.println("Võidunumbrid on : ");
        for (int num : voidunumbrid) {
            System.out.print(num + " ");


        }
    }
}
