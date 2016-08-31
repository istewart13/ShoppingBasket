import org.junit.*;
import static org.junit.Assert.*;

public class BasketTest {

  Basket basket;
  Customer customer;
  Customer customer2;
  Item item;
  Item item2;
  Item item3;
  Item item4;

  @Before
  public void before() {
    customer = new Customer(true, "Bob");
    customer2 = new Customer(false, "Mary");
    item = new Item(false, "spaghetti", 199);
    item2 = new Item(true, "tomato sauce", 299);
    item3 = new Item(true, "baked beans", 99);
    item4 = new Item(true, "fillet steak", 1899);
    basket = new Basket(customer);
  }

  @Test
  public void customerHasLoyaltyCard() {
    assertEquals(customer.checkLoyaltyCard(), true);
  }

  @Test
  public void customerDoesntHaveLoyaltyCard() {
    assertEquals(customer2.checkLoyaltyCard(), false);
  }

  @Test
  public void customerHasName() {
    assertEquals(customer.getName(), "Bob");
  }

  @Test
  public void itemIsNotValidForBogof() {
    assertEquals(item.isValidForBogof(), false);
  }

  @Test
  public void itemIsValidForBogof() {
    assertEquals(item2.isValidForBogof(), true);
  }

  @Test
  public void itemHasName() {
    assertEquals(item.getName(), "spaghetti");
  }

  @Test
  public void itemHasPrice() {
    assertEquals(item.getPrice(), 199);
  }

  @Test
  public void basketIsInitiallyEmpty() {
    assertEquals(basket.getNumberOfItems(), 0);
  }

  @Test
  public void canAddItemsToBasket() {
    basket.addItem(item);
    basket.addItem(item2);
    assertEquals(basket.getNumberOfItems(), 2);
  }

  @Test
  public void canRemoveItemsFromBasket() {
    basket.addItem(item);
    basket.addItem(item2);
    basket.removeItem(item2);
    assertEquals(basket.getNumberOfItems(), 1);
  }

  @Test
  public void canEmptyBasket() {
    basket.addItem(item);
    basket.addItem(item2);
    basket.empty();
    assertEquals(basket.getNumberOfItems(), 0);
  }

  @Test
  public void canFindBogofItems() {
    basket.addItem(item);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.findBogofItems();
    assertEquals(basket.getNumberOfBogofItems(), 2);
  }

  @Test
  public void canFindBasketTotal() {
    basket.addItem(item);
    basket.addItem(item4);
    assertEquals(basket.getTotal(), 2098, 0.001);
  }

  @Test
  public void canApply10PercentDiscount() {
    basket.addItem(item);
    basket.addItem(item4);
    basket.apply10PercentDiscount();
    assertEquals(basket.getTotal(), 1888.2, 0.001);
  }

  @Test
  public void canApplyLoyaltyDiscount() {
    basket.addItem(item);
    basket.addItem(item4);
    basket.applyLoyaltyDiscount();
    assertEquals(basket.getTotal(), 2056.04, 0.001);
  }

  @Test
  public void canApplyBogof() {
    basket.addItem(item);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.applyBogof();
    assertEquals(basket.getTotal(), 498, 0.001);
  }

  @Test
  public void canApplyAllDiscounts() {
    basket.addItem(item);
    basket.addItem(item2);
    basket.addItem(item3);
    basket.addItem(item4);
    basket.applyDiscounts();
    assertEquals(basket.getTotal(), 2114.154, 0.001);
  }
}