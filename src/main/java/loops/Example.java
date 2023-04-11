package loops;

import java.util.ArrayList;

public class Example {
  public static void main(String[] args) {
    int x = 0;
    while (x < 4) {
      System.out.println("x is " + x);
      x++;
    }
    System.out.println("---------");
    do {
      System.out.println("x is now " + x);
    } while (x != 4);
    System.out.println("---------");
    for (int x1 = 0; x1 < 4; x1++) {
      System.out.println("x1 is " + x1);
    }
    System.out.println("---------");
    ArrayList<String> names = new ArrayList();
    names.add("Fred");
    names.add("Jim");
    names.add("Sheila");
    // the "old" way
    for (int idx = 0; idx < names.size(); idx++) {
      System.out.println("> " + names.get(idx));
    }
    // only for "many" of something
    for (String n1 : names) { // this loop doesn't maintain "index"
      System.out.println(">> " + n1);
    }
  }
}
