package generalization;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;

class Base {
  private String name = "Fred"; // RHS must be an *expression*
  String message;
  { // instance initializer--allows
    // initialization without the restriction of "must be an expression"
    System.out.println("Running instance initializer");
    message = "look this up in a database";
  }
  public Base(String name) {
    this.name = name;
  }
  private static String getAValue() {
    System.out.println("in getAValue()");
    return "Value!";
  }
  String message2 = getAValue();
  {
    System.out.println("another instance initializer...");
    message2 += ", and I changed it";
  }

  public String getName() /*throws Exception*/ {
    return name;
  }
}

// only one parent class... (single implementation inheritance)
// extends clause first, implements second (permits third)
class Sub extends Base /*implements Serializable, ...*/ {
  public static String getMessage() {
    return "Block of code";
  }

  public Sub() {
    // No code allowed here
//    super("Block" + " of code"); // OK
    // this() or super() first
    // MUST NOT create circularity
    super(getMessage()); // OK if static!
    // ON RETURN from super()
    // run instance initialization
    // then the body of our constructor
    System.out.println("In Sub() constructor, message (in Base) is "
        + this.message + "\nmessage2 is " + message2);
    // NOT OK, must not refer to this implicitly or expliclty
//    super(this.getMessage());

    // continue with our own initialization
  }

  //  }
// "default" / automatically generated constructor
// ONLY if no explicit constructor
// amounts to
//  public Sub() {
//    super();

// NOPE, return type must be "compatible"
// for reference types, must be assignment compatible (subtype)
// i.e. covariant return types for reference types NOT primitive
// for primitives must be THE SAME
//  public LocalDate getName() {

// overriding method must NOT BE LESS ACCESSIBLE
//  String getName() { // nope, parent is public

// overriding method must not declare throwing of any checked exception
// that isn't declared (directly or indirectly) by the parent
  public String getName() /*throws SQLException*/  {
    return "Hello, I am " + super.getName();
  }
}

public class ParentAndChild {
  public static void main(String[] args) {
//    Base b = new Base();
    // new allocates and zeroes memory for the entire object
    // then invokes the matching constructor, passing the object
    // as the implicit "this" receiver parameter
    Base b = new Sub();

    System.out.println(b.getName());
  }
}

/*
Java access levels -- most restricted to least
- local variable! ONLY accessible inside this method for this invocation
- private -- inside enclosing TOP LEVEL curly braces (nested classes)
- "nothing specified" aka "default"
  - in an interface this means public!
    [interface stuff is ONLY private or public]
  - in an enum constructor this means private!
  - generally means "anywhere in the same package"
- protected - same package PLUS in subclasses through
  a reference of the subclass type
- public -- (unless under Module system JPMS) anywhere in the running JVM
*/