import java.util.Scanner;
import java.util.*;

public class WebFontainTest {
	public static void printList(List<Integer> arr) {
		for (int i = 0; i < arr.size(); ++i) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}
	public static void QSort(List<Integer> arr) {
		if (arr.size() <= 1)
			return;
		int elem = arr.get(0);
		int right = arr.size() - 1;
		for (int i = 1; i <= right; ++i) {
			while (arr.get(i) >= elem && i <= right) {
				int tmp = arr.get(right);
				arr.set(right, arr.get(i));
				arr.set(i, tmp);
				right--;
			}
		}
		int tmp = arr.get(right);
		arr.set(right, arr.get(0));
		arr.set(0, tmp);
		// printList(arr);
		
		QSort(arr.subList(0, right));
		QSort(arr.subList(right+1, arr.size()));
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			arr.add(sc.nextInt());
		}
		QSort(arr);
		printList(arr);
	}
}
/*
10
1 2 3 4 5 6 7 8 10 9
*/