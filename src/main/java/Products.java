import java.util.List;

// WHAT
public interface Products {
    List<Product> all(); // get all the product records
    void insert(Product product); // persist new product to the database
}