package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OpenAFile {
  public static void tryToOpen(String filename)
      throws FileNotFoundException {
    new FileReader(filename);
  }

  public static boolean fileOpensOK(String filename) {
    try {
//      FileReader fr = new FileReader(filename);
      tryToOpen(filename);
      return true;
    } catch (FileNotFoundException fnfe) {
//    } catch (IOException fnfe) {
//    } catch (Exception fnfe) {
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println("Can open data.dat " + fileOpensOK("data.dat"));
  }
}
