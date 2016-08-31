public class Customer {
  private boolean hasLoyaltyCard;
  private String name;

  public Customer(boolean loyaltyCardHolder, String customerName) {
    this.hasLoyaltyCard = loyaltyCardHolder;
    this.name = customerName;
  }

  public boolean checkLoyaltyCard() {
    return this.hasLoyaltyCard;
  }

  public String getName() {
    return this.name;
  }
}