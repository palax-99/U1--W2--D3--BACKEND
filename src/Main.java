import entites.Costumer;
import entites.Order;
import entites.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(1L, "Java Book", "Books", 120.0);
        Product p2 = new Product(2L, "Baby Shoes", "Baby", 35.0);
        Product p3 = new Product(3L, "Clean Code", "Books", 45.0);
        System.out.println(p1);
        List<Product> prodotti = new ArrayList<>();
        prodotti.add(p1);
        prodotti.add(p2);
        List<Product> prodotti2 = new ArrayList<>();
        prodotti2.add(p3);
        prodotti2.add(p1);
        Costumer client1 = new Costumer(1L, "Gianni", 3);
        Costumer client2 = new Costumer(2L, "Mario", 2);
        Order orderB = new Order(2L, "DELIVERED", LocalDate.of(2026, 3, 10), LocalDate.of(2026, 4, 5), prodotti2, client2);
        Order orderA = new Order(1L, "SHIPPED", LocalDate.of(2026, 2, 15), LocalDate.of(2026, 3, 1), prodotti, client1);
        List<Order> orders = new ArrayList<>();
        orders.add(orderA);
        orders.add(orderB);
        List<Product> esercizio1 = orders.stream()
                .flatMap(order -> order.getProducts().stream()).filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100)
                .toList(); // fase dimpostazione del codice: parto trasformando la lista di ordini in uno stream, quindi ho una lista di stream List<Order> = [order A, order B] dopodichè uso flatMap, metodo che ho ritenuto piu che opportuno per ricavare i singoli prodotti
        // in quanto appiattisce tutto in uno steam di prodotti order(riferimento alla lista order) -> order.getProducts(prendiamo tutti i prodotti),stream(lo trasformiamo in uno stream di prodotti).filter(filtriamo i prodotti
        //product(riferimento dopo che abbiamo usatp flatMap) -> product.getCategory(leggiamo la categoria dei prodotti).equals(mettiamo la condizione che devono essere uguali a Books)(in quanto filter torna un booleano
        //stessa cosa per getPrice e usiamo .tolist(per ritrasformarlo in Lista, ma questa volta non tornerà una lista di ordini, ma una lista di prodottti)
        //In sostanza che cosa fa flatMap. flatMap prende la List<Product> contenuta in ogni Order e la trasforma in un unico Stream<Product> su cui posso lavorare con filter e map.
        esercizio1.forEach(product -> System.out.println(product));

    }
}