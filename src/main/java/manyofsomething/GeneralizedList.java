package manyofsomething;

import java.util.ArrayList;
// called an "interface" -- can't make one
// but you can make a thing that "implements" this
// in other words ArrayList LinkedList provide the
// interactions promised by this description
import java.util.LinkedList;
import java.util.List;

public class GeneralizedList {
  public static void showAll(List<String> al) {
    System.out.println("contents:");
    for (String s : al) {
      System.out.println("> " + s);
    }
    System.out.println("---------");
  }
  public static void main(String[] args) {
//    List<String> names = new ArrayList<>(List.of(
//        "Fred", "Jim", "Sheila"
//    ));

//    List<String> names = new LinkedList<>(
//        List.of("Fred", "Jim", "Sheila")
//    );

    // BUT!!!!
    // List.of creates an "UNMODIFIABLE" List
    // that is, it rejects any attempt to change the elements
    List<String> names = List.of("Fred", "Jim", "Sheila");

    System.out.println(names);
    showAll(names);
  }
}
