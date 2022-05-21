public class OffByN implements CharacterComparator {
    private final int n;

    public OffByN(int N) {
        this.n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int intx = x;
        int inty = y;
        return Math.abs(intx - inty) == n;
    }
}
