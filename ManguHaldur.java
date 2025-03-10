public class ManguHaldur {
    public static void main(String[] args) {
        Loto loto = new Loto(100, 10);
        System.out.println("Võidunumbrid: " + loto.getVoidunumbrid()); // Call on object, not class
    }
}
