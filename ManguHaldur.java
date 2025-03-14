import java.util.*;

public class ManguHaldur {
    private static final Random random = new Random();
    private static int ticketCounter = 1; // Unikaalne piletite ID loendur


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int piletiteArv = (int) (Math.random() * (3500 - 2000 + 1) + 2000);

        // Küsimus kasutajale: mitu Eurojackpoti piletit soovitakse osta?
        System.out.print("Mitu Eurojackpoti piletit soovite osta? ");
        int ticketCount = scanner.nextInt();
        scanner.nextLine(); // Tarbitakse newline (rea vahetus)

        List<Map<Integer, Set<Integer>>> tickets = new ArrayList<>(); // Piletite hoidmiseks

        /*
        // Loositakse välja võidunumbrid kasutades Loto.java
        System.out.println("\nLoositakse võidunumbrid...");
        Loto lotoGame = new Loto(ticketCount, 5); // Eeldame, et pileti hind on 5
        Set<Integer> winningNumbers = lotoGame.getVoidunumbrid();
        System.out.println("Võidunumbrid: " + winningNumbers);

         */

        // Kasutajalt küsitakse, kas ta soovib numbreid käsitsi valida või lasta arvutil need genereerida
        for (int i = 0; i < ticketCount; i++) {
            System.out.println("\nPilet #" + ticketCounter);
            System.out.print("Kas soovite numbreid ise valida? (jah/ei): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            Set<Integer> userNumbers = new HashSet<>();

            if (choice.equals("jah")) {
                userNumbers = getUserNumbers(scanner); // Kasutaja sisestab numbrid käsitsi
            } else {
                userNumbers = generateRandomNumbers(); // Arvuti genereerib numbrid juhuslikult
            }

            // Salvestame pileti koos unikaalse ID-ga
            Map<Integer, Set<Integer>> ticket = new HashMap<>();
            ticket.put(ticketCounter, userNumbers);
            tickets.add(ticket);

            System.out.println("Pilet #" + ticketCounter + " valitud numbrid: " + userNumbers);
            ticketCounter++;
        }


        // Loositakse välja võidunumbrid kasutades Loto.java
        System.out.println("\nLoositakse võidunumbrid...");
        Loto lotoGame = new Loto(ticketCount, 5); // Eeldame, et pileti hind on 5
        Set<Integer> winningNumbers = lotoGame.getVoidunumbrid();
        System.out.println("Võidunumbrid: " + winningNumbers);



        // Võrdleme kasutaja piletite numbreid võidunumbritega
        for (Map<Integer, Set<Integer>> ticket : tickets) {
            for (Map.Entry<Integer, Set<Integer>> entry : ticket.entrySet()) {
                int ticketID = entry.getKey();
                Set<Integer> userNums = entry.getValue();
                Set<Integer> matchedNumbers = new HashSet<>(userNums);
                matchedNumbers.retainAll(winningNumbers); // Leiame kattuvad numbrid

                // Kuvame tulemused
                System.out.println("\nPilet #" + ticketID + " tulemused:");
                System.out.println("Teie numbrid: " + userNums);
                System.out.println("Kokkuvõte: " + matchedNumbers.size() + " vastavat numbrit!");
                System.out.println("Sobivad numbrid: " + matchedNumbers);
            }
        }
        scanner.close();

        System.out.println();
        Statistika taust = new Statistika(0, 0, 0, 0, new int[5], 0, 0, 0);
        taust.genereeriStatistika2(piletiteArv);
    }

    // Meetod kasutajalt numbrite küsimiseks
    private static Set<Integer> getUserNumbers(Scanner scanner) {
        Set<Integer> numbers = new HashSet<>();
        System.out.println("Sisestage 5 unikaalset numbrit vahemikus 1-50:");

        while (numbers.size() < 5) {
            System.out.print("Sisestage number: ");
            int num = scanner.nextInt();
            scanner.nextLine(); // Tarbitakse newline

            if (num >= 1 && num <= 50) {
                if (!numbers.contains(num)) {
                    numbers.add(num);
                } else {
                    System.out.println("See number on juba valitud! Proovige uuesti.");
                }
            } else {
                System.out.println("Vale vahemik! Palun sisestage number vahemikus 1-50.");
            }
        }
        return numbers;
    }



    // Meetod juhuslike numbrite genereerimiseks
    private static Set<Integer> generateRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 5) {
            numbers.add(random.nextInt(50) + 1);
        }
        return numbers;
    }
}
