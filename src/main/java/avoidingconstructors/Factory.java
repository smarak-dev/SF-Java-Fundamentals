package avoidingconstructors;

public class Factory {
  private String s;
  private int x;

  // A constructor invocation can ONLY
  // - return a NEW object of the EXACT type named
  // - OR throw an exception
  Factory(String s, int x) {
    this.s = s;
    this.x = x;
  }

  // A factory can:
  // - return a NEW object of the EXACT type named
  // - OR throw an exception
  // - OR return a pooled (pre-existing) object
  // - OR any assignment compatible object
  public static Factory of(String s, int x) {
    if (Math.random() > 0.5) {
      return new Factory(s, x);
    } else {
      return new Special();
    }
  }
}

class Special extends Factory {
  public Special() {
    super("x", 0);
  }
}
