package usingrecords;

// option 1 for "quick classes" Third party library called "Lombok" (sp??)

// automatic creation of:
// - constructor matching "component list"
// - accessors matching component list (not using "get" convention)
// - toString
// - equals (and hashCode)
// DOES NOT provide "mutators", generated fields are final
// goal is "immutable data carriers"
record Customer(String name, int creditLimit) {
  // this is a class, can add
  // static fields, and methods
  // instance methods (but NOT FIELDS)
  // can also "modify" auto-generated behaviors provided we don't change
  // their essential "signature"

  @Override // NOTE no "super version" available - this is REPLACEMENT
  public String name() {
    return "My name is " + name;
  }
}

public class RecordExample {
  public static void main(String[] args) {
    Customer c1 = new Customer("Fred", 1000);
    System.out.println("Customer's name is " + c1.name());
    System.out.println(c1);
    Customer c2 = new Customer("Fred", 1000);
    System.out.println("c1.equals(c2) ? " + c1.equals(c2));
  }
}
