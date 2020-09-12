package utility;

public class oneTry {

    public static Object obj = null;

    public static void main(String[] args) {

        m1("Subhajit1");
        m3();

    }

    public static void m1(Object a) {

        obj = a;

    }

    public static void m2() {
        System.out.println("String is -->" + obj);
    }

    public static void m3() {
        m2();
    }
}