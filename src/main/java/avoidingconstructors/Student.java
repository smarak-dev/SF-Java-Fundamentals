package avoidingconstructors;

import java.util.ArrayList;
import java.util.List;

public class Student {
  private String name;
  private int id;
  private List<String> courses;

  private Student() {}

  public static class Builder {
    private Student self = new Student();
    {
      self.courses = new ArrayList<>();
    }
    private Builder() {}
    public Builder name(String n) {
      self.name = n;
      return this;
    }
    public Builder id(int id) {
      self.id = id;
      return this;
    }
    public Builder course(String course) {
      self.courses.add(course);
      return this;
    }
    public Student build() {
      if (isValid(self.name, self.id, self.courses)) {
        Student rv = self;
        self = null;
        return rv;
      } else {
        throw new IllegalArgumentException("bad elements for a Student");
      }
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public static boolean isValid(String name, int id, List<String> courses) {
    return name != null && name.length() > 0
        && id > 0
        && courses.size() > 0;
    // maybe validate all elements of courses are real courses?
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", id=" + id +
        ", courses=" + courses +
        '}';
  }
}

class UseStudent {
  public static void main(String[] args) {
    Student fred = Student.builder()
        .course("Math")
        .id(1234)
        .name("Fred")
        .course("Physics")
        .build();
    System.out.println(fred);
  }
}