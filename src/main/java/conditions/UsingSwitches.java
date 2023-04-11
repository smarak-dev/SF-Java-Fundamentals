package conditions;

public class UsingSwitches {
//  public static String getMonthName(int m) {
//    switch (m) {
//      case 1: return "January";
//      case 2: return "February";
//      //
//      case 12: return "December";
//      default: return "oops, that's not a month!";
//    }
//  }

//  public static String getMonthName(int m) {
//    String name;
//    switch (m) {
//      // "alternation" (providing alternatives) using many cases in a row
//      case -2:
//      case -1:
//      case 0:
//        System.out.println("oops, I'll assume you meant one!");
//      case 1:
//        name = "January";
//        break;
//      case 2:
//        name = "February";
//        break;
//      case 12:
//        name = "December";
//        break;
//      default:
//        name = "oops, that's not a month!";
//        break;
//    }
//    return name;
// }
//  public static String getMonthName(int m) {
//    String name;
//    switch (m) {
//      case -1, 0 -> name = "Weird, that's too small";
//      case 1 -> {
//        System.out.println("found January!");
//        if (Math.random() > 0.5) break; // only in statement form of arrow
//        name = "January";
//      }
//      case 2 -> name = "February";
//      //
//      case 12 -> name = "December";
//      default -> name = "oops, that's not a month!";
//    }
//    return name;
//  }

  public static String getMonthName(int m) {
    return switch (m) {
      case -1, 0 -> "Weird, that's too small";
      case 1 -> {
        System.out.println("found January!");
        yield "January";
      }
      case 2 -> "February";
      //
      case 12 -> "December";
      default -> "oops, that's not a month!";
    };
  }

  public static void main(String[] args) {
    System.out.println("month 1 is called " + getMonthName(1));
    System.out.println("month 2 is called " + getMonthName(2));
    System.out.println("month -1 is called " + getMonthName(-1));
  }
}
