package prac12;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class OnlineShop {

    private User user = new User("user", "password");
    private JFrame frame;
    private Cart cart = new Cart();
    private JLabel TimeLabel;
    private Timer timer;

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new OnlineShop().showLoginScreen());
    }

    public void showLoginScreen(){
        frame = new JFrame("Добро пожаловать в магазин");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(3 , 2));

        JLabel labellogin = new JLabel("Логин");
        JTextField fieldlogin = new JTextField();
        JLabel labelpassword = new JLabel("Пароль");
        JPasswordField passwordField = new JPasswordField();
        JButton loginbutton = new JButton("Войти");

        loginbutton.addActionListener(e -> {
           String login = fieldlogin.getText();
           String password = passwordField.getText();

           if (user.authenticate(login, password)) {
               showMainMenu();
           }else{
               JOptionPane.showMessageDialog(frame, "Неверный логин или пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
           }
        });
        frame.add(labellogin);
        frame.add(fieldlogin);
        frame.add(labelpassword);
        frame.add(passwordField);
        frame.add(loginbutton);
        frame.setVisible(true);
    }

    public void showMainMenu(){
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(4, 1));

        JLabel welocome = new JLabel("Добро пожаловать в магазин!");
        TimeLabel = new JLabel("", SwingConstants.CENTER);
        updateTime();

        JButton categoriesButton = new JButton("Посмотреть категории товаров");
        JButton cartButton = new JButton("Посмотреть корзину");

        categoriesButton.addActionListener(e -> {
           showCategories();
        });
        cartButton.addActionListener(e -> {
            showCart();
        });

        timer = new Timer(1000, e -> {
            updateTime();
        });
        timer.start();
        frame.add(welocome);
        frame.add(TimeLabel);
        frame.add(cartButton);
        frame.add(categoriesButton);
        frame.revalidate();
        frame.repaint();
    }

    private void updateTime(){
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        TimeLabel.setText(currentTime);
    }

    public void showCategories(){
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(Category.values().length + 1, 1));
        JLabel categoryLabel = new JLabel("Выберите категорию товаров", SwingConstants.CENTER);
        frame.add(categoryLabel);

        for (Category category : Category.values()) {
            JButton button = new JButton(category.name());
            button.addActionListener(e -> {
                showProducts(category);
            });
            frame.add(button);
        }

        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> {
            showMainMenu();
        });
        frame.add(backButton);
        frame.revalidate();
        frame.repaint();
    }
    public void showProducts(Category category){
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(Product.values().length + 1, 1));

        JLabel productsLabel = new JLabel("Товары в категории " + category, SwingConstants.CENTER);
        for (Product product : Product.values()) {
            if (product.category == category) {
                JButton button = new JButton(product.toString() + " -$" + product.getPrice());
                button.addActionListener(e -> {
                    cart.addProduct(product, LocalDateTime.now());
                    JOptionPane.showMessageDialog(frame, product + " добавлен в корзину");
                });
                frame.add(button);
            }
        }
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> {
            showMainMenu();
        });
        frame.add(productsLabel);
        frame.add(backButton);
        frame.revalidate();
        frame.repaint();
    }

    private void showCart(){
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(cart.getProducts().size() + 2, 1));
        JLabel cartLabel = new JLabel("Корзина");
        frame.add(cartLabel);

        for (CartItem item : cart.getProducts()) {
            frame.add(new JLabel(item.product.toString() + " -$" + item.product.getPrice() + " | Добавлено"
                    + item.addedTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))));
        }

        JButton checkoutButton = new JButton("Совершить покупку");
        checkoutButton.addActionListener(e -> {
            cart.checkout();
            JOptionPane.showMessageDialog(frame, "Покупка совершена");
            showMainMenu();
        });
        frame.add(checkoutButton);
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> {
            showMainMenu();
        });
        frame.add(backButton);
        frame.revalidate();
        frame.repaint();
    }

    enum Category{
        ELECTRONICS, CLOTHING, BOOKS;
    }
    enum Product{
        LAPTOP(OnlineShop.Category.ELECTRONICS, 1000),
        PHONE(OnlineShop.Category.ELECTRONICS, 500),
        T_SHIRT(OnlineShop.Category.CLOTHING, 20),
        JEANS(OnlineShop.Category.CLOTHING, 50),
        NOVEL(OnlineShop.Category.BOOKS, 10),
        COMICS(OnlineShop.Category.BOOKS, 15);

        private OnlineShop.Category category;
        private double price;

        Product(OnlineShop.Category category, double price) {
            this.category = category;
            this.price = price;
        }

        public OnlineShop.Category getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }
    }
}
