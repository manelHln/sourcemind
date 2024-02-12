import java.util.Arrays;
import java.util.Vector;

public class Subset {
    public static void main(String[] args) {
        String[] heroes = {"Gohan", "Sasuke", "Zoro", "Mash", "Kurama"};
        printSubsets(heroes);
    }

    static void printSubsets(String set[]) {
        int n = set.length;
        for (int i = 0; i < (1 << n); i++) {
            var v = new Vector<String>(); 

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    v.add(set[j]);
                }
            }
            System.out.println(Arrays.toString(v.toArray()));
        }
    }
}
