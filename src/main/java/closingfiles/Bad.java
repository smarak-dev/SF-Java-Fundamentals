package closingfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bad {
  public static void main(String[] args) {
//    while (true) {
//    for (;;) {

      // below doesn't work :(
//      try {
//        FileInputStream fis = new FileInputStream("data.dat");
//        fis.read(); // if this blows up with an excption..
//        int x = 99;
//        int y = x / 0; // throws DivisionByZeroError (unchecked)
//        System.out.print(".");
//        fis.close();
//      } catch (IOException io) {
//        fis.close();
//
//      }
//    }

//    while(true) {
//      FileInputStream fis = null;
//      try {
//        fis = new FileInputStream("data.dat");
//        fis.read(); // if this blows up with an excption..
//        int x = 99;
//        int y = x / 0; // throws DivisionByZeroError (unchecked)
//        System.out.print(".");
//      } catch (IOException io) {
//
//      } finally {
//        // this executes whether we:
//        // succeed normally
//        // throw an exception and catch it (fail and recover)
//        // throw an exception but don't catch it (unrecovered failure)
////        fis.close(); // ugly, throws another IOException
//      }
//    }

    // known as try-with-resources structure
    try ( // "resources" must "implement AutoCloseable"
      FileInputStream fis = new FileInputStream("data.dat");
      FileOutputStream fos = new FileOutputStream("output.dat")) {
      // happy path...
    } catch (IOException ioe) {
      System.out.println("oops: " + ioe.getMessage());
    } // Compiler auto-generates a finally (which runs before
    // any hand coded finally ) and it closes all resources
    // and any exceptions that need to be reported to the caller
    // will be reported
    // "first" exception to arise will be thrown, additional exceptions
    // are added as "suppressed" exceptions

  }
}
