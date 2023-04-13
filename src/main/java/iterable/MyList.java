package iterable;

import java.util.Iterator;

public class MyList<E> implements Iterable<E> {
  private E[] data = (E[])new Object[10];
  private int count = 0;

  public void add(E e) {
    data[count++] = e; // what about overflow!!!
  }

  private static class MyIterator<E> implements Iterator<E> {
    private int progress = 0;
    private MyList<E> target;

    public MyIterator(MyList<E> t) {
      target = t;
    }

    @Override
    public boolean hasNext() {
      return progress < target.count;
    }

    @Override
    public E next() {
      return target.data[progress++];
    }
  }

  public Iterator<E> iterator() {
    return new MyIterator<E>(this);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("MyList[");
    for (int idx = 0; idx < count; idx++) {
      sb.append(data[idx] + ", ");
    }
    sb.setLength(sb.length() - 2);
    sb.append("]");
    return sb.toString();
  }
}

class TryMyList {
  public static void main(String[] args) {
    MyList<String> names = new MyList<>();
    names.add("Fred");
    names.add("Jim");
    names.add("Sheila");
    System.out.println(names);

    for (String s : names) {
      System.out.println(">> " + s);
    }
  }
}