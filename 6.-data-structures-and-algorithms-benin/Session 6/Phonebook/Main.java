import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        var map = new TreeMap<PhoneNumber, Person>();

        var p1 = new Person("Shira", "G.");
        var p2 = new Person("Pierre", "A.");
        var p3 = new Person("Gaston", "L.");


        var n1 = new PhoneNumber("+22987452136", PhoneCategory.HOME);
        var n2 = new PhoneNumber("+22966621354", PhoneCategory.MOBILE);
        var n3 = new PhoneNumber("+22841236588", PhoneCategory.OFFICE);
        var n4 = new PhoneNumber("+22187653698", PhoneCategory.MOBILE);
        var n5 = new PhoneNumber("+22745214856", PhoneCategory.HOME);
        var n6 = new PhoneNumber("+22354823651", PhoneCategory.HOME);
        var n7 = new PhoneNumber("+22595957700", PhoneCategory.HOME);

        p1.addNumber(n1);
        p1.addNumber(n2);
        map.put(n1, p1);
        map.put(n2, p1);

        p2.addNumber(n3);
        map.put(n3, p2);
        p2.addNumber(n4);
        p2.addNumber(n5);

        p3.addNumber(n6);

        var p = map.get(n1);
        System.out.println(p);

        map.replace(n3, p2, p3);
        System.out.println(map.get(n3));
    }
}
