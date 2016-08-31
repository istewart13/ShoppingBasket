import org.junit.*;
import static org.junit.Assert.*;

public class BasketTest {

  Basket basket;
  Customer customer;
  Customer customer2;
  Item item;
  Item item2;

  @Before
  public void before() {
    customer = new Customer(true, "Bob");
    customer2 = new Customer(false, "Mary");
    item = new Item(false, "spaghetti", 199);
    item2 = new Item(true, "tomato sauce", 299);
    basket = new Basket();
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
}