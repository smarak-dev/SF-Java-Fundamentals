package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// checks that the following interface will work as a lambda
@FunctionalInterface
interface CriterionOfStudent { // Must be an interface for a lambda
  boolean test(Student s); // NOTICE this has exactly one abstract method
}

class SmartCriterion implements CriterionOfStudent {
  @Override
  public boolean test(Student s) {
    return s.getGpa() > 3.0;
  }
}
public final class Student {
  private String name;
  private double gpa;

  public Student(String name, double gpa) {
    this.name = name;
    this.gpa = gpa;
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        '}';
  }
}

class UseLambdas {
  public static <E> void showAll(List<E> ls) {
    System.out.println("Things:");
    for (E s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("------------");
  }

  // getEnthusiastic s.getCourses().size() > threshold

//  public static List<Student> getSmart(
//      List<Student> ls, double threshold) {
//    List<Student> res = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.getGpa() > threshold) {
//        res.add(s);
//      }
//    }
//    return res;
//  }

  public static List<Student> getByCriterion(
      List<Student> ls, CriterionOfStudent crit) {
    List<Student> res = new ArrayList<>();
    for (Student s : ls) {
      if (crit.test(s)) {
        res.add(s);
      }
    }
    return res;
  }

  public static <E> List<E> filter(
      List<E> ls, Predicate<E> crit) {
    List<E> res = new ArrayList<>();
    for (E s : ls) {
      if (crit.test(s)) {
        res.add(s);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    List<Student> roster = List.of(
        new Student("Fred", 3.2),
        new Student("Jim", 2.2),
        new Student("Sheila", 3.8)
    );
    System.out.println("All");
    showAll(roster);
    System.out.println("Smart");
//    showAll(getSmart(roster, 3.0));
    showAll(getByCriterion(roster, new SmartCriterion()));
//    System.out.println("Very smart");
//    showAll(getSmart(roster, 3.5));
    System.out.println("First half of alphabet");
    showAll(getByCriterion(roster,
        new CriterionOfStudent() {
          @Override
          public boolean test(Student s) {
            return s.getName().charAt(0) <= 'M';
          }
        }
    ));
    System.out.println("Last half of alphabet");
//    showAll(getByCriterion(roster,
//        /*new CriterionOfStudent() {
//          @Override
//          public boolean test*/(Student s) -> {
//            return s.getName().charAt(0) <= 'M';
//          }
//        /*}*/
//    ));
    showAll(getByCriterion(roster,
//          (Student s) -> { return s.getName().charAt(0) > 'M'; }
//          (var s) -> { return s.getName().charAt(0) > 'M'; }
//          s -> { return s.getName().charAt(0) > 'M'; }
          s -> s.getName().charAt(0) > 'M'
    ));
    showAll(filter(roster, s -> s.getName().charAt(0) > 'M'));

    System.out.println("Long names");
    showAll(filter( // also find filter in Stream...
        List.of("FRed", "Jim", "Sheila", "Alice"),
        s -> s.length() > 4
    ));

  }
}
