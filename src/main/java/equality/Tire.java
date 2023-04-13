package equality;

public class Tire {
  int diameter;
  int width;

  public Tire(int diameter, int width) {
    this.diameter = diameter;
    this.width = width;
  }

  @Override
//  public boolean equals(Object other) {
//    return other instanceof Tire tire
//        && tire.diameter == this.diameter
//        && tire.width == this.width;
//  }
  public boolean equals(Object other) {
    // this form fixes the "reflexive" property, but
    // breaks Liskov substitution.
    // other approaches:
    // 1) make classes final, don't do subtyping!
    // 2) make equals method final, so we only ever
    //    perform this one type of test
    if (other.getClass() == this.getClass()) {
      Tire tire = (Tire) other;
      return tire.diameter == this.diameter
          && tire.width == this.width;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "Tire{" +
        "diameter=" + diameter +
        ", width=" + width +
        '}';
  }
}

class TruckTire extends Tire {
  int loadRating;

  public TruckTire(int diameter, int width, int loadRating) {
    super(diameter, width);
    this.loadRating = loadRating;
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof TruckTire tt
        && tt.loadRating == this.loadRating
        && super.equals(tt);
  }

  @Override
  public String toString() {
    return "TruckTire{" +
        "loadRating=" + loadRating + ", " + super.toString() +
        '}';
  }
}

class TestStuff {
  public static void main(String[] args) {
    Tire t1 = new Tire(14, 155);
    Tire t2 = new Tire(14, 155);
    Tire t3 = new Tire(15, 155);
    System.out.println("t1.equals(t2) " + t1.equals(t2));
    System.out.println("t1.equals(t3) " + t1.equals(t3));

    Tire tt1 = new TruckTire(14, 155, 10);
    Tire tt2 = new TruckTire(14, 155, 14);
    Tire tt3 = new TruckTire(14, 155, 10);
    System.out.println("t1.equals(tt1) " + t1.equals(tt1));
    System.out.println("tt1.equals(t1) " + tt1.equals(t1));

    System.out.println("tt1.equals(tt2) " + tt1.equals(tt2));
    System.out.println("tt1.equals(tt3) " + tt1.equals(tt3));

  }
}
