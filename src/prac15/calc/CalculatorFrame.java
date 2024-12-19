package prac15.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    private final JTextArea display;
    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";

    public CalculatorFrame() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JTextArea(2, 20);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        add(buttonPanel, BorderLayout.CENTER);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }
        setVisible(true);
    }

    //ActionListener
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789.".contains(command)) {
                if (command.equals(".")) {
                    if (currentInput.contains(".")) {
                        return;  // dots check
                    }
                }
                if (command.equals("0") && currentInput.equals("0")) {
                    return;  // 0 check
                }
                currentInput += command;
                display.setText(currentInput);
            } else if ("/*-+".contains(command)) {
                if (!currentInput.isEmpty()) {
                    firstOperand = Double.parseDouble(currentInput);
                }
                operator = command;
                currentInput = "";
            } else if ("=".equals(command)) {

                if (!currentInput.isEmpty() && !operator.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput);
                    double result = calculate(firstOperand, secondOperand, operator);
                    display.setText(String.valueOf(result));
                    if (result == Double.MAX_VALUE) { // div 0
                        display.setText("Hello World!");
                    } else {
                        display.setText(String.valueOf(result));
                    }
                    currentInput = "";
                    operator = "";
                }
            }
        }

        private double calculate(double a, double b, String operator) {
            switch (operator) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    if (b != 0) return a / b;
                    else {
                        display.setText("DIVISION BY ZERO");
                        return Double.MAX_VALUE;
                    }
                default:
                    return 0;
            }
        }
    }
}