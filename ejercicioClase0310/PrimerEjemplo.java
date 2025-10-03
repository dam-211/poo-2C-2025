public class Customer {
    private final String id;
    private String name;
    private final List<Order> orders = new ArrayList<>();
    public Customer(String id, String name) { this.id = id; this.name = name; }
    public void addOrder(Order o) { orders.add(o); }
}

public class Order {
    private final String number;
    private final LocalDate date;
    private final List<OrderItem> items = new ArrayList<>();
    public Order(String number, LocalDate date) { this.number = number; this.date = date; }
    public void addItem(Product p, int qty, Money price) { items.add(new OrderItem(this, p, qty, price)); }
    public Money total() { /* ... */ return null; }
}

public class OrderItem {
    private final Order order;
    private final Product product;
    private final int quantity;
    private final Money unitPrice;
    public OrderItem(Order order, Product product, int quantity, Money unitPrice) { /*...*/ }
}

public class Product {
    private String sku;
    private String name;
    private Money listPrice;
}

public final class Money {
    private final BigDecimal amount;
    private final Currency currency;
    public Money(BigDecimal amount, Currency currency) { /*...*/ }
}
