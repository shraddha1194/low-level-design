package fundamentals.exceptionHandling;

public class StringRunner {
    String str = "a";

    public static void main(String[] args) {
        StringRunner object = new StringRunner();
        object.A();
        object.display();
    }

    void A() {
        try { str +="b";
            B();
        } catch (Exception e) {
            str += "c";
        }
        str += "g";
    }
    void B() throws Exception {
        try {
            str += "d"; C();
        } catch(Exception e) {
            throw new Exception();
        } finally {
            str += "e";
        }
        str += "f";
    }
    void C() throws Exception {
        throw new Exception();
    }
    void display() {
        System.out.println(str);
    }
}
