import interfaces.Products;

// Gate keeper
public class DaoFactory {
    static private Products productsDao;

    public static Products getProductsDao() {
        if (productsDao == null) {
            // A
            productsDao = new ListProducts(); // B

        }
        return productsDao;
    }
}