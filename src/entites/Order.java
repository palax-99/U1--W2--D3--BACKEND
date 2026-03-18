package entites;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Costumer costumer;

    public Order(long id, String status, LocalDate oderDate, LocalDate deliveryDate, List<Product> products, Costumer costumer) {
        this.id = id;
        this.status = status;
        this.orderDate = oderDate;
        this.deliveryDate = deliveryDate;
        this.products = products; // riceve la lista, non la crea
        this.costumer = costumer; // riceve il cliente, non lo crea
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", costumer=" + costumer +
                '}';
    }
}

