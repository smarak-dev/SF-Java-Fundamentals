package manyofsomething;

import java.util.Arrays;

public class SimpleArray {
  public static void main(String[] args) {
    // all objects, including arrays are initialized
    // to "zero-like" values on construction (if not more)
    // NOTE local variables are NOT objects -- they REFER to objets
    String [] names = new String[3];
    int x = names.length;
    System.out.println(x);
    System.out.println(names[0]);
    names[0] = "Fred";
    names[1] = "Jim";
    names[2] = "Sheila";
    System.out.println("The array is " + names);
    System.out.println("Oh, wait, the array is " + Arrays.toString(names));

    for (int idx = 0; idx < names.length; idx++) {
      System.out.println("> " + names[idx]);
    }
    System.out.println("-------------");
    for (String s : names) {
      System.out.println(">> " + s);
    }

    String [] moreNames = new String[4];
    System.arraycopy(names, 0, moreNames, 0, names.length);
    moreNames[3] = "Alice";
    System.out.println("names: " + Arrays.toString(names));
    System.out.println("moreNames: " + Arrays.toString(moreNames));
    names = moreNames;
    System.out.println("AFTER:");
    System.out.println("names: " + Arrays.toString(names));
    System.out.println("moreNames: " + Arrays.toString(moreNames));

    String [] yetMoreNames = {
        "Alice", "Bob", "Chuck", "Danni", "Eve", "Frankie"
    };
    System.out.println(Arrays.toString(yetMoreNames));
  }
}
