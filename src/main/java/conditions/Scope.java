package conditions;

public class Scope {
  public static void main(String[] args) {
    int month = 2;

    int m = month;
    if (month < 3) {
      m = month + 12;
      // year too :)
      System.out.println("(inside 'if'): m is " + m);
//    } else {
//      m = month;
    }
    // more calculations
    System.out.println("Month is " + m);
  }
}
