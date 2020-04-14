import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        productManagement.createList();
        showMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        selectMenu(productManagement, choice);
    }

    private static void selectMenu(ProductManagement productManagement, int choice) {
        try {
            while (choice >= 0 && choice <= 8) {
                switch (choice) {
                    case 0:
                        productManagement.displayProduct();
                        break;
                    case 1:
                        productManagement.addProduct();
                        break;
                    case 2:
                        ProductFile.writeProduct(productManagement.productsList, "product.txt");
                        break;
                    case 3:
                        ProductFile.readProduct("product.txt");
                        break;
                    case 4:
                        System.out.println("Enter the ID:");
                        Scanner sc = new Scanner(System.in);
                        String idToFind = sc.nextLine();
                        if (productManagement.findByID(idToFind)!=null) {
                            System.out.println(productManagement.findByID(idToFind));
                        } else {
                            System.out.println("Not available!");
                        }
                        break;
                    case 5:
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Enter the ID you want to remove: ");
                        String idForRemove = scanner.nextLine();
                        productManagement.removeID(idForRemove);
                        break;
                    case 6:
                        Scanner scan = new Scanner(System.in);
                        System.out.println("Enter the ID you want to replace: ");
                        String idForReplace = scan.nextLine();
                        Product product = new Product();
                        product.inputData();
                        productManagement.replaceID(idForReplace, product);
                        break;
                    case 7:
                        productManagement.productsList.sort(new Comparator<Product>() {
                            @Override
                            public int compare(Product product1, Product product2) {
                                return product1.getPrice() - product2.getPrice();
                            }
                        });
                        System.out.println("After sorting with comparator: ");
                        productManagement.displayProduct();
                        break;
                    case 8:
                        Collections.sort(productManagement.productsList);
                        System.out.println("After sorting with comparable: ");
                        productManagement.displayProduct();
                        break;

                    default:
                        System.out.println("Not available!");
                }
                System.out.println();
                System.out.println("What you want to do next?");
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    private static void showMenu() {
        System.out.println("MENU:");
        System.out.println("0. Print the current list");
        System.out.println("1. Add a product");
        System.out.println("2. Write to file");
        System.out.println("3. Read from file");
        System.out.println("4. Find by ID");
        System.out.println("5. Remove by ID");
        System.out.println("6. Replace by ID");
        System.out.println("7. Sorting by comparator");
        System.out.println("8. Sorting by comparable");
        System.out.println("What you want to do?");
    }
}

