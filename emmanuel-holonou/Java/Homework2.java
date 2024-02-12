import java.util.Random;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        String[] list = new String[count];

        for (int i = 0; i < count; i++) {
            char[] plate = getPlate(random);
            String plateAsString = new String(plate);

            // Compare and if not exists, add to the list
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (list[j].equals(plateAsString)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                list[i] = plateAsString;
            } else {
                i--;
            }
        }

        for (String plate : list) {
            System.out.println(plate);
        }
    }

    private static char[] getPlate(Random random) {
        char[] plate = new char[7];
        for (int i = 0; i < plate.length; i++) {
            if (i == 2 || i == 3) {
                plate[i] = getLetter(random);
            } else {
                plate[i] = getNumber(random);
            }
        }
        return plate;
    }

    private static char getNumber(Random random) {
        return (char) ('0' + random.nextInt(10));
    }

    private static char getLetter(Random random) {
        return (char) ('A' + random.nextInt(26));
    }
}
