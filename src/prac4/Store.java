package prac4;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

enum Category {
    ELECTRONIC, CLOTHING, BOOKS
}

enum Products {
    LAPTOP(Category.ELECTRONIC, 1000),
    PHONE(Category.ELECTRONIC, 350),
    T_SHIRT(Category.CLOTHING, 200),
    JEANS(Category.CLOTHING, 150),
    NOVEL(Category.BOOKS, 75),
    COMICS(Category.BOOKS, 50);

    private final Category category;
    private final double price;
    Products(Category category, double price){
        this.category = category;
        this.price = price;
    }
    public Category getCategory(){
        return category;
    }
    public double getPrice(){
        return price;
    }
}
class User{
    private final String login;
    private final String password;
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    public boolean authenticate(String login, String password){
        return this.login.equals(login) && this.password.equals(password);
    }

}
class Cart{
   private final List<Products> products = new ArrayList<>();
   public void addToCart(Products product){
       products.add(product);
       System.out.println(product + " Added to Cart");
   }
   public void checkout(){
       if (products.isEmpty()){
           System.out.println("Cart is Empty");
           return;
       }

       double total = 0;
       System.out.println("Purchase");
       for (Products product : products){
           System.out.println(product + " - $" + product.getPrice());
           total += product.getPrice();
       }
       System.out.println("Total: " + total);
       products.clear();
   }
   public void viewCart(){
       if (products.isEmpty()){
           System.out.println("Cart is Empty");
       }else {
           for (Products product : products) {
               System.out.println(product + " - $" + product.getPrice());
           }
       }
   }

}

public class Store {
    private final Scanner sc = new Scanner(System.in);
    private final Cart cart = new Cart();
    private final User user = new User("User", "password");


    public void start(){
        if(!authenticateUser()) {
            System.out.println("Invalid Username and password");
            return;
        }
        System.out.println("Welcome to the shop!");
        while (true){
            System.out.println("Choose your option");
            System.out.println("1. View Categories");
            System.out.println("2. View Products");
            System.out.println("3. Add to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Purchase");
            System.out.println("6. Exit");
            int choice = 0;
            if (sc.hasNextInt()){
                choice = sc.nextInt();
                sc.nextLine();
            }else{
                System.out.println("Invalid input");
                sc.nextLine();
                continue;
            }
            switch(choice){
                case 1:
                    viewCategories();
                    sc.next();
                    break;
                case 2:
                    viewProductsByCategory();
                    break;
                case 3:
                    addToCart();
                    break;
                case 4:
                    cart.viewCart();
                    break;
                case 5:
                    cart.checkout();
                    System.out.println("Thank you for using Shop!");
                    break;
                case 6:
                    System.out.println("See you next time!");
                    return;
                default:
                    System.out.println("Invalid choice");

            }
        }

    }
    private boolean authenticateUser(){
        System.out.println("Enter username ");
        String login = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();
        return user.authenticate(login, password);
    }
    private void viewCategories(){
        System.out.println("Categories");
        for (Category category : Category.values()){
            System.out.println("- " + category);
        }
    }
    private void viewProductsByCategory(){
        System.out.println("Enter product category");
        for (Category category : Category.values()){
            System.out.println("- " + category);
        }
        String categoryIn = sc.nextLine().toUpperCase();
        Category category;
        try{
            category = Category.valueOf(categoryIn);
        }catch(IllegalArgumentException e){
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Goods in category" + category + ":");
        for (Products product : Products.values()){
            if (product.getCategory() == category){
                System.out.println(product + " - $" + product.getPrice());
            }
        }

    }
    private void addToCart(){
        System.out.println("Enter name of good");
        String productIn = sc.nextLine().toUpperCase();

        Products product;
        try{
            product = Products.valueOf(productIn);
        }catch(IllegalArgumentException e){
            System.out.println("Invalid input");
            return;
        }
        cart.addToCart(product);
    }
}

