package doingio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    FileReader fr = new FileReader("data.dat");
    BufferedReader input = new BufferedReader(fr);
    String line;

    while ((line = input.readLine()) != null) {
      System.out.println(">> " + line);
    }
    System.out.println("Finished");

  }
}
