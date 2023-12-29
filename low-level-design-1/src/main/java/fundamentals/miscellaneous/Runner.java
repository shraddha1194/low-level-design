package fundamentals.miscellaneous;

public class Runner {
    public static void main(String[] args) {
        TestFinalMethod t = new TestFinalMethod();
        System.out.println(t.getStatement());

        // static method of declared type is invoked - A's displayed
        StaticOne a = new StaticTwo();
        a.display();
    }
}
