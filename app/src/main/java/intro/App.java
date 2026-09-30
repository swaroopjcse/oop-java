package intro; // you can remove this line for now

// Make sure your .java file name and the class name match. Otherwise, you will get a compilation error.
public class App {
    public static void main(String[] args) {
        String s1 = "BITSGoa";
        String s2 = "BI" + "TS";
        String s3 = s1.substring(0, 4);
        // s3 = s1 + s2;

        System.out.println("s1: " + s1 + ", s2: " + s2 + ", s3: " + s3);
        System.out.println("s2 == s3: " + (s2 = s3));
        System.out.println("s2.equals(s3): " + s2.equals(s3));
    }
}
