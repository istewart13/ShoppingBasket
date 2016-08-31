import java.util.*;

public class Basket {
  private ArrayList<Item> contents;
  private ArrayList<Item> bogofItems;
  private double total;
  private Customer customer;

  public Basket(Customer customer) {
    this.contents = new ArrayList<Item>();
    this.bogofItems = new ArrayList<Item>();
    this.total = 0;
    this.customer = customer;
  }

  public int getNumberOfItems() {
    return this.contents.size();
  }

  public int getNumberOfBogofItems() {
    return this.bogofItems.size();
  }

  public void addItem(Item item) {
    contents.add(item);
    total += item.getPrice();
  }

  public void removeItem(Item item) {
    contents.remove(item);
  }

  public void empty() {
    contents.clear();
  }

  public double getTotal() {
    return this.total;
  }

  public void applyBogof() {
    findBogofItems();
    sortBogofItems();
    while (bogofItems.size() > 1) {
      this.total -= bogofItems.get(0).getPrice();
      bogofItems.remove(bogofItems.size() - 1);
      bogofItems.remove(0);
    }
  }

  public void findBogofItems() {
    for (int i = 0; i < this.contents.size(); i++) {
      if (contents.get(i).isValidForBogof() == true) {
        bogofItems.add(contents.get(i));
      }
    }
  }

  public void sortBogofItems() {
    Collections.sort(bogofItems, new Comparator<Item>() {
        @Override
        public int compare(Item item1, Item item2) {
          return item1.getPrice() - item2.getPrice();
        }
    });
  }

  public void apply10PercentDiscount() {
    if (this.total > 20) {
      this.total = this.total * 0.9;
    }
  }

  public void applyLoyaltyDiscount() {
    if (this.customer.checkLoyaltyCard() == true) {
      this.total = this.total * 0.98;
    }
  }

  public void applyDiscounts() {
    applyBogof();
    apply10PercentDiscount();
    applyLoyaltyDiscount();
  }
}