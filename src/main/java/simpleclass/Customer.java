package simpleclass;

// private fields (strong encapsulation) provides two major benefits:
// 1) limit the scope of code we must investigate when a field has a bad value
// 2) we can hide implementation details, which is good because we can CHANGE
//    the implementation without causing consequential changes elsewhere in
//    our clients
// "Limit the consequences of change"
// "extends" means is a subclass of...
// Object is the default parent if you don't specify any extends clause
public class Customer /*extends Object*/ {
  private String name;
  private long custId;
  private long creditLimit;
//  private String address;

  private static long nextCustId = 1;

  // if source code contains ZERO coded constructors,
  // compiler creates one that does "nothing" and takes no arguments
  // "constructor" -- actually an initializer
  public /* NO RETURN TYPE */
  Customer(String name, long custId, long creditLimit) {
    // validation:
    if (! isValid(name, custId, creditLimit)) {
      throw new IllegalArgumentException("Bad values for customer");
    }
    this.name = name;
    this.custId = custId;
    this.creditLimit = creditLimit;
  }

//  public Customer(String name, long creditLimit) {
//    if (! isValid(name, nextCustId, creditLimit)) {
//      throw new IllegalArgumentException("Bad values for customer");
//    }
//    this.name = name;
//    this.custId = nextCustId++;
//    this.creditLimit = creditLimit;
//  }
  public Customer(
      /*Customer this, NOPE, explicit receiver parameter NOT PERMITTED for constructor*/
      String name, long creditLimit) {
    this(name, nextCustId, creditLimit);
    nextCustId++;
  }

  // "Receiver parameter" (this) is permitted, but optional.
  // If present it MUST be called this, of EXACTLY the enclosing
  // type, and MUST BE FIRST
  // do this if you want to annotate the argument
  public String getName(/*@NotNull*/ Customer this) {
    return name;
  }

  public void setName(String name) {
    if (!isValid(name, this.custId, this.creditLimit)) {
      throw new IllegalArgumentException("Bad name");
    }
    this.name = name;
  }

  public long getCustId() {
    return custId;
  }

  public long getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(long creditLimit) {
    if (!isValid(this.name, this.custId, creditLimit)) {
      throw new IllegalArgumentException("Bad name");
    }
    this.creditLimit = creditLimit;
  }

  @Override
  public String toString() {
    return String.format("Customer %s, with id %d, and credit limit %d",
        this.name, this.custId, this.creditLimit);
  }

  public static boolean isValid(String name, long custId, long creditLimit) {
    return name != null && name.length() > 0
        && custId > 0 && creditLimit >= 0;
  }

  public boolean equals(Object other) {
//    if (other instanceof Customer) {
//      Customer c1 = (Customer)other;
//      return c1.name.equals(this.name) &&
//          c1.custId == this.custId;
//    }
//    return false;
    return other instanceof Customer c1
        && c1.name.equals(this.name)
        && c1.custId == this.custId;
  }

//  class OddBall {
//    private int count;
//  }
}

class UseCustomer {
  public static void main(String[] args) {
    Customer c = new Customer("Fred", 1234, 1000);
    Customer c2 = new Customer("Fred", 1234, 1000);
    System.out.println("are they equals() ?? " + c.equals(c2));
//    c.name = "Fred";
//    c.custId = 1234;
//    c.creditLimit = 1000;

    System.out.println("Customer is " + c);
    System.out.println("Customer name is " + c.getName());
//
//    System.out.println("Customer name is " + c.name);
//
//    c.creditLimit = -1000; // oops, that's not valid
  }

}

/*
Lab:
Create a Date class (calendar date)
- proper "hard" encapsulation:
  - implementation details are inaccessible to callers
  - no Date object ever exists that is not 100% valid
    (is this a leap year? how many days are in this month?)
- tomorrow() - which changes the date by one day
  (what if you wrap past the end of the month? or the end of the year?)
- toString for a "tidy" text representation
 */
