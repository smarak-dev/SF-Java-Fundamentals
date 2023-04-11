package manyofsomething;

import java.util.ArrayList;

public class Lists {
  public static void main(String[] args) {
    int a = 10;
    int b = 12;
    int c = 9;

    // Called "autoboxing"
    Integer five = 5; // creates a new Integer containing 5 (kindof!!)

    // these "general purpose" data structures hold
    // Objects / reference types
    // and NOT primitives
    // so can't do this:
//    ArrayList<int> numbers = new ArrayList();
    // <> stuff is called "generics"
    // but we can do this:
    ArrayList<Integer> numbers = new ArrayList();
    System.out.println(numbers);
    System.out.println(numbers.size());
    numbers.add(1); // append to end
    numbers.add(7);
    numbers.add(4);
// insert at position (remaining objects move right)
//    numbers.add(1, "Hello");
    System.out.println(numbers);
    System.out.println(numbers.size());

    System.out.println("item at position 1 is " + numbers.get(1));
    // auto-unboxing
    int numberAtPosOne = numbers.get(1);
  }
}
