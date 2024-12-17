package prac16;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Game {
    private int target;
    private int attempts = 3;
    private JFrame frame;
    private JTextField textArea;
    private JButton button;
    private JLabel label;
    private JLabel attemptlabel;
    private Random random = new Random();

    public void game(){
        target = 13;
        frame = new JFrame("Угадай число");
        textArea = new JTextField(10);
        button = new JButton("Угадать");
        label = new JLabel("Введите число от 1 до 20:");
        attemptlabel = new JLabel("Осталось попыток: 3");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1, 10, 10));
        frame.add(label);
        frame.add(textArea);
        frame.add(button);
        frame.add(attemptlabel);
        frame.setSize(300, 200);
        frame.setVisible(true);

        button.addActionListener(e -> {
            try {
                int guess = Integer.parseInt(textArea.getText());
                if (guess < 1 || guess > 20){
                    label.setText("Неправильно введено число");
                }else{
                    attempts--;
                    if (guess < target){
                        label.setText("Ваше число меньше");
                    }else if(guess > target){
                        label.setText("Ваше число больше");
                    }else{
                        label.setText("Вы угадали");
                        endGame(true);
                    }
                    if (attempts > 0){
                        attemptlabel.setText("У вас осталось " + attempts + " попыток");
                    }else{
                        attemptlabel.setText("Вы проиграли, загаданное число " + target);
                        endGame(false);
                    }
                }
                textArea.setText("");
            } catch (Exception ex) {
                label.setText("Hello World!");
            }
        });

    }
    private void endGame(boolean end){
        textArea.setEnabled(false);
        button.setEnabled(false);
        if (!end) {
            label.setText("Игра окончена. Загаданное число: " + target);
        }
    }






    public static void main(String[] args){
        Game game = new Game();
        game.game();
    }
}
