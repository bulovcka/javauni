package prac15;
import javax.swing.*;
import java.awt.*;

public class MenuExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Меню");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());


        JMenuBar menuBar = new JMenuBar();


        JMenu fileMenu = new JMenu("Файл");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem exitItem = new JMenuItem("Выйти");
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);


        exitItem.addActionListener(e -> System.exit(0));


        JMenu editMenu = new JMenu("Правка");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenuItem cutItem = new JMenuItem("Вырезать");
        JMenuItem pasteItem = new JMenuItem("Вставить");
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);


        JMenu helpMenu = new JMenu("Справка");
        JMenuItem aboutItem = new JMenuItem("О программе");
        helpMenu.add(aboutItem);


        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);


        JTextField textField = new JTextField("Введите текст здесь...");
        frame.add(textField, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Кнопка 1");
        JButton button2 = new JButton("Кнопка 2");

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        frame.add(buttonPanel, BorderLayout.CENTER);


        button1.addActionListener(e -> textField.setText("Вы нажали Кнопку 1"));
        button2.addActionListener(e -> textField.setText("Вы нажали Кнопку 2"));


        copyItem.addActionListener(e -> textField.copy());
        cutItem.addActionListener(e -> textField.cut());
        pasteItem.addActionListener(e -> textField.paste());


        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Пример программы с меню и кнопками" +
                "\nАвтор: Егыч"));


        frame.setVisible(true);
    }
}

