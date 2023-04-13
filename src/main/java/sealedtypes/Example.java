package sealedtypes;

// if all elements of a sealed type hierachy are in the same
// source file, we can omit "permits" -- shortcut for development
// Unless you're using JPMS, all members of a sealed hierachy
// must be in the same package
sealed interface Transport permits Car, Truck {}
// all members of a sealed hierachy must be either:
// sealed (and have "permits")
// non-sealed (which expressly breaks open the hierachy!)
// final (which prevents any subclassing (must be a concrete class)
// OR: record (implicitly final), enum
final class Car implements Transport {}
// probably bad. Don't use non-sealed as a mainstream thing!
class Semi extends Truck {}
non-sealed class Truck implements Transport {} // no control any more!!!

//class Bicycle implements Transport {}

public final class Example {
  public static void main(String[] args) {
    Transport t = new Truck();

    // "coming soon!!!" (preview feature in `17-20)
    // switch that can switch on types -- one variant
    // can check for "complete coverage"
    if (t instanceof Car c) {

    } else if (t instanceof Truck tr) {

    }
  }
}
