//добавить календарь
package prac5;

import javax.swing.*;
import java.awt.*;

class OnlineShopGUI {

    // Пользовательские данные
    private User user = new User("erlan_c00l@mail.ru", "erlakrut228");
    private Cart cart = new Cart();
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OnlineShopGUI().showLoginScreen());
    }

    private void showLoginScreen() {
        frame = new JFrame("Вход в интернет-магазин");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel labelLogin = new JLabel("Логин:");
        JTextField fieldLogin = new JTextField();
        JLabel labelPassword = new JLabel("Пароль:");
        JPasswordField fieldPassword = new JPasswordField();
        JButton loginButton = new JButton("Войти");

        loginButton.addActionListener(e -> {
            String login = fieldLogin.getText();
            String password = new String(fieldPassword.getPassword());

            if (user.authenticate(login, password)) {
                showMainMenu();
            } else {
                JOptionPane.showMessageDialog(frame, "Неверный логин или пароль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(labelLogin);
        frame.add(fieldLogin);
        frame.add(labelPassword);
        frame.add(fieldPassword);
        frame.add(new JLabel());
        frame.add(loginButton);

        frame.setVisible(true);
    }

    private void showMainMenu() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(3, 1));

        JLabel welcomeLabel = new JLabel("Добро пожаловать в интернет-магазин!", SwingConstants.CENTER);
        JButton categoriesButton = new JButton("Просмотреть категории товаров");
        JButton cartButton = new JButton("Просмотреть корзину");

        categoriesButton.addActionListener(e -> showCategories());
        cartButton.addActionListener(e -> showCart());

        frame.add(welcomeLabel);
        frame.add(categoriesButton);
        frame.add(cartButton);

        frame.revalidate();
        frame.repaint();
    }

    private void showCategories() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(Category.values().length + 1, 1));

        JLabel categoryLabel = new JLabel("Выберите категорию товаров", SwingConstants.CENTER);
        frame.add(categoryLabel);

        for (Category category : Category.values()) {
            JButton button = new JButton(category.toString());
            button.addActionListener(e -> showProducts(category));
            frame.add(button);
        }

        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> showMainMenu());
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    private void showProducts(Category category) {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(Product.values().length + 1, 1));

        JLabel productsLabel = new JLabel("Товары в категории: " + category, SwingConstants.CENTER);
        frame.add(productsLabel);

        for (Product product : Product.values()) {
            if (product.getCategory() == category) {
                JButton button = new JButton(product.toString() + " - $" + product.getPrice());
                button.addActionListener(e -> {
                    cart.addProduct(product);
                    JOptionPane.showMessageDialog(frame, product + " добавлен в корзину!");
                });
                frame.add(button);
            }
        }

        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> showCategories());
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    private void showCart() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(cart.getProducts().size() + 2, 1));

        JLabel cartLabel = new JLabel("Корзина", SwingConstants.CENTER);
        frame.add(cartLabel);

        for (Product product : cart.getProducts()) {
            frame.add(new JLabel(product.toString() + " - $" + product.getPrice()));
        }

        JButton checkoutButton = new JButton("Оформить покупку");
        checkoutButton.addActionListener(e -> {
            cart.checkout();
            JOptionPane.showMessageDialog(frame, "Покупка успешно оформлена!");
            showMainMenu();
        });

        JButton backButton = new JButton("Назад");
        backButton.addActionListener(e -> showMainMenu());

        frame.add(checkoutButton);
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }


    enum Category {
        ELECTRONICS, CLOTHING, BOOKS
    }

    enum Product {
        LAPTOP(Category.ELECTRONICS, 1000),
        PHONE(Category.ELECTRONICS, 500),
        T_SHIRT(Category.CLOTHING, 20),
        JEANS(Category.CLOTHING, 50),
        NOVEL(Category.BOOKS, 10),
        COMICS(Category.BOOKS, 15);

        private Category category;
        private double price;

        Product(Category category, double price) {
            this.category = category;
            this.price = price;
        }

        public Category getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }
    }
}
