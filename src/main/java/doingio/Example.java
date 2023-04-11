package doingio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example {
  public static void main(String[] args) throws IOException {
    FileReader fr = new FileReader("data.dat");
    BufferedReader input = new BufferedReader(fr);
    String line;

    while ((line = input.readLine()) != null) {
      System.out.println(">> " + line);
    }
    System.out.println("Finished");
  }
}
