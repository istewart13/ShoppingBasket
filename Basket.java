import java.util.*;

public class Basket {
  private ArrayList<Item> contents;
  private int total;


  public Basket() {
    this.contents = new ArrayList<Item>();
    this.total = 0;
  }

  public int getNumberOfItems() {
    return this.contents.size();
  }
}