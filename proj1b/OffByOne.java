public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int intx = x;
        int inty = y;
        return Math.abs(intx - inty) == 1;
    }
}
