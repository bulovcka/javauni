package prac19_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LabClassUI {
    private LabClass labClass;

    public LabClassUI(LabClass labClass) {
        this.labClass = labClass;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Поиск студента по ФИО");
            System.out.println("2. Сортировка студентов по среднему баллу");
            System.out.println("3. Показать всех студентов");
            System.out.println("4. Выход");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Введите ФИО студента:");
                        String name = scanner.nextLine();
                        try {
                            Student student = labClass.findStudentByName(name);
                            System.out.println("Найден студент: " + student);
                        } catch (StudentNotFoundException | EmptyStringException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        labClass.sortStudentsByAverageGrade();
                        System.out.println("Студенты отсортированы по среднему баллу.");
                        break;
                    case 3:
                        for (Student s : labClass.getStudents()) {
                            System.out.println(s);
                        }
                        break;
                    case 4:
                        System.out.println("Выход из программы.");
                        return;
                    default:
                        System.out.println("Некорректный ввод. Попробуйте еще раз.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число от 1 до 4.");
                scanner.nextLine();
            }
        }
    }
}
