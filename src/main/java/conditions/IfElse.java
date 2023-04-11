package conditions;

public class IfElse {
  public static void main(String[] args) {
    int x = 99;
    // expression must be in parens, must be boolean (true or false)
    if (x > 100) {
      System.out.println("Big");
    } else {
      System.out.println("Small");
    }

//    if (x) {}

    x = -10;
//    if (x > 5) {
//      System.out.println("not tiny");
//    } else {
//      if (x > -5) {
//        System.out.println("near to zero");
//      } else {
//        System.out.println("really small (negative)");
//      }
//    }
    if (x > 5) {
      System.out.println("not tiny");
    } else if (x > -5) {
      System.out.println("near to zero");
    } else {
      System.out.println("really small (negative)");
    }
  }
}
