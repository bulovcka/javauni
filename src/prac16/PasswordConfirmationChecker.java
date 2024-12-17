package prac16;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class PasswordConfirmationChecker {
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;
    private final JLabel resultLabel;

    public PasswordConfirmationChecker() {
        JFrame frame = new JFrame("Password Checker");

        JPanel mainPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        mainPanel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField(15);
        mainPanel.add(usernameField);

        mainPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        mainPanel.add(createPasswordPanel(passwordField));

        mainPanel.add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField(15);
        mainPanel.add(createPasswordPanel(confirmPasswordField));

        JButton checkButton = getjButton();
        mainPanel.add(checkButton);

        resultLabel = new JLabel("");
        mainPanel.add(resultLabel);

        frame.add(mainPanel);

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JButton getjButton() {
        JButton checkButton = new JButton("Check Password");
        checkButton.addActionListener(_ -> {
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (!password.equals(confirmPassword)) {
                resultLabel.setText("Passwords do not match!");

            } else if (password.length() < 8) {
                resultLabel.setText("Password must be at least 8 characters!");

            } else {
                resultLabel.setText("Password is valid.");

            }
        });
        return checkButton;
    }

    private JPanel createPasswordPanel(JPasswordField passwordField) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(passwordField, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        new PasswordConfirmationChecker();
    }
}
