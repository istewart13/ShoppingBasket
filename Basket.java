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

  public void addItem(Item item) {
    contents.add(item);
  }

  public void removeItem(Item item) {
    contents.remove(item);
  }

  public void empty() {
    contents.clear();
  }
}