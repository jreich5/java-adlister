public class DaoFactory {
    private static Ads adsDao;
    private static Products productsDao;
    private static Users usersDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao();
        }
        return adsDao;
    }

    public static Products getProductsDao(){
        if(productsDao == null){
            productsDao = new ListOfProducts();
        }
        return productsDao;
    }

    public static Users getUsersDao(){
        if(usersDao == null){
            usersDao = new MySQLUsersDao();
        }
        return usersDao;
    }

}
