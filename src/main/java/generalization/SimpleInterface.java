package generalization;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

interface Named {
  // final does not prevent changing a mutable object
  // but it does prevent the reference referring to any other object
  static final StringBuilder sb = new StringBuilder("Weird");
  static final int ZERO = 0;
  /*public*/ static final String MESSAGE = "Greet Me, I have a name";
  /*public abstract*/ String getName(); // implicitly PUBLIC and ABSTRACT

  // since Java 8
  /*private */static void sayHello() { // implicitly public MAY be private
    System.out.println("Hello!");
  }
  // can have private for static or instance
  private/* static*/ void sayHelloToMe() { // instance method
    System.out.println("Hi, this is " + this.getName());
  }

//  void sayBonjourFriend(); // this would break existing implementations
  // instead, use a default method:
  // default methods are "fallback" implementations
  default void sayBonjourFriend() { // PUBLIC instance
    System.out.println("Bonjour, je m'appelle " + this.getName());
  }
}

// Java permits a comma separated list of interfaces
// (multiple interface "inheritance")
class Person implements Named/*, Serializable*/ {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean askToBorrowLawnmower() {
    return Math.random() > 0.5;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        '}';
  }


}

class Pet implements Named {
  private String petsName;

  public Pet(String petsName) {
    this.petsName = petsName;
  }

  public String getName() {
    return petsName;
  }

  public void setName(String petsName) {
    this.petsName = petsName;
  }

  @Override
  public String toString() {
    return "Pet{" +
        "petsName='" + petsName + '\'' +
        '}';
  }

  @Override
  public void sayBonjourFriend() {
    Named.super.sayBonjourFriend();
    System.out.println("Hi, sorry for my bad French!");
  }
}

public class SimpleInterface {
  public static void main(String[] args) {
    Person p1 = new Person("Fred");
    Person p2 = new Person("Fred");
//    new Named() // NOPE cannot instatiate an interface, nor an abstract class
    System.out.println(p1);
    System.out.println(p1.getName());
    System.out.println(p1.equals(p2));

    Pet pet1 = new Pet("Rover");
    System.out.println(pet1.getName());

    List<Named> thingsITalkTo =
        Arrays.asList(
          p1, p2, new Person("Albert"), pet1, new Pet("Toby")
        );
//        List.of(
//          p1, p2, new Person("Albert"), pet1, new Pet("Toby")
//      );

    for (Named n : thingsITalkTo) {
      System.out.println("Saying hello to: " + n.getName());
      n.sayBonjourFriend();
      // Standard "test and cast" works with all versions of Java
//      if (n instanceof Person) { // works with parent classes and interface
//        Person p = (Person)n;
//        System.out.println("Can I borrow lawnmower "
//            + p.askToBorrowLawnmower());
//      }

      // Pattern matching version of instanceof works since Java 16
      if (n instanceof Person p && p.askToBorrowLawnmower()) {
        System.out.println("Thanks for letting me borrow your lawnmower");
      }
//      else {
//        System.out.println(p);
//      }
    }
  }
}

/*
Lab: first choice, anything that interests you
 - If not done "Date" simple class lab, do that
 - Define classes for ParentWithCamera, SpySatellite
   - both have a method "takePhotograph(String subject)"
     implemented with a simple message "here's a picture..."
   - define an interface "Photographer", ensure both classes implement it
   - make a List<Photographer>, with data in it
   - iterate the list, calling takePhotograph on each object.
 */