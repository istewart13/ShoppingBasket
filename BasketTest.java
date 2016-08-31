import org.junit.*;
import static org.junit.Assert.*;

public class BasketTest {

  // Basket basket;
  Customer customer;
  Customer customer2;
  Item item;

  @Before
  public void before() {
    customer = new Customer(true, "Bob");
    customer2 = new Customer(false, "Mary");
    item = new Item();
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
}