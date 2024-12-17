package prac15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;


public class Calculator {
    private JFrame frame;
    private JTextField textField;
    private boolean Result = false;

    public Calculator() {
        frame = new JFrame("Calculator");
        textField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "(", ")", "C", "CE"
        };

        for (String btnText : buttons) {
            JButton button = new JButton(btnText);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false);

        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("C")){
                textField.setText("");
                Result = false;
            }else if(command.equals("CE")){
                if (textField.getText().length() > 0){
                    textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                }
            }else if(command.equals("=")){
                calculateResult();
            }else{
                handleInput(command);
            }
        }
        public void handleInput(String command) {
            if (Result){
                if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
                    textField.setText("");
                }
                Result = false;
            }

            String currentExp = textField.getText();
            if (!currentExp.isEmpty()) {
                char lastChar = currentExp.charAt(currentExp.length() - 1);
                if (isOperator(lastChar) && isOperator(command.charAt(0))) {
                    return;
                }
            }
            if (textField.getText().length() < 16) {
                textField.setText(textField.getText() + command);
            }
        }
        public boolean isOperator(char c) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                return true;
            }
            return false;
        }
        public void calculateResult() {
            String expression = textField.getText();
            if (expression.isEmpty()) return;

            try {
                double result = evaluateExpression(expression);
                textField.setText(String.valueOf(result));
                Result = true;
            } catch (Exception ex) {
                textField.setText("Error");
            }
        }
        public double evaluateExpression(String expression) {
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operations = new Stack<>();

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch == '-' && (i == 0 || expression.charAt(i - 1) == '(')) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('-');
                    i++;
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        sb.append(expression.charAt(i++));
                    }
                    i--;
                    numbers.push(Double.parseDouble(sb.toString()));
                } else if (Character.isDigit(ch) || ch == '.') {
                    StringBuilder sb = new StringBuilder();
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        sb.append(expression.charAt(i++));
                    }
                    i--;
                    numbers.push(Double.parseDouble(sb.toString()));
                } else if (ch == '(') {
                    operations.push(ch);
                } else if (ch == ')') {
                    while (operations.peek() != '(') {
                        numbers.push(applyOp(operations.pop(), numbers.pop(), numbers.pop()));
                    }
                    operations.pop();
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    while (!operations.isEmpty() && precedence(ch) <= precedence(operations.peek())) {
                        numbers.push(applyOp(operations.pop(), numbers.pop(), numbers.pop()));
                    }
                    operations.push(ch);
                }
            }

            while (!operations.isEmpty()) {
                numbers.push(applyOp(operations.pop(), numbers.pop(), numbers.pop()));
            }

            return numbers.pop();
        }
        public double applyOp(char op, double b, double a) {
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                    return a / b;
            }
            return 0;
        }

        public int precedence(char op) {
            if (op == '+' || op == '-') return 1;
            if (op == '*' || op == '/') return 2;
            return 0;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
