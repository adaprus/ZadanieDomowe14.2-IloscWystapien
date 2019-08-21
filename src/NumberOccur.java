public class NumberOccur {
    private int number;
    private int countOccur;

    public NumberOccur(int number) {
        this.number = number;
        countOccur = 1;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number +
                " liczba wystąpień " + countOccur + "\n";
    }

    public int getCountOccur() {
        return countOccur;
    }

    public void setCountOccur(int countOccur) {
        this.countOccur = countOccur;
    }
}
