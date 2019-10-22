import interfaces.Products;
import models.Product;

import java.util.ArrayList;
import java.util.List;

// Implement every single action (method) of the Products interface. HOW
public class ListProducts implements Products {

    private List<Product> products = new ArrayList();

    // When an instance of this class is created, we'll populate the
    // products array list with data, "faking" the records
    public ListProducts() {
        insert(new Product("hammer", 9.99));
        insert(new Product("screwdriver", 9.99));
        insert(new Product("drill", 19.99));
        insert(new Product("frame", 9.99));
    }

    // Persist a new record. We'll simulate this by adding the passed object
    // to our internal array list of products.
    // INSERT INTO products (Prod prod) values(X);
    public void insert(Product product) {
        this.products.add(product);
    }

//    Select * from products
    public List<Product> all() {
        return this.products;
    }

}
