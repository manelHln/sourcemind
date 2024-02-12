public class PhoneNumber implements Comparable<PhoneNumber> {

    private long value;
    private String number;
    private PhoneCategory category;

    public PhoneNumber(String number, PhoneCategory category) {
        this.number = number;
        this.category = category;
        this.value = Long.parseLong(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return this.number == that.number && this.category == that.category;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public String toString() {
        return category.name() + " : " + number;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        return (int) (this.value - o.value);
    }
}
