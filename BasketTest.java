import org.junit.*;
import static org.junit.Assert.*;

public class BasketTest {

  // Basket basket;
  Customer customer;

  @Before
  public void before() {
    customer = new Customer(true, "Bob");
  }

  @Test
  public void customerHasName() {
    assertEquals(customer.getName(), "Bob");
  }

  // @Test
  // public void customerHasLoyaltyCard() {

  // }
}