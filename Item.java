public class Item {
  private boolean validForBogof;
  private String name;
  private int priceInPence;

  public Item(boolean bogof, String itemName, int price) {
    this.validForBogof = bogof;
    this.name = itemName;
    this.priceInPence = price;
  }

  public boolean isValidForBogof() {
    return this.validForBogof;
  }

  public String getName() {
    return this.name;
  }

  public int getPrice() {
    return this.priceInPence;
  }
}