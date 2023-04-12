package usingenums;

enum Suit {
  HEARTS, DIAMONDS, SPADES, CLUBS;
  // The rest of this is a (mostly) normal class body
}

public class CardGame {
//  public static boolean isTrumps(int suit) {
//    // 0 = Hearts, 1 = Diamonds, 2 = Spades, 3 = Clubs
//    return suit == 2; // spades are trumps
//  }

  public static boolean isTrumps(Suit suit) {
    // 0 = Hearts, 1 = Diamonds, 2 = Spades, 3 = Clubs
    return suit == Suit.SPADES; // spades are trumps
  }

  public static void main(String[] args) {
    int suit = 99;
//    System.out.println("is " + suit + " trumps? " + isTrumps(suit));
    System.out.println("is " + suit + " trumps? " + isTrumps(Suit.CLUBS));

    for (Suit s : Suit.values()) {
      System.out.println(">> " + s);
    }

    Suit s = Suit.valueOf("DIAMONDS");
    System.out.println(s);

    System.out.println(s == Suit.DIAMONDS);
  }
}
