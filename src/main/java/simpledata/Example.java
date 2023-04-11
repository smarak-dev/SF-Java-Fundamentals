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

    // 8 "primitive" types
    // boolean (true, false), byte (signed), short (signed),
    // char (unsigned -- 16 bit unicode), int (32 bit signed)
    // long (64 bit signed), float (32 bit IEEE 754 floating point 10^+/-32)
    // double (64 bit IEEE 754 10^ +/- 300??)
    //
    // variables are "strongly statically" typed (i.e. compiler
    // needs to know what we have
    int x = 99;
//    x = 3.14; // nope, not allowed
    // automatic promotion from smaller types to larger types
    long y = x;
    // other way round generally not allowed
//    x = y;
    // but we can "cast"
    x = (int)y;
    // Java can convert *anything* to text and does so
    // automatically if we concatenate anything with String
    // warning, the conversion is sometimes not helpful :)
    System.out.println("value of x is " + x);
//    y = 3_000_000_000; // too big for an int literal
    y = 3_000_000_000L; // capital L makes this a long literal
    double d = 3.14; // this is a DOUBLE literal
//    float f = 3.14; // nope, double doesn't fit
    float f = 3.14F; // F makes it a float literal

    x = (int)y; // "cast" -- dangerous
    System.out.println("value of x is " + x);

//    int count = (int)"32"; // some conversions are simply bogus
    // java allows "type inferencing" for local variables
    var count = x;
// NOPE var only works for method local variables
// and mostly they must be initialized right there
//    var bad;
//    count = "Nope";

    // operators:
    // + - * / (divide is integer or floating point depending on the operands)
    // java operator results are of the larger of the operand types
    // (but not less than int)

    // % - REMAINDER (not MOD)

    // comparisons (of primitives, and some others):
    // < > <= >= != == (equality is hard with non-primitives)

    // logical operations
    // && -- short circuiting AND
    // || -- short circuiting OR
    // ! negation

    // bitwise operators & AND, | OR, ~ bitwise inversion, ^ exclusive or


  }
}
