package doingio;

import java.io.*;

public class Example {
  public static void main(String[] args) throws IOException {
/*
Modify:
prompt the user for a filename
if the file exists, print its contents
if not... go back for another filename
 */
    BufferedReader keyboard = new BufferedReader(
        new InputStreamReader(System.in));
    // can now read lines from the keyboard

    boolean success = false;
    String filename = "Unset";
    while (! success) { // "repeat until successful"
      try {
        System.out.print("Enter filename: ");
        filename = keyboard.readLine();

        FileReader fr = new FileReader(filename);
        BufferedReader input = new BufferedReader(fr);
        String line;

        while ((line = input.readLine()) != null) {
          System.out.println(">> " + line);
        }
        System.out.println("Finished");
        success = true;
      } catch (FileNotFoundException fnfe) {
        System.out.println("oops,"
            + filename + " didn't open, please give another name");
      }
    }
  }
}
