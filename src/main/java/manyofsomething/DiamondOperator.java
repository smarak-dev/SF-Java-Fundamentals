package manyofsomething;

import java.util.ArrayList;
import java.util.Set;

public class DiamondOperator {
  public static void main(String[] args) {
    // Stuff in <> is specific to that particular "expression"
//    ArrayList<String> names = new ArrayList( // here there's no checks on RHS
//        Set.of("Fred", 99, LocalDate.now())
//    );

//    ArrayList<String> names = new ArrayList<String>( // now checking args of RHS
//        Set.of("Fred")
//    );

    // "diamond" says "make this E suitable for the context"
    // context consists of "what we are assigning to" and
    // the arguments here
    ArrayList<String> names = new ArrayList<>( // now checking args of RHS
        Set.of("Fred"/*, 99*/)
    );
    names.add("99");
    String s = names.get(0);
    System.out.println(s);
  }
}
