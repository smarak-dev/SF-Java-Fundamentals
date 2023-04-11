package labs;

public class Zeller {

  public static int zeller(int day, int month, int year) {
//    int m = month;
//    int y = year;
//    if (m < 3) {
//      m = m + 12;
//      y = y - 1;
//    }

    int m = (month < 3) ? month + 12 : month;
    int y = (month < 3) ? year - 1 : year;

    return (day + 13 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;

//    if (Math.random() > -1) {
//      return 9;
//    }
  }

  public static void main(String[] args) {
    int day = 11;
    int month = 4;
    int year = 2023;
    // compute day of week
    // print it


//    zeller(11, 4, 2023)
    int dayOfWeek = zeller(day, month, year);
    System.out.println("day of week is number " + dayOfWeek);
  }
}
