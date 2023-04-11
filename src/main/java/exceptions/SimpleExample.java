package exceptions;

import java.util.ArrayList;

public class SimpleExample {
  // IllegalArgumentException and IndexOutOfBoundsException
  // represent bugs!!! They are "unchecked" / RuntimeException
  public static String getMonthName(int m) {
    if (m < 1 || m > 12) {
      throw new IllegalArgumentException("Bad month number: " + m);
    }
    ArrayList<String> names = new ArrayList();
    names.add("January");
    names.add("February");
    names.add("March");
    names.add("April");
    names.add("May");
    names.add("June");
    names.add("July");
    names.add("August");
    names.add("September");
    names.add("October");
    names.add("November");
    names.add("December");
    return names.get(m - 1);
  }

  public static void main(String[] args) {
    System.out.println("Month 1 is called " + getMonthName(1));
    try { // Happy path in try
      String name = getMonthName(-1);
      System.out.println("Name of month -1 is " + name);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("processing exception: " + e);
    } catch (IllegalArgumentException ie) {
      System.out.println("got IE ... " + ie);
    }
    System.out.println("continuing...");
  }
}
