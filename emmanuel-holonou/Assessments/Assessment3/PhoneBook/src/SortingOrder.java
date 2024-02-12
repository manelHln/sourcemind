public class SortingOrder {
    public static void main(String[] args){
        System.out.println(isDescending(new int[]{6, 4, 3, 3, 1}));
        System.out.println(isDescending(new int[]{6, 4, 3, 4, 1}));
    }

    public static boolean isDescending(int[] numbers){
        return recursiveFunc(numbers, numbers.length);
    }

    public static boolean recursiveFunc(int [] arr, int size){
        if(size == 1 || size == 0)
            return true;
        if(arr[size - 1] > arr[size - 2])
            return false;

        return recursiveFunc(arr, size - 1);
    }
}