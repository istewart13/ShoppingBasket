public class Item {
  private boolean validForBogof;
  private String name;

  public Item(boolean bogof, String itemName) {
    this.validForBogof = bogof;
    this.name = itemName;
  }

  public boolean isValidForBogof() {
    return this.validForBogof;
  }
}