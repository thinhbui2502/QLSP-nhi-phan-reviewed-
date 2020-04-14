import java.util.ArrayList;
import java.util.Scanner;


public class ProductManagement {
    ArrayList<Product> productsList = new ArrayList<>();

    public void createList() {
        Product product1 = new Product("11", "Iphone 11", "Apple", 999);
        Product product2 = new Product("88", "Galaxy S10", "SanSung", 1089);
        Product product3 = new Product("33", "Reno2 F", "OPPO", 309);
        Product product4 = new Product("64", "Joy 3", "VSmart", 109);
        Product product5 = new Product("99", "BPhone 2", "BKAV", 589);
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);
        productsList.add(product4);
        productsList.add(product5);
    }

    public void addProduct() {
        Product product = new Product();
        product.inputData();
        productsList.add(product);
    }

    public void displayProduct() {
        System.out.printf("%-8s%-13s%-17s%-15s", "ID", "NAME", "MANUFACTURER", "PRICE ($)");
        try {
            for (Product product : productsList) {
                System.out.printf("\n%-8s%-13s%-17s%-15d", product.getID(), product.getName(), product.getManufacturer(), product.getPrice());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Product findByID(String id) {
        for (Product product : productsList) {
            if (product.getID().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void removeID(String id) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getID().equals(id)) {
                productsList.remove(productsList.get(i));
            }
        }
    }

    public Product replaceID(String id, Product product) {
        for (Product value : productsList) {
            if (value.getID().equals(id)) {
//                productsList.remove(productsList.get(i));
//                product = new Product ();
//                product.inputData();
//                productsList.add(i, product);
                value.setID(product.getID());
                value.setName(product.getName());
                value.setManufacturer(product.getManufacturer());
                value.setPrice(product.getPrice());
            }
        }
        return null;
    }

}
