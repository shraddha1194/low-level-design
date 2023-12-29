package fundamentals.generics.worksheet_1;


public class Pair3<LEFT_TYPE, RIGHT_TYPE> {

    private LEFT_TYPE left;
    private RIGHT_TYPE right;

    public Pair3(LEFT_TYPE left, RIGHT_TYPE right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException("Left or Right value cannot be null");
        }
        this.left = left;
        this.right = right;
    }

    public LEFT_TYPE getLeft() {
        return left;
    }

    public RIGHT_TYPE getRight() {
        return right;
    }

    public Pair3 swap(Pair3 p) {
        return new Pair3<>(p.getRight(), p.getLeft());
    }
}
