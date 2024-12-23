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
    private boolean isResultDisplayed = false;

    public CalculatorFrame() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JTextArea(2, 20);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        add(buttonPanel, BorderLayout.CENTER);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789.".contains(command)) {
                if (isResultDisplayed) {
                    currentInput = "";
                    isResultDisplayed = false;
                }
                if (command.equals(".")) {
                    if (currentInput.contains(".")) {
                        return; // Prevent multiple dots
                    }
                }
                currentInput += command;
                display.setText(currentInput);

            } else if ("/*-+".contains(command)) {
                if (!currentInput.isEmpty()) {
                    if (!operator.isEmpty()) {
                        firstOperand = calculate(firstOperand, Double.parseDouble(currentInput), operator);
                        display.setText(String.valueOf(firstOperand));
                    } else {
                        firstOperand = Double.parseDouble(currentInput);
                    }
                    operator = command;
                    currentInput = "";
                    isResultDisplayed = false;
                } else if (!operator.isEmpty()) {
                    operator = command; // Allow changing operator without entering second operand
                }

            } else if ("=".equals(command)) {
                if (!currentInput.isEmpty() && !operator.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput);
                    double result = calculate(firstOperand, secondOperand, operator);

                    if (result == Double.MAX_VALUE) {
                        display.setText("Hello World!");
                        currentInput = ""; // Clear invalid input
                    } else {
                        display.setText(String.valueOf(result));
                        currentInput = String.valueOf(result);
                        firstOperand = result;
                        isResultDisplayed = true;
                    }
                    operator = "";
                }
            } else if ("C".equals(command)) {
                currentInput = "";
                firstOperand = 0;
                operator = "";
                display.setText("");
                isResultDisplayed = false;
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
                    else return Double.MAX_VALUE;
                default:
                    return 0;
            }
        }
    }
}
