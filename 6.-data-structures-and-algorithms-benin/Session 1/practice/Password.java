import java.util.Arrays;

public class Password {
    public static String leak = "afh9";

    public static void main(String[] args) {
        var chars = toSortedArray(leak);
        boolean b = true;
        int n = 0;

        while (b) {
            n += 1;
            System.out.println(new String(chars));
            b = nextPermutation(chars);
        }
        System.out.println("Count: "+ n);
    }

    public static char[] toSortedArray(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return chars;
    }

    // See https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    public static boolean nextPermutation(char[] array) {
        var i = array.length - 1;

        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        var j = array.length - 1;

        while (array[j] <= array[i - 1]) {
            j--;
        }

        var temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;

        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
