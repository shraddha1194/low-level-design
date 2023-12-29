package fundamentals.generics.worksheet_1;

public class Pair2<TYPE> {
    private TYPE left;
    private TYPE right;

    public Pair2(TYPE left, TYPE right) {
        this.left = left;
        this.right = right;
    }

    public TYPE getLeft() {
        return left;
    }

    public TYPE getRight() {
        return right;
    }

}
