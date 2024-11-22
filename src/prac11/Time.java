package prac11;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Time {
    public static void task1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DAY_OF_MONTH, 29);
        cal.set(Calendar.YEAR, 2024);
        System.out.println("Задание выдано: " + sdf.format(cal.getTime()));
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 15);
        System.out.println("Задание сдано: " + sdf.format(cal.getTime()));
    }
    public static void task2(String date){
        try {
            LocalDate date1 = LocalDate.parse(date);
            LocalDate date2 = LocalDate.now();
            if (date1.isBefore(date2)) {
                System.out.println("Эта дата была до сегодняшнего дня");
            } else if (date1.isAfter(date2)) {
                System.out.println("Эта дата после сегодняшнего дня");
            } else {
                System.out.println("Эта дата сегодня");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Неверный ввод");
        }

    }

    public static void task3(){
        Student student = new Student("Иван Золо", LocalDate.of(2004, 11, 9));
        System.out.println(student.toString());
        System.out.println(student.getFormattedDOB("dd MMMM yyyy"));
        System.out.println(student.getFormattedDOB("yyyy-MM-dd"));
    }

    public static void task4(int year, int month, int day, int hour, int minute){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, hour, minute);
        System.out.println("Созданная дата (Calendar): " + cal.getTime());
        Date date = cal.getTime();
        System.out.println("Созданная дата (Date): " + date);
    }
    public static void task5(){
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new LinkedList<>();
        int n = 1000;
        Random r = new Random();
        for (int i = 0; i < n; i++){
            arr1.add(r.nextInt(n));
            arr2.add(r.nextInt(n));
        }
        long start, end;
        int val1 = 1000;
        start = System.nanoTime();
        arr1.add(arr1.size() / 2, val1);
        end = System.nanoTime();
        System.out.println("Время вставки ArrayList " + (end - start) + " ns");
        start = System.nanoTime();
        arr2.add(arr2.size() / 2, val1);
        end = System.nanoTime();
        System.out.println("Время вставки LinkedList " + (end - start) + " ns");
        start = System.nanoTime();
        arr1.remove(val1);
        end = System.nanoTime();
        System.out.println("Время удаления ArrayList " + (end - start) + " ns");
        start = System.nanoTime();
        arr2.remove(val1);
        end = System.nanoTime();
        System.out.println("Время удаления LinkedList " + (end - start) + " ns");
        start = System.nanoTime();
        arr1.add(val1);
        end = System.nanoTime();
        System.out.println("Время добавления элемента ArrayList " + (end - start) + " ns");
        start = System.nanoTime();
        arr2.add(val1);
        end = System.nanoTime();
        System.out.println("Время добавления элемента LinkedList " + (end - start) + " ns");
        start = System.nanoTime();
        arr1.contains(val1);
        end = System.nanoTime();
        System.out.println("Время поиска ArrayList " + (end - start) + " ns");
        start = System.nanoTime();
        arr2.contains(val1);
        end = System.nanoTime();
        System.out.println("Время поиска LinkedList " + (end - start) + " ns");


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задания: ");
        int task = sc.nextInt();
        switch (task){
            case 1:
                System.out.println("Task 1:");
                task1();
                break;
            case 2:
                sc.nextLine();
                System.out.println("Task 2:");
                System.out.println("Введите дату в формате yyyy-MM-dd");
                String a = sc.nextLine();
                task2(a);
                break;
            case 3:
                task3();
                break;
            case 4:
                sc.nextLine();
                System.out.println("Введите год");
                int year = sc.nextInt();
                System.out.println("Введите месяц 1 - 12");
                int month = sc.nextInt();
                System.out.println("Введите день");
                int day = sc.nextInt();
                System.out.println("Введите часы");
                int hour = sc.nextInt();
                System.out.println("Введите минуты");
                int minute = sc.nextInt();
                task4(year, month, day, hour, minute);
                break;
            case 5:
                task5();
                break;
        }
    }
}
