package functions;

public class Example1 {
  // Java does not allow "named" argument passing
  // Neither does it have "default values"
  // but can often fake defaults using overloading

  // real name of method is
  // package.class.name.arg_type.arg_type...
  // passbyvalue.Example1.addOne.int
//  public static void addOne(int x) {
//    System.out.println("adding to an int");
////    x = x + 1;
////    x += 1;
//    x++; // or ++x (also --x x--)
//  }

  public static void addOne(long l) {
    System.out.println("adding to a long");
    l++;
  }

  // passbyvalue.Example1.addOne.String
  public static void addOne(String s) {
    s += "One";
  }

  // method "overloading" (commmon in statically typed OO languages)
  // passbyvalue.Example1.addOne.StringBuilder
  public static void addOne(StringBuilder sb) {
    sb.append("One");
  }

//  public static void add(int x, int y) {
//    System.out.println("int int");
//  }
  public static void add(int x, long y) {
    System.out.println("int long");
  }

  public static void add(long x, int y) {
    System.out.println("int long");
  }

//  public static void add(long x, long y) {
//    System.out.println("long long");
//  }

  public static void main(String[] args) {
    int x = 10;
    System.out.println(x);
    addOne(x); // "pass by value"
    System.out.println(x);
    System.out.println("-------");
    String s = "Hello";
    System.out.println(s);
    addOne(s);
    System.out.println(s);
    System.out.println("-------");
    StringBuilder sb = new StringBuilder("Hello");
    System.out.println(sb);
    addOne(sb);
    System.out.println(sb);

    addOne(1);
//    add(1, 1);
//    add(1, 1);
  }
}
