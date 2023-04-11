package equality;

public class Equality {
  public static void main(String[] args) {
    int x = 10;
    int y = 10;
    int z = 11;
    System.out.println("x == y ? " + (x == y));
    System.out.println("x == z ? " + (x == z));

    String s = "Hello";
    String t = "He";
    t.toUpperCase(); // Strings are immutable!!!
    String u = t.toUpperCase(); // create a new String based on the old value plus change
    t = t + "llo";
    System.out.println("t is " + t);
    System.out.println("u is " + u);
    System.out.println("s == t " + (s == t));

    // "function" style (also "command" or "imperative" style)
    // doThis(toThat) -- Verb(Object) grammar
    // OO style "request" style
    // Dear xxx please do y to z (or yourself!)
    // xxx.y(z) -- Subject.verb(Object)
    // ask s to compare itself with t
    // NOTE equals is always valid syntax, but many objects
    // are NOT capable of meaningful content comparison
    System.out.println("s.equals(t) " + (s.equals(t)));

    StringBuilder sb1 = new StringBuilder("Hello");
    StringBuilder sb2 = new StringBuilder("Hello");
    System.out.println("sb1 is " + sb1);
    System.out.println("sb2 is " + sb2);
    System.out.println("sb1.equals(sb2) " + sb1.equals(sb2));
  }
}
