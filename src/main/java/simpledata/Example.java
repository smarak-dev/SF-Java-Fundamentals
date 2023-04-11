package simpledata;

// everything in java.lang is always imported implicitly
//import java.lang.System;
//import static java.lang.System.out;

// types:
// class, abstract class, interface (pure-abstract class),
// enum
// Java 17 records, ("sealed types")
public class Example {
  public static void sayHello() {
    System.out.println("this is a welcome message from a method :)");
  }

  public static void main(String [] args) {
    // text literals (aka "Strings" are surrounded with double quotes
    // single quotes identify characters (known as char)
//    java.lang.System.out.println("Hello Java World!");
    System.out.println("Hello Java World!");
//    out.println("Hello Java World!");

//    simpledata.Example.sayHello();
//    Example.sayHello(); // we're in the package simpledata :)
    sayHello(); // we're in the class Example :)
  }
}
